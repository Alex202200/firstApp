<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Person Information</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/person.css">
</head>
<body>
<h1>Person Information</h1>
<table>
    <tr>
        <th>Name:</th>
        <td>${person.name}</td>
    </tr>
    <tr>
        <th>Year:</th>
        <td>${person.year}</td>
    </tr>
    <tr>
        <th>Books:</th>
        <td>
            <c:if test="${not empty person.books}">
                <ul>
                    <c:forEach var="book" items="${person.books}">
                        <li>${book.title} by ${book.author}</li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${empty person.books}">
                The man did not pick up a single book.
            </c:if>
        </td>
    </tr>
</table>
<br>
<a href="/persons" style="font-size: 20px; text-decoration: none;">Back to People List</a>
</body>
</html>
