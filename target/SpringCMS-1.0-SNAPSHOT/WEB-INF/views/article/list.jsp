<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ARTICLE</title>
</head>
<body>
<a href="/article/add">ADD ARTICLE</a>
<table>
    <tr>
        <th>TITLE</th>
        <th>CONTENT</th>
        <th>CREATED</th>
        <th>UPDATED</th>
        <th>AUTHOR</th>
        <th>ACTIONS</th>
    </tr>
    <c:forEach items="${articles}" var="art">
        <tr>
            <td>${art.title}</td>
            <td>${art.content}</td>
            <td>${art.created}</td>
            <td>${art.updated}</td>
            <td>${art.author.lastName}  ${art.author.firstName}</td>
            <td><a href='<c:url value="/article/delete/${art.id}"/>'>DELETED</a>
            <a href='<c:url value="/article/edit/${art.id}"/>'>EDIT</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
