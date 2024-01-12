package com.example.servletdemo.MVC_Demo;

import com.example.servletdemo.models.Student;
import com.example.servletdemo.utils.StudentDataUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/MVC_Demo/MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 1: Get data from helper class (model)
        List<Student> students = StudentDataUtil.getStudents();

        // Step 2: Add students to request object
        request.setAttribute("studentsList", students);

        // Step 3: Get request dispatcher
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MVC_Demo/view_students.jsp");

        // Step 4: Forward to JSP
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
