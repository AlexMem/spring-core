package jconfigs;

import frames.ColorFrame;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@ComponentScan(basePackages = {"frames", "bfpps"})
public class Config {
    @Bean
    @Scope("periodical")
    public Color color() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return new Color(current.nextInt(255),
                         current.nextInt(255),
                         current.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(555);
        }
    }
}
