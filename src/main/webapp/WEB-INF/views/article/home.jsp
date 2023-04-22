<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 04.04.2023
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<a href="/category/all">CATEGORY</a>
<a href="/author/all">AUTHORS</a>
<a href="/article/all">ARTICLE</a>

<table>
    <tr>
        <th>Title</th>
        <th>Date created</th>
        <th>Article content</th>
        <th>Authors</th>
    </tr>
    <c:forEach items="${article}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>
            <td>${article.author.lastName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
