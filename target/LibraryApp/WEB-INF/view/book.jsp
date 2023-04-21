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
</body>
</html>
