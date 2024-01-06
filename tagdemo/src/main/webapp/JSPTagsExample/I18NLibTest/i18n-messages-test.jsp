<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 05.01.2024
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session" />

<fmt:setLocale value="${theLocale}" />
<fmt:setBundle basename="myLabels" var="bundle"/>

<html>
<head>
    <title>Internationalization</title>
</head>
<body>
<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a> |
<a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish (ES)</a> |
<a href="i18n-messages-test.jsp?theLocale=de_DE">German (DE)</a>
<hr/>
<fmt:message key="label.greeting" bundle="${bundle}"/> <br/> <br/>
<fmt:message key="label.firstname" bundle="${bundle}"/> <i>Ivan</i> <br/>
<fmt:message key="label.lastname"  bundle="${bundle}"/> <i>Kustovsky</i> <br/> <br/>
<fmt:message key="label.welcome"   bundle="${bundle}"/> <br/> <br/>

<hr/>
Selected locale: ${theLocale}

</body>
</html>
