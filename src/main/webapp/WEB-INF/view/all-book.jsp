<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Books</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all-book.css">

</head>
<body>
<h1>List of Books</h1>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><a href="/book/details/${book.id}">${book.title}</a></td>
            <td>${book.author}</td>
            <td>${book.year}</td>
        </tr>
    </c:forEach>
</table>
<div class="centered">
<%--    <a href="/book/add" class="add-book">Add Book</a>--%>
    <button onclick="location.href='/book/add'" class="add-book">Add Book</button>
</div>
</body>
</html>
