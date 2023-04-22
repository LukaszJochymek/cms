<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.04.2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CATEGORY</title>
</head>
<body>
<a href="/category/add">ADD CATEGORY</a>

<table>
    <tr>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>ACTIONS</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href='<c:url value="/category/delete/${category.id}"/>'>DELETED</a></td>
            <td><a href='<c:url value="/category/edit/${category.id}"/>'>EDIT</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
