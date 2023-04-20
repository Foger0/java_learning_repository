package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession(false);
        if (session==null){
            System.out.println("用户未登录!");
            resp.sendRedirect("login.html");
            return;
        }
        String username=(String) session.getAttribute("username");
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("欢迎"+username+"回来");
    }
}
