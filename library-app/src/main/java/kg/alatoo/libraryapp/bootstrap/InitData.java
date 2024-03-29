package kg.alatoo.libraryapp.bootstrap;

import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.repostiories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Log4j2
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final BookRepository bookRepository;

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

        bookRepository.saveAll(List.of(book1, book2));

        generateBooks(10000);

        /*
        TODO: create at least 3 publisher and each publisher must have at least by 2 books,
            and each book should have 1 or many authors and save to DB
           */

    }

    public void generateBooks(int numberOfBooks) {

        Random random = new Random();

        for (int i = 1; i <= numberOfBooks; i++) {
            Book book = Book.builder()
                    .title("Book " + i)
                    .isbn(String.valueOf(random.nextInt(100_000_000,999_999_999)))
                    .publishedYear(random.nextInt(1970,2025))
                    .build();

            bookRepository.save(book);
        }
    }
}
