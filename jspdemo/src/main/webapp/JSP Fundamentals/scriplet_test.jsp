<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2023
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Scriptlet test</title>
</head>
<body>
<h3> Hello world of java</h3>
<%
    for (int i = 1; i < 6; i++) {
        out.println("<br/> Digit number: " + i);
    }%>

</body>
</html>
