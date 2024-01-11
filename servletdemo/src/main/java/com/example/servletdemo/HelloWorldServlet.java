package com.example.servletdemo;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(config)");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Step 1: Set the content type
        resp.setContentType("text/html");

        // Step 2: Get the printWriter
        PrintWriter out = resp.getWriter();

        // Step 3: Generate HTMl content
        out.println("<html><body>");
        out.println("<h1>Hello world</h1>");
        out.println("<hr>");
        out.println("Time on the server is: " + new java.util.Date());
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
