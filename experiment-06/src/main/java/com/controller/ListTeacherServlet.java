package com.controller;

import com.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/listteachers")
public class ListTeacherServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ListTeacherServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("do Get()");

        req.setAttribute("teachers", DatabaseUtils.listTeachers());

        req.getRequestDispatcher("/WEB-INF/jsp/listteachers.jsp").forward(req,resp);
    }
}
