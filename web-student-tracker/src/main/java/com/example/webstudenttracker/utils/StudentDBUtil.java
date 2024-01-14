package com.example.webstudenttracker.utils;

import com.example.webstudenttracker.models.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDBUtil {

    private final DataSource dataSource;

    public StudentDBUtil(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // get a connection
            connection = dataSource.getConnection();

            // create a sql statement
            String sql = "select * from student order by last_name";

            statement = connection.createStatement();

            // execute query
            resultSet = statement.executeQuery(sql);

            // process result set
            while (resultSet.next()){

                // retrieve data from result set row
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                // create new student object
                Student tempStudent = new Student(id, first_name, last_name, email);

                // add it to the list of students
                students.add(tempStudent);
            }

        }
        finally {
            //close JDBC objects
            close(connection, statement, resultSet);
        }

        return students;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();  // doesn't really close it. Just puts back in connection pool
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }


    public void addStudent(Student theStudent) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get db connection
            connection = dataSource.getConnection();

            // create sql statement
            String sql = "insert into student " +
                    "(first_name, last_name, email) " +
                    "values (?, ?, ?)";

            statement = connection.prepareStatement(sql);

            // set the param values for the student
            statement.setString(1, theStudent.getFirst_name());
            statement.setString(2, theStudent.getLast_name());
            statement.setString(3, theStudent.getEmail());

            // execute sql insert
            statement.execute();

        }
        finally {
            // clean up JDBC objects
            close(connection, statement,null);
        }
    }

    public Student getStudentById(String theStudentId) throws Exception {

        Student theStudent;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int studentId;

        try {
            // convert student id to int
            studentId = Integer.parseInt(theStudentId);

            // get connection to database
            connection = dataSource.getConnection();

            // create sql to get selected student
            String sql = "select * from student where id=?";

            // create prepared statement
            preparedStatement = connection.prepareStatement(sql);

            // set params
            preparedStatement.setInt(1, studentId);

            // execute statement
            resultSet = preparedStatement.executeQuery();

            // retrieve data from result set row
            if(resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                // use the studentId during construction
                theStudent = new Student(studentId, firstName, lastName, email);
            }
            else {
                throw new Exception("Could not find student id: " + studentId);
            }

            return theStudent;
        }
        finally {
            // clean up JDBC objects
            close(connection, preparedStatement, resultSet);
        }

    }

    public void updateStudent(Student theStudent) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get db connection
            connection = dataSource.getConnection();

            // create sql update statement
            String sql = "update student set first_name=?, last_name=?, email=? where id=?";

            // prepare statement
            statement = connection.prepareStatement(sql);

            // set params
            statement.setString(1, theStudent.getFirst_name());
            statement.setString(2, theStudent.getLast_name());
            statement.setString(3, theStudent.getEmail());
            statement.setInt(4, theStudent.getId());

            // execute sql statement
            statement.execute();

        }
        finally {
            // clean up JDBC objects
            close(connection, statement,null);
        }
    }
}
