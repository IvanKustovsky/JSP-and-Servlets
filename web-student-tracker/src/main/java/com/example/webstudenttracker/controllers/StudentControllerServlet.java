package com.example.webstudenttracker.controllers;

import com.example.webstudenttracker.models.Student;
import com.example.webstudenttracker.utils.StudentDBUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDBUtil studentDBUtil;

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util... and pass in the connection pool / datasource
        try {
            studentDBUtil = new StudentDBUtil(dataSource);
        } catch (Exception exception) {
            throw new ServletException(exception);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listStudents(request, response);
                    break;

                case "LOAD":
                    loadStudent(request, response);
                    break;

                case "UPDATE":
                    updateStudent(request, response);
                    break;

                case "DELETE":
                    deleteStudent(request, response);
                    break;

                case "SEARCH":
                    searchStudents(request, response);
                    break;

                default:
                    listStudents(request, response);
            }

            // list the students... in MVC fashion
            listStudents(request, response);
        } catch (Exception exception) {
            throw new ServletException(exception);
        }

    }

    private void searchStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read search name from form data
        String theSearchName = request.getParameter("theSearchName");

        // search students from db util
        List<Student> students = studentDBUtil.searchStudents(theSearchName);

        // add students to the request
        request.setAttribute("STUDENT_LIST", students);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // route to the appropriate method
            if (theCommand.equals("ADD")) {
                addStudent(request, response);
            } else {
                listStudents(request, response);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{

        // read student id from form data
        String theStudentId = request.getParameter("studentId");

        // delete student from database
        studentDBUtil.deleteStudent(theStudentId);

        // send them back to "list student" page
        listStudents(request, response);

    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student id from form data
        String theStudentId = request.getParameter("studentId");

        // get student from db (db util)
        Student theStudent = studentDBUtil.getStudentById(theStudentId);

        // place student in the request attribute
        request.setAttribute("THE_STUDENT", theStudent);

        // send to jsp page: update-student-form.jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-student-form.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student theStudent = new Student(id, firstName, lastName, email);

        // perform update on database
        studentDBUtil.updateStudent(theStudent);

        // send back to main page (the student list)
        listStudents(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // create a new student object
        Student theStudent = new Student(firstName, lastName, email);

        // add the student to the database
        studentDBUtil.addStudent(theStudent);

        // send back to main page (the student list)
        // SEND AS REDIRECT to avoid multiple-browser reload issue
        response.sendRedirect(request.getContextPath() + "/StudentControllerServlet?command=LIST");
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get students from database util
        List<Student> students = studentDBUtil.getStudents();

        // add students to the request
        request.setAttribute("STUDENT_LIST", students);

        // send to JSP page (view)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-students.jsp");
        requestDispatcher.forward(request, response);
    }
}
