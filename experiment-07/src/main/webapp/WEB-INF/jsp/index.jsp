<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <%--向数据库插入用户--%>
    <form action="/adduser" method="post">
        用户名：
        <input type="text" name="name"><br>
        <button type="submit">添加</button>
        <br>
    </form>

    <%--在index.jsp添加form表单，修改指定用户的用户名--%>
    <form action="/updateuser" method="post">
        <select name="oldUserID">
            <c:forEach items="${users}" var="user">
                <option value="${user.id}">${user.name}</option>
            </c:forEach>
        </select>
        新用户名：
        <input type="text" name="newName"><br>
        <button type="submit">更新</button>
    </form>
</div>
<ul>
    <c:forEach items="${users}" var="user">
        <%--ul和li都没有name和value属性，所以通过超链接及href传值--%>
        <li><a href="/getuser?userID=${user.id}">${user.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
