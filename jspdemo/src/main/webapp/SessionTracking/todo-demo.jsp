<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 24.12.2023
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- Step 1: Create HTML form -->
<form action="todo-demo.jsp"> <!-- submit data to itself -->
    Add new item: <input type="text" name="theItem" />
    <input type="submit" value="Submit"/>
</form>
<!-- Step 2: Add new item to "To Do" list -->
 <%
    // get the TO DO items from the session
     List<String> items = (List<String>) session.getAttribute("myToDoList");
     // if the TO DO items doesn't exist< then create a new one
     if(items == null){
         items = new ArrayList<>();
         session.setAttribute("myToDoList",items);
     }
     // see if there is form data to add
     String theItem = request.getParameter("theItem");
     boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
     boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());

     if (isItemNotEmpty && isItemNotDuplicate) {
         items.add(theItem.trim());
     }
 %>
<hr>
<!-- Step 3: Display all "To Do" item from session -->
<b>To List Items:</b> <br/>

<ol>
    <%
    for (String item: items){
        out.println("<li>" + item + "</li>");
    }
    %>
</ol>
</body>
</html>
