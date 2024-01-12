package com.example.servletdemo.MVC_Demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/MVC_Demo/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 0: Add data
        String[] students = {"Ivan", "Nikita", "Elizabeth", "Kolya"};
        request.setAttribute("student_list",students);

        // Step 1: Get request dispatcher
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MVC_Demo/students.jsp");

        // Step 2: Forward the request to JSP
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
