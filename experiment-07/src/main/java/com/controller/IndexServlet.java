package com.controller;

import com.service.ServiceFactory;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建IndexServlet为首页的跳转和信息传递提供服务
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.listUsers());
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
    }
}
