<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 05.04.2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/author/add">ADD AUTHOR</a>
<table>
    <tr>
        <th>FIRST NAME</th>
        <th>LAST NAME</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href='<c:url value="/author/delete/${author.id}"/>'>DELETED</a></td>
            <td><a href='<c:url value="/author/edit/${author.id}"/>'>EDIT</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
