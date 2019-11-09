<%@page pageEncoding="UTF-8" %>
<%-- 在页面使用标签库的前缀 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 格式化标签 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
<h1>
<%--    <% out.print("Hello jsp!");%>--%>
</h1>

<%--<%out.println("工程名称：" + request.getServletPath());%>--%>
<% System.out.println("Hello JSP!(控制台输出)");%>
<h2>以下是引入的HTML文件</h2>
<%@include file="hello.html" %>
用户名：${name}
用户信息：<br>
<table>
    <thead>
        <tr>
            <td>姓名</td>
            <td>地址</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.name}</td>
            <td>${user.address.detail}</td>
        </tr>
    </tbody>
</table>
<%--更新java代码的时候需要重新部署，因为需要重新编译，但更新页面资源的时候更新资源即可，jsp也适用--%>
地址：${location}<br>
会话地址：${sessionScope.location}
<br>
<%-- JSTL使用 --%>
<%--注意set只能是自封闭，在标签里面加东西没有意义--%>
<c:set var="salary" value="${2100*10}"/>
通过EL表达式显示结果：${salary}
<br>

<c:if test="${salary > 5}" var="iftest">
    好多啊
</c:if>
<c:if test="${salary < 2000}">
    好少啊
</c:if>
<br>
${iftest}
<br>
<c:choose>
    <c:when test="${salary <= 2000}">
        太惨了
    </c:when>
    <c:when test="${salary > 2000}">
        不错的薪水，还能生活
    </c:when>
    <c:otherwise>
        什么都没有
    </c:otherwise>
</c:choose>
<%--items代表集合，var代表每次的变量，varStatus封装遍历状态的属性变量名称--%>
<c:forEach items="${users}" var="u" varStatus="s">
    <li>
        ${s.count}:${u.name}
    </li>
</c:forEach>
<c:set var="balance" value="120000.2309"/>
<p>格式化数字（1）：<fmt:formatNumber value="${balance}" type="currency"/> </p>
<p>格式化数字（2）：英镑：<fmt:setLocale value="en_US" />
<fmt:formatNumber value="${balance}" type="currency"/>
</p>

<c:set var="now" value="<%=new java.util.Date()%>"/>
<%--<c:set var="now" value="<c:out value="new java.util.Date()"/>"/>--%>
<p>日期格式化（1）：<fmt:formatDate value="${now}" type="time" /></p>
<p>日期格式化（2）：<fmt:formatDate value="${now}" type="date" /></p>
<p>日期格式化（3）：<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss E" /></p>

参数一：${c1}
参数二：${c2}
参数三：${c3}


</body>
</html>