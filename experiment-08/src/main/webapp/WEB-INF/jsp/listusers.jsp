<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${users}" var="user">
        <li>
            ${user.name}
        </li>
    </c:forEach>
</ul>
<a href="/index">
    <button type="button">返回</button>
</a>
</body>
</html>
