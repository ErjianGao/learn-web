package com.filter;

import com.controller.LoginServlet;
import com.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebFilter("/*")
public class LoginFilter extends HttpFilter {
    // 添加排除路径，如果已经在login界面，则不进行拦截
    private List<String> excludes = List.of("/login");
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        for (String e : excludes) {
            if (e.equals(req.getServletPath())) {
                LOGGER.info("发现指定目标，先进行拦截");
                chain.doFilter(req, res);
                LOGGER.info("放行之后");
                // 函数结束
                return;
            }
        }
        // 先获取session中的user对象
        User user = (User) req.getSession().getAttribute("user");
        // 如果Session中对象为空，则说明Session中不存在user的登录信息，需要重定向到login界面
        if (user == null) {
            LOGGER.info("未发现对象，重定向到login界面");
            res.sendRedirect("/login");
        } else {
            // 如果不为空，则放行
            LOGGER.info("发现对象，放行！");
            chain.doFilter(req,res);
        }
    }
}
