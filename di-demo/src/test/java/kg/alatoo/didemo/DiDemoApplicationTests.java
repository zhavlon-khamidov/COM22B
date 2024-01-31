package kg.alatoo.didemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DiDemoApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private GreetingController greetingController;

    @Test
    void greetingController() {
        System.out.println(greetingController.sayHello());
    }


    @Test
    void contextLoads() {
        GreetingController greetingController = context.getBean(GreetingController.class);
        System.out.println(greetingController.sayHello());
    }

}
