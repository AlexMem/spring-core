import applicationcontexts.PropertyFileApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import quoters.Quoter;

public class Main {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.property");
        context.getBean(Quoter.class).sayQuote();
    }
}
