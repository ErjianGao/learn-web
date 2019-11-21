<style>
    .header {
        margin: 10px 0;
    }
    .header ul {
        list-style: none;
        display: flex;
        background-color: #333333;
    }

    .header ul a {
        display: block;
        padding: 15px;
        text-decoration: none;
        color: white;
    }

    .header ul li.right {
        margin-left: auto;
    }

    /*设置悬浮样式应该设置到a上*/
    header.header ul li a:hover {
        color: black;
        background-color: white;
    }
</style>

<header class="header">
    <ul>
        <li><a href="">Home</a></li>
        <li><a href="">News</a></li>
        <li><a href="">Contact</a></li>
        <li><a href="">About</a></li>
        <li class="right"><a href="">Logout</a></li>
    </ul>
</header>
