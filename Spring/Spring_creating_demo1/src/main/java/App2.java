import demo.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App2 {
    public static void main(String[] args) {
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        Student student= (Student) beanFactory.getBean("student");
        student.sayHi();
    }
}
