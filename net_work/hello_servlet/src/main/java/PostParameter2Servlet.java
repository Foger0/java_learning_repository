import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/postParameter2")
public class PostParameter2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int length= req.getContentLength();
        byte[] buffer=new byte[length];
       InputStream inputStream= req.getInputStream();
       inputStream.read(buffer);

       String body=new String(buffer,0,length,"utf8");
        System.out.println("body="+body);
        resp.getWriter().write(body);
    }
}
