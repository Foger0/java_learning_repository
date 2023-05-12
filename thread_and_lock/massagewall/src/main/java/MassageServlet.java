import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message{
    public String from;
    public String to;
    public String message;
}
@WebServlet("/message")
public class MassageServlet extends HttpServlet {
    //private List<Message> messageList=new ArrayList<>();
   private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      Message message=objectMapper.readValue(req.getInputStream(),Message.class);
      //messageList.add(message);
        save(message);
      resp.setStatus(200);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("application/json; charset=utf8");
List<Message> messageList=load();
  String jsonResp= objectMapper.writeValueAsString(messageList);
        System.out.println("jsonResp:"+jsonResp);
        resp.getWriter().write(jsonResp);
    }
    private void save(Message message) {
        Connection connection=null;
        PreparedStatement statement=null;
        try { connection =DBUtil.getConnection();
            String sql="insert into message values(?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,message.from);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    private List<Message> load(){
        Connection connection=null;
        PreparedStatement statement=null;
        List<Message> messageList=new ArrayList<>();
        try { connection =DBUtil.getConnection();
            String sql="select*from message";
            statement=connection.prepareStatement(sql);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Message message=new Message();
                message.from=resultSet.getString("from");
                message.to=resultSet.getString("to");
                message.message=resultSet.getString("message");
                messageList.add(message);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(connection,statement,null);
        }
        return messageList;
    }
}
