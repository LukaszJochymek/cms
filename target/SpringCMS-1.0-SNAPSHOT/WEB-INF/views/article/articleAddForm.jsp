<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    Title  :   <form:input path="title"/>
    <form:errors path="title"/><br>
    Content :    <form:textarea path="content"/>
    <form:errors path="content"/><br>
    AUTHORS :  <form:select path="author" items="${authors}" itemLabel="lastName" itemValue="id"/><br/>
    CATEGORY : <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"/>
    <form:errors path="categories"/><br>
    <input type="submit" value="Submit"><br>
</form:form>
</body>
</html>
