package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookServiceJPATest {

    @Autowired
    private BookServiceJPA bookServiceJPA;

    @Test
    void convertEntityToDTO() {
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        BookDTO dto = bookServiceJPA.convertEntityToDTO(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
    }
}