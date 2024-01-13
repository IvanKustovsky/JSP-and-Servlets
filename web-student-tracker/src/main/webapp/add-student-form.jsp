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
    <title>Add Student</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>VeryBad University</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <h3>Add Student</h3>
        <form action="StudentControllerServlet" method="get">
            <input type="hidden" name="command" value="ADD"/>

            <table>
                <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><input type="text" name="firstName"/></td>
                </tr>

                <tr>
                    <td><label>Last name:</label></td>
                    <td><input type="text" name="lastName"/></td>
                </tr>

                <tr>
                    <td><label>Email:</label></td>
                    <td><input type="text" name="email"/></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form>


        <a href="/web_student_tracker">Back to List</a>
    </div>
</div>

</body>
</html>
