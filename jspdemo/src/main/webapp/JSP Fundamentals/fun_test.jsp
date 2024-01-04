<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2023
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ page import="com.example.jspdemo.*" %>
<html>
<head>
    <title>JSP using Java class</title>
</head>
<body>
Some fun: <%= FunUtils.makeItLower("NOT FUN NOT FUN NOT FUN")%>
</body>
</html>
