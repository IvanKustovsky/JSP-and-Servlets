<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 04.01.2024
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:set var="stuff" value="<%= new java.util.Date() %>" />
Time on the server is ${stuff}
</body>
</html>
