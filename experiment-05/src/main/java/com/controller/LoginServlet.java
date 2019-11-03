package com.controller;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

//向地址发请求

/**
 * 在com.entity下，创建User类，封装用户真实姓名，用户名，密码属性
 * 重写LoginServlet的doPost()方法，获取页面传入的登录用户名/密码参数，实现当用户名/密码为指定字符串时，创建user对象，并将对象添加至session中；且，登录成功，重定向到/welcome，即welcome页面，登录失败，重定向到/login，登录页面
 *
 * 此时，仍可向/welcome地址，直接发送请求
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    // 浏览器发请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        LOGGER.info("do Get() is called");
        req.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("do Post() is called");
        //从html页面的post请求中提取到数据
        String userName = req.getParameter("userName");
        String password = req.getParameter("pwd");
        //存储需要重定向到什么位置
        String url;
        if("Eric".equals(userName) && "123456".equals(password)) {
            User user = new User("高尔健");
            req.getSession().setAttribute("user", user);
            url = "/welcome";
        } else {
            url = "/login";
        }
        // 重定向到新的网址，通知客户端发起新的Get请求
        // 产生新request/response对象，用于处理Post请求的刷新重复提交
        resp.sendRedirect(url);
    }
}
