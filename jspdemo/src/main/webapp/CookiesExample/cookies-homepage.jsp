<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 24.12.2023
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.net.URLDecoder"
         import="java.nio.charset.StandardCharsets"%>
<html>
<head>
    <title>Training Portal</title>
</head>
<body>

<h3>Training Portal</h3>
<!-- read the favorite programming language cookie -->
<%
  // the default ... if there are no cookies
  String favLang = "Java";

  // get the cookies from the browser request
  Cookie[] cookies = request.getCookies();

  // find out favorite programming language
  if(cookies != null){
    for (Cookie tempCookie : cookies){
      if("myApp.favoriteLanguage".equals(tempCookie.getName())){
        favLang = URLDecoder.decode(tempCookie.getValue(), StandardCharsets.UTF_8);
        break;
      }
    }
  }


%>

<!-- show a personalize page... use the "favLang" variable -->

<!-- show new books for this lang. For example -->
<h4>New books for language <%= favLang %></h4>
<ul>
  <li>Blah blah blah</li>
  <li>Blah blah blah</li>
</ul>

<!-- show the latest news reports for this lang. For example -->
<h4>Latest news reports for <%= favLang %></h4>
<ul>
  <li>Blah blah blah</li>
  <li>Blah blah blah</li>
</ul>

<!-- show hot jobs for this lang. For example -->
<h4>Hot jobs for <%= favLang %></h4>
<ul>
  <li>Blah blah blah</li>
  <li>Blah blah blah</li>
</ul>

<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>
