import com.java.demo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring-config.xml");
        User user=context.getBean("user1" , User.class);
        System.out.println(user.getUsername());
    }


}
