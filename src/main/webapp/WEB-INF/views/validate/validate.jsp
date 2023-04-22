<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>FIELD CATEGORY</th>
        <th>MESSAGE</th>

    </tr>
    <c:forEach items="${validationsCategory}" var="valC">
    <tr>
            <%--            <td>${val.interpolatedMessage}</td>--%>
        <td>${valC.getPropertyPath()}</td>
        <td>${valC.getMessage()}</td>

    </tr>
    </c:forEach>
    <tr>
        <th>FIELD Author</th>
        <th>MESSAGE</th>

    </tr>
    <c:forEach items="${validateAuthor}" var="valA">
    <tr>
        <td>${valA.getPropertyPath()}</td>
        <td>${valA.getMessage()}</td>

    </tr>
    </c:forEach>
    <tr>
        <th>FIELD Publisher</th>
        <th>MESSAGE</th>

    </tr>
    <c:forEach items="${validateArticle}" var="valAr">
    <tr>
        <td>${valAr.getPropertyPath()}</td>
        <td>${valAr.getMessage()}</td>

    </tr>
    </c:forEach>
</table>
</body>
</html>
