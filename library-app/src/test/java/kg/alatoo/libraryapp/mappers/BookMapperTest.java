package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void bookToBookDto() {
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        BookDTO dto = bookMapper.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
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