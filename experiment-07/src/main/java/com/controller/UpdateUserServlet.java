package com.controller;

import com.entity.User;
import com.service.ServiceFactory;
import com.service.UserService;
import com.sun.jdi.IntegerType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateuser")
public class UpdateUserServlet extends HttpServlet {
    private UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("oldUserID"));
        String newName = req.getParameter("newName");
        User user = new User();
        user.setName(newName);
        user.setId(id);
        userService.updateUser(user);
        resp.sendRedirect("/listusers");
    }
}
