package kg.alatoo.didemo;

import org.springframework.stereotype.Service;

@Service
public class RussianGreetingService implements GreetingService {


    @Override
    public String provideHello() {
        return "Привет Мир";
    }
}
