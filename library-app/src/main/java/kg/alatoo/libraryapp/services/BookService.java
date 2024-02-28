package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;

import java.util.Optional;

public interface BookService {
    Optional<BookDTO> getBookById(Long id);
}
