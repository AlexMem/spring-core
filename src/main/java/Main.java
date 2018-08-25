import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            context.getBean(Quoter.class).sayQuote();
        }
    }
}
