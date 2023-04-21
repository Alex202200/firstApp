<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html>
<head>
    <title>People List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all-person.css">

</head>
<body>
<h1>People List2</h1>
<button onclick="location.href='/persons/add'" class="btn">Add Person</button>
<br><br>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Year</th>
        <th class="actions">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${allpers}">
        <tr>
            <td><a href="/person/details/${person.id}">${person.name}</a></td>
<%--            <td>${person.name}</td>--%>
            <td>${person.year}</td>
            <td>
<%--         <button onclick="location.href='/persons/edit/' + ${person.id}" class="btn btn-update">Update</button>--%>
                <a href="/persons/edit/${person.id}" class="btn btn-update">Update</a>
                <a href="/person/delete/${person.id}" class="btn btn-delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
