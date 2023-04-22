<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author" action="/author/edit">
    <form:hidden path="id"/>
    First Name :   <form:input path="firstName"/>
    Last Name :    <form:textarea path="lastName"/>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
