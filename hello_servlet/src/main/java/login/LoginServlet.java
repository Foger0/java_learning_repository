package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
       /* if(username.equals("zhangsan")||username.equals("lisi")){
            if (password.equals("123")){

            }else {

            }
        }else {

        }*/
        if (!username.equals("zhangsan")&&!username.equals("lisi")){
            System.out.println("登陆失败,用户名错误");
            resp.sendRedirect("login.html");
            return;
        }
        if (!password.equals("123")){
            System.out.println("登陆失败,密码错误");
            resp.sendRedirect("login.html");
            return;
        }
        HttpSession session=req.getSession(true);
        session.setAttribute("username",username);
        resp.sendRedirect("index");
    }
}
