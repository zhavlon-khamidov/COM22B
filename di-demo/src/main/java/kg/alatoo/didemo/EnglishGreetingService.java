package kg.alatoo.didemo;


import org.springframework.stereotype.Service;

@Service
public class EnglishGreetingService implements GreetingService {

    public String provideHello() {
        System.out.println("Inside of GreetingService");
        return "Hello World";
    }
}
