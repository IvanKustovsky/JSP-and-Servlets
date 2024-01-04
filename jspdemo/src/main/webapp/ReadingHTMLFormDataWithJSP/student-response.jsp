<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 22.12.2023
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Confirmation Title</title>
</head>
<body>

The student is confirmed: ${param.firstName} ${param.lastName}
<br/><br/>
The student's country': ${param.country}
<br/><br/>
The student's favourite language': ${param.favoriteLanguage}
<br/>
<!-- display favourite topics -->
<ul>
    <%
        String[] langs = request.getParameterValues("favoriteTopic");

        if (langs != null) {
            for (String tempLang : langs) {
                out.println("<li>" + tempLang + "</li>");
            }
        }
    %>
</ul>
</body>
</html>
