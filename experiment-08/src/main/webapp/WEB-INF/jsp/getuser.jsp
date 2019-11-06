<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user-information</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Insert Time</th>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.insertTime}</td>
        </tr>
    </table>
    <a href="/index">
        <button type="button">返回</button>
    </a>
</div>
</body>
</html>
