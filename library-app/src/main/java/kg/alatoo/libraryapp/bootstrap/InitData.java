package kg.alatoo.libraryapp.bootstrap;

import kg.alatoo.libraryapp.entities.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class InitData implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.atWarn().log("Initializing data");
        Book book1 = Book.builder()
                .title("Database")
                .publishedYear(2018)
                .isbn("151345-13151")
                .build();

        Book book2 = Book.builder()
                .title("Pro Spring 6")
                .publishedYear(2023)
                .isbn("454354314354")
                .edition(6)
                .build();


        // TODO: create 2 more books save all books to database

    }
}
