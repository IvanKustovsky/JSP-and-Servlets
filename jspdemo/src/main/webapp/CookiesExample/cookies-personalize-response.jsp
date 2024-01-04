<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 24.12.2023
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" import="java.net.URLEncoder"
         import="java.nio.charset.StandardCharsets"%>
<html>
<head>
    <title>Confirmation</title>
</head>
<%
    //read form data
    String favLang = request.getParameter("favoriteLanguage");

    // encode cookie data ... handle case of languages with spaces in them
    favLang = URLEncoder.encode(favLang, StandardCharsets.UTF_8);

    // create the cookie
    Cookie theCookie = new Cookie("myApp.favoriteLanguage",favLang);

    // set the life span total number of seconds
    theCookie.setMaxAge(60*60*24*7);

    // send cookie to the browser
    response.addCookie(theCookie);
%>

<body>
   Thanks! We set your favorite language to: ${param.favoriteLanguage}

    <br/><br/>

    <a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>
