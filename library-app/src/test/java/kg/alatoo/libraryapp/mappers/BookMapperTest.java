package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.entities.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void bookToBookDto() {

        Publisher publisher = Publisher.builder()
                .name("Test publisher")
                .build();


        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .publisher(publisher)
                .build();

        publisher.setBooks(Set.of(book));

        BookDTO dto = bookMapper.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
        assertNotNull(dto.getPublisher());
        assertEquals("Test publisher", dto.getPublisher().getName());
    }

    @Test
    void bookDtoToBook() {
        BookDTO dto = BookDTO.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        Book book = bookMapper.bookDtoToBook(dto);

        assertNotNull(book);
        assertEquals(12L,book.getId());
        assertEquals("Test book", book.getTitle());
        assertEquals("5134454", book.getIsbn());

    }
}