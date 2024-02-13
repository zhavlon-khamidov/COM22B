package kg.alatoo.beanlifecycledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

@SpringBootApplication
public class BeanLifecycleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanLifecycleDemoApplication.class, args);
    }


    public String getText() {
        return "Hello";
    }

    @Bean
    public MyBean myCustomBean() {
        return new MyBean();
    }

    @Bean
    public MyBean mySecondBean() {
        return new MyBean();
    }
}
