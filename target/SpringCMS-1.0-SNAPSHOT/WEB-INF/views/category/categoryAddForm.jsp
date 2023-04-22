<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.04.2023
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADDED CATEGORY</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
   NAME :   <form:input path="name"/>
    <form:errors path="name"/><br>
   DESCRIPTION :    <form:textarea path="description"/>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
