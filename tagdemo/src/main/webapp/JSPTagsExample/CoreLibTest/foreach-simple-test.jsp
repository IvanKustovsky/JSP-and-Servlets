<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 04.01.2024
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
    String[] cities = {"Kyiv", "Lviv", "Dnipro"};
    pageContext.setAttribute("myCities", cities);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="tempCity" items="${myCities}">
    ${tempCity} <br/>
</c:forEach>
</body>
</html>
