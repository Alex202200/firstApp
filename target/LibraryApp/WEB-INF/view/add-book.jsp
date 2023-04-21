<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Add book</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-book.css">
</head>

<body>
<h1>Add book</h1>
<form:form action="/saveBook" modelAttribute="book">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" th:field="*{title}" required/><br><br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" th:field="*{author}" required/><br><br>

    <label for="year">Year:</label>
    <input type="number" id="year" name="year" th:field="*{year}" required/><br>

    <input type="hidden" id="id" name="id" value="${book.id}"/> <!-- добавлено скрытое поле id -->

    <input type="submit" value="Create" class="btn-lg">
</form:form>
</body>
</html>
