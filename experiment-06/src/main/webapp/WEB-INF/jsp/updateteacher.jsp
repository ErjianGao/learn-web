<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师详细信息设置</title>
</head>
<body>
<div class="user-info">
    <form action="${pageContext.request.contextPath}/updateteacher" method="post">
        用户：
        <label><input name="name" type="text" value="${teacher.name}"></label><br>
        注册时间：
        <fmt:formatDate value="${teacher.insertDate}" pattern="yyyy-MM-dd HH:mm"/>
        <br>
        <br>
        职称：
        <select name="titleID">
            <c:forEach var="title" items="${titles}" varStatus="s">
                <c:set var="selected" value=""/>
                <c:if test="${teacher.title.id == s.count}">
                    <c:set var="selected" value="selected"/>
                </c:if>
                <option value="${s.count}" ${selected}>${title.name}</option>
            </c:forEach>
        </select><br>
        授课：
        <ul>
            <c:forEach items="${courses}" var="course" varStatus="s">
                <c:set var="checked" value=""/>
                <c:forEach items="${teacher.courses}" var="teacherCourse">
                    <c:if test="${teacherCourse.id == course.id}">
                        <c:set var="checked" value="checked"/>
                    </c:if>
                </c:forEach>
                <li>
                    <input name="courseID" type="checkbox" value="${course.id}" ${checked}>${course.name}
                </li>
            </c:forEach>
        </ul>
        <button type="submit">提交</button>
        <button type="reset">重置</button>
    </form>
</div>
</body>
</html>
