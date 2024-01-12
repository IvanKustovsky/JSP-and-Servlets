
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>MVC Introduction</title>
</head>
<body>

<h2> Student Table Demo </h2>
<hr/>

<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
    </tr>
    <c:forEach var="tempStudent" items="${studentsList}">

        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>${tempStudent.email}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
