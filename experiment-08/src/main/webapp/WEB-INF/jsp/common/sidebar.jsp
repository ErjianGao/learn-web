<%@ page pageEncoding="UTF-8" %>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    nav.sidebar {
        width: 250px;
        border-radius: 10px;
        display: inline-block;
        box-shadow: 0 0 25px rgba(0,0,0,0.1);
    }

    nav.sidebar ul li {
        list-style: none;
    }

    nav.sidebar ul li a {
        text-decoration: none;
        color: #000;
        padding: 10px 25px;
        display: block;
        transition-duration: 0.5s;
    }

    nav.sidebar h3 {
        padding: 10px 20px;
        color: white;
        background-color: cornflowerblue;
        /*注意这里只能给文字加边框，否则会被h3背景色覆盖*/
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }

    nav.sidebar a:hover  {
        background-color: deepskyblue;
        color: white;
        transform: scale(1.1);
    }

    nav.sidebar a.the-last:hover {
        /*在底下的时候给悬浮加圆角*/
        border-bottom-left-radius: 10px;
        border-bottom-right-radius: 10px;
    }
</style>

<nav class="sidebar">
    <h3>云技术管理</h3>
    <ul>
        <li><a href="#">云服务器</a></li>
        <li><a href="#">云数据库</a></li>
        <li><a class="the-last" href="#">负载均衡</a></li>
    </ul>
</nav>