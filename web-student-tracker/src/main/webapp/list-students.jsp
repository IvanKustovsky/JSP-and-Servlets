<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 13.01.2024
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>VeryBad University</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

            <c:forEach var="tempStudent" items="${STUDENT_LIST}">

                <tr>
                    <td>${tempStudent.first_name}</td>
                    <td>${tempStudent.last_name}</td>
                    <td>${tempStudent.email}</td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>
