package com.controller;

import com.entity.User;
import com.service.ServiceFactory;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listusers")
public class ListUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("listusers doGet()");
        UserService userService = ServiceFactory.getUserService();
        List<User> users = userService.listUsers();
        users.forEach(user -> {
            System.out.println(user.getName());
        });
        req.setAttribute("users", userService.listUsers());
        req.getRequestDispatcher("WEB-INF/jsp/listusers.jsp").forward(req,resp);
    }
}
