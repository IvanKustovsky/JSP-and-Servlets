package com.example.webstudenttracker;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    //Define datasource/connection pool for Resource Injection
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Step 1: Set up a printWriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Step 2: Get a connection to the database
        Connection myConn;
        Statement statement;
        ResultSet resultSet;

        try {
            myConn = dataSource.getConnection();
            // Step 3: Create a SQL statements
            String sql = "select * from student";
            statement = myConn.createStatement();

            // Step4: Execute SQL query
            resultSet = statement.executeQuery(sql);

            // Step 5: Process the result set
            while (resultSet.next()){
                String email = resultSet.getString("email");
                out.println(email);
                out.println("Test");
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }

    }

}
