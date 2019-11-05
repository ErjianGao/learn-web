<%@ page pageEncoding="UTF-8" %>
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
        <input type="text" name="username"><br>
        <button type="submit">添加</button>
        <br>
    </form>
    <%--<form action="" method="post">--%>
    <%--    <select name="oldName">--%>
    <%--        --%>
    <%--    </select>--%>
    <%--</form>--%>
</div>
</body>
</html>
