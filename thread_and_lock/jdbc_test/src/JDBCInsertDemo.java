import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main1(String[] args) throws SQLException {
        java.util.Scanner scanner=new Scanner(System.in);
        System.out.println("学号:");
        int id=scanner.nextInt();
        System.out.println("姓名:");
        String name=scanner.next();
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/homework?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("dxy19660");
        Connection connection=dataSource.getConnection();
        String sql="insert into student values(?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        System.out.println("sql:"+statement);
       int ret=statement.executeUpdate();
       System.out.println(ret);
       statement.close();
       connection.close();
    }
}
