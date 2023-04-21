<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Add person</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-person.css">
</head>
<body>
<h1>Add person</h1>
<form:form action="/savePerson" modelAttribute="person">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" th:field="*{name}" th:value="${person.name}" required/><br><br>

    <label for="year">Year:</label>
    <input type="number" id="year" name="year" th:field="*{year}" th:value="${person.year}" required/><br>

    <input type="hidden" id="id" name="id" value="${person.id}"/> <!-- добавлено скрытое поле id -->

    <input type="submit" value="Create" class="btn-lg">
</form:form>
</body>
</html>
