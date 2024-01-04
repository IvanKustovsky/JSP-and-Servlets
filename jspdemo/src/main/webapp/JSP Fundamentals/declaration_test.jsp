<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 18.12.2023
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Declaration test</title>
</head>
<body>
<%! String makeItLower(String str){
    return str.toLowerCase();
}%>

Lower case "Hello World": <%=makeItLower("Hello World")%>
</body>
</html>
