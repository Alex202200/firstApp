<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Book Information</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/book.css">
</head>
<body>
<h1>Book Information</h1>
<table>
    <tr>
        <th>Title:</th>
        <td>${book.title}</td>
    </tr>
    <tr>
        <th>Author:</th>
        <td>${book.author}</td>
    </tr>
    <tr>
        <th>Year:</th>
        <td>${book.year}</td>
    </tr>
</table>
<br>
<div class="button-group">
    <a href="/book/edit/${book.id}" class="edit-button">Edit</a>
    <a href="/book/delete/${book.id}" class="delete-button">Delete</a>
    <a href="/books" class="back-button">Back to List Books</a>
</div>
<c:choose>
    <c:when test="${not empty book.person}">
        <p>This book is currently assigned to ${book.person.name}.</p>
        <form method="POST" action="${pageContext.request.contextPath}/book/release/${book.id}">
            <button type="submit">Release Book</button>
        </form>
    </c:when>
    <c:otherwise>
        <p>This book is currently available. Would you like to assign it?</p>
        <form method="POST" action="${pageContext.request.contextPath}/book/assign/${book.id}">
            <label for="person">Assign to Person:</label>
            <select name="person" id="person">
                <option value="">Select a person</option>
                <c:forEach items="${allPersons}" var="person">
                    <option value="${person.id}">${person.name}</option>
                </c:forEach>
            </select>
            <button type="submit">Assign</button>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>