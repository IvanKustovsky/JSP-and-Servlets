package com.example.servletdemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Step 1: Set the content type
        response.setContentType("text/html");

        // Step 2: Get the printWriter
        PrintWriter out = response.getWriter();

        // Step 3: Read Configuration Parameters
        ServletContext context = getServletContext(); //inherit from HttpServlet
        String maxCartSize = context.getInitParameter("max-shopping-cart-size");
        String projectName = context.getInitParameter("Project Name");
        // READ PER-SERVLET parameter
        String theGreetingMessage = getServletConfig().getInitParameter("greeting");
        String theServiceLevel = getServletConfig().getInitParameter("serviceLevel");
        Enumeration<String> params = context.getInitParameterNames();
        Enumeration<String> params1 = getInitParameterNames();
        List<String> paramList = Collections.list(params);
        List<String> paramList1 = Collections.list(params1);

        // Step 4: Generate HTML content
        out.println("<html><body>");

        out.println("Max cart: " + maxCartSize);
        out.println("<br/><br/>");
        out.println("Project name: " + projectName);
        out.println("<br/><br/>");
        out.println("<hr>");
        out.println("Per Servlet Params<br/><br/>");
        out.println("Greeting: " + theGreetingMessage);
        out.println("<br/><br/>");
        out.println("Service level: " + theServiceLevel);
        out.println("<br/><br/>");
        out.println("<hr>");
        out.println("Enumeration of parameters: " + paramList + paramList1);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
