<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.04.2023
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT CATEGORY</title>
</head>
<body>
<%--@elvariable id="category" type="pl.coderslab.category.Category"--%>
<form:form method="post" modelAttribute="category" action="/category/edit">
    <form:hidden path="id"/>
    NAME :   <form:input path="name"/>
    DESCRIPTION :    <form:textarea path="description"/>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
