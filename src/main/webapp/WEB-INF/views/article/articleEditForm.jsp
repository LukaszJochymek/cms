<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ARTICLE EDIT</title>
</head>
<body>
<form:form method="post" modelAttribute="article" action="/article/edit">
    <form:hidden path="id"/>
    Title :   <form:input path="title"/>
    Content :    <form:textarea path="content"/>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
