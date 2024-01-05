<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 05.01.2024
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="data" value="StringToCalcLength" />
    Length of string <b>${data}</b>: ${fn:length(data)}
    <br><br/>
    Uppercase version of string <b>${data}</b> is ${fn:toUpperCase(data)}
    <br><br/>
    Does <b>${data}</b> ends with <b>${"Length"}</b>:  ${fn:endsWith(data, "Length")}
<br><br/>
<c:set var="cities" value="Kyiv,Lviv,Kharkiv,Dnipto,Herson" />
<c:set var="citiesArray" value="${fn:split(cities, ',')}" />
Array of cities:
<c:forEach var="tempCity" items="${citiesArray}">
     ${tempCity}
</c:forEach>

<br><br/>
<c:set var="joinedString" value="${fn:join(citiesArray, '*')}"/>
Result of joining array to one string: ${joinedString}
</body>
</html>
