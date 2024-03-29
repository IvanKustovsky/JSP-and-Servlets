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
        <!-- put new button: Add Student -->
        <input type="button" value="Add Student"
        onclick="window.location.href='add-student-form.jsp'; return false;"
        class="add-student-button"/>

        <!--  add a search box -->
        <form action="StudentControllerServlet" method="GET">

            <input type="hidden" name="command" value="SEARCH" />

            Search student: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-student-button" />

        </form>

        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempStudent" items="${STUDENT_LIST}">

                <!-- set up a link for each student -->
                <c:url var="tempLink" value="StudentControllerServlet">
                    <c:param name="command" value="LOAD" />
                    <c:param name="studentId" value="${tempStudent.id}" />
                </c:url>

                <!-- set up a link to delete a student -->
                <c:url var="deleteLink" value="StudentControllerServlet">
                    <c:param name="command" value="DELETE" />
                    <c:param name="studentId" value="${tempStudent.id}" />
                </c:url>

                <tr>
                    <td>${tempStudent.first_name}</td>
                    <td>${tempStudent.last_name}</td>
                    <td>${tempStudent.email}</td>
                    <td><a href="${tempLink}">Update</a>
                        | <a href="${deleteLink}"
                        onclick="if (!(confirm('Are you sure you want no delete this student?'))) return false">
                            Delete</a></td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>
