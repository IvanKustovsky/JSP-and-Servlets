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
        }
        catch (Exception exception){
            throw new ServletException(exception);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // list the students... in MVC fashion
            listStudents(request, response);
        }
        catch (Exception exception){
            throw new ServletException(exception);
        }

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
