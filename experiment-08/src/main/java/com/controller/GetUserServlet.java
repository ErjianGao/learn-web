package com.controller;

import com.entity.User;
import com.service.ServiceFactory;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getuser")
public class GetUserServlet extends HttpServlet {
    private UserService userService = ServiceFactory.getUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userID = Integer.parseInt(req.getParameter("userID"));
        User user = userService.getUser(userID);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/jsp/getuser.jsp").forward(req,resp);
    }
}
