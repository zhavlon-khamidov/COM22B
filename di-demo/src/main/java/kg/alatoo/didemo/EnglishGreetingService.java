package kg.alatoo.didemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


//@Primary
@Profile({"EN","default"})
@Service("i18nGreetingService")
public class EnglishGreetingService implements GreetingService {

    public EnglishGreetingService() {
        System.out.println("EnglishGreetingService created");
    }

    public String provideHello() {
        System.out.println("Inside of GreetingService");
        return "Hello World";
    }
}
