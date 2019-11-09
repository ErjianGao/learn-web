package example01;

import example01.entity.Address;
import example01.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/el")
public class ELServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address("Harbin");
        User user = new User("Eric",address);
        req.setAttribute("user",user);
        req.setAttribute("name","Eric");

        // 有可能会用到getAttribu()，可能会从一个servlet跳到另一个servlet
        req.setAttribute("location", "902");
        req.getSession().setAttribute("location","Danqing");

        // 测试EL表达式加JSTL循环
        User user1 = new User("gao");
        User user2 = new User("wang");
        User user3 = new User("li");
        List<User> users = List.of(user1,user2,user3);
        req.setAttribute("users", users);

        req.getRequestDispatcher("/jsp/hellojsp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s1 = req.getParameter("c1");
        String s2 = req.getParameter("c2");
        String s3 = req.getParameter("c3");
        req.setAttribute("c1",s1);
        req.setAttribute("c1",s2);
        req.setAttribute("c1",s3);
        req.getRequestDispatcher("/jsp/hellojsp.jsp").forward(req,resp);
    }
}
