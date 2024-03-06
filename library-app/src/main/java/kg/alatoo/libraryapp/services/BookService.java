package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Optional<BookDTO> getBookById(Long id);

    BookDTO saveBook(BookDTO newBook);

    // TODO: HW customize this method so it should get sorting options
    Page<BookDTO> getAllBooks(Integer page, Integer size);

    Page<BookDTO> getAllBooks(Pageable pageable);
}
