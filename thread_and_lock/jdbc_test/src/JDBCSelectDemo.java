import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelectDemo {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/homework?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("dxy19660");
        Connection connection=dataSource.getConnection();
        String sql="select*from student";
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            System.out.println(id+":"+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
