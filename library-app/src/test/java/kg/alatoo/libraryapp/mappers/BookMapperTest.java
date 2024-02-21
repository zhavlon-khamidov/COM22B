package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void bookToBookDto() {
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        BookDTO dto = BookMapper.INSTANCE.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
    }
}