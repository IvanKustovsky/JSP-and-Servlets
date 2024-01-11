package com.example.servletdemo;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Step 1: Set the content type
        response.setContentType("text/html");

        // Step 2: Get the printWriter
        PrintWriter out = response.getWriter();

        // Step 3: Generate HTMl content
        out.println("<html><body>");
        out.println("The student is confirmed: "
                + request.getParameter("firstName") + " "
                + request.getParameter("lastName"));
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
