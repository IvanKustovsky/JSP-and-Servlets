<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 04.01.2024
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,com.example.tagdemo.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("Ivan","Kustovsky",true));
    students.add(new Student("Eugene","Zgurovsky",false));
    students.add(new Student("Elena","Koval",false));
    students.add(new Student("Elizabeth","Swan",true));
    pageContext.setAttribute("myStudents", students);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>VIP</th>
    </tr>
    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td> ${tempStudent.lastName}</td>
            <td>${tempStudent.vip}</td>
        </tr>
    </c:forEach>

    <c:forEach items="${cookie}" var="currentCookie">
        Cookie name as map entry key: ${currentCookie.key} <br/>
        Cookie object as map entry value: ${currentCookie.value} <br/>
        Name property of Cookie object: ${currentCookie.value.name} <br/>
        Value property of Cookie object: ${currentCookie.value.value} <br/>
    </c:forEach>
</table>

</body>
</html>
