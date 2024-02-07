package kg.alatoo.didemo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("RU")
@Service("i18nGreetingService")
public class RussianGreetingService implements GreetingService {

    public RussianGreetingService() {
        System.out.println("RussianGreetingService created");
    }

    @Override
    public String provideHello() {
        return "Привет Мир";
    }
}
