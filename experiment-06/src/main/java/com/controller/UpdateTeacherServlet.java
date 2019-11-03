package com.controller;

import com.entity.Teacher;
import com.entity.Title;
import com.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 需求+1
 * 以表格形式显示所有注册教师姓名及注册时间
 * 且教师姓名为可点击的超链接，点击后跳转至教师详细信息页面
 * 在详细页面以表单形式，基于教师注册过的信息，加载初始化页面
 * 提交表单后，在控制台打印显示修改后的数据
 */
@WebServlet("/updateteacher")
public class UpdateTeacherServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(UpdateTeacherServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取从jsp传过来的tid的值
        int tid = Integer.parseInt(req.getParameter("tid"));
        // 添加对象和属性，以便请求转发到jsp中使用
        req.setAttribute("teacher", DatabaseUtils.getTeacher(tid));
        req.setAttribute("courses",DatabaseUtils.listCourses());
        req.setAttribute("titles", DatabaseUtils.listTitles());
        req.getRequestDispatcher("/WEB-INF/jsp/updateteacher.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        LOGGER.info("姓名：" + req.getParameter("name"));
        Teacher teacher = DatabaseUtils.listTeachers()
                .stream()
                .filter(t -> t.getName().equals(req.getParameter("name")))
                .findFirst()
                .orElse(null);
        if (teacher != null) {
            LOGGER.info("注册时间：" + teacher.getInsertDate());
        }
        LOGGER.info("职称ID：" + req.getParameter("titleID"));
        // 注意这里返回值是多个对象时，应该用req.getParameterValues()方法
        LOGGER.info("课程ID：" + Arrays.asList(req.getParameterValues("courseID")));
        resp.getWriter().write("submit successfully! ");
    }
}
