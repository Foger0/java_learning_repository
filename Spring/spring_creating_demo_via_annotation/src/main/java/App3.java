import com.java.demo.UserService3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserService3 userService3=context.getBean("userService3",UserService3.class);
        userService3.sayHi();
    }
}
