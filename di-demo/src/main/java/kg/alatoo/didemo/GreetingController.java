package kg.alatoo.didemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private final GreetingService greetingService;


    public GreetingController(@Qualifier("i18nGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String sayHello() {
        System.out.println("Inside of GreetingController");
        return greetingService.provideHello();
    }
}
