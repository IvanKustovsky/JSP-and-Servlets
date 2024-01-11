<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 11.01.2024
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  response.sendRedirect(request.getContextPath() + "/hello");
%>
</body>
</html>
