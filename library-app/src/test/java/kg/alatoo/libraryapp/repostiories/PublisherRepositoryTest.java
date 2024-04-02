package kg.alatoo.libraryapp.repostiories;

import kg.alatoo.libraryapp.entities.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    @Transactional
    void lazyVsEager() {
        Publisher publisher = publisherRepository.findAll().get(0);

        System.out.println("Got publisher: " + publisher.getName());
        System.out.println(publisher);
        publisher.setName("Updated");

//        publisherRepository.save(publisher);

//        Set<String> books = publisher.getBooks().stream().map(Book::getTitle).collect(Collectors.toSet());
//        System.out.println("Publisher books: " + books);
    }

    @AfterEach
    void tearDown() {
        System.out.println(publisherRepository.findAll().get(0));
    }
}