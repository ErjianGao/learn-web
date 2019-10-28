package example01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/helloservlet")
public class HelloServlet extends HttpServlet {
    private static final Logger LOGGER
            = Logger.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("doGet() be called");
        response.getWriter().write("response from servlet");
    }
}
