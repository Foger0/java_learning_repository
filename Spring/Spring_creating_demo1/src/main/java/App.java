import demo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        //find object by name
        //Student student= (Student) context.getBean("student");
        //find object by class but should not content two objects
        Student student=context.getBean(Student.class);
        student.sayHi();

    }
}
