<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table>
    <c:forEach items="${teachers}" var="teacher">
        <%--(thead>tr>th*4)+tbody>tr*2>td*4--%>
        <tr>
            <td><a href="/updateteacher?tid=${teacher.id}">${teacher.name}</a></td>
            <td><fmt:formatDate value="${teacher.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>