<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2023
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Built-in JSP test</title>
</head>
<body>
Request user agent: <%=request.getHeader("User-Agent")%>

<br/> <br/>
Request language: <%= request.getLocale()%>
</body>
</html>
