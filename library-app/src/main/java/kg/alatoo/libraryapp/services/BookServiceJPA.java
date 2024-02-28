package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.mappers.BookMapper;
import kg.alatoo.libraryapp.repostiories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceJPA implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;


    public BookDTO convertEntityToDTO(Book book) {
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return Optional.ofNullable(
                bookMapper.bookToBookDto(
                        bookRepository.findById(id)
                                .orElse(null)
                )
        );
    }

    @Override
    public BookDTO saveBook(BookDTO newBook) {
        return bookMapper
                .bookToBookDto(
                        bookRepository.save(bookMapper.bookDtoToBook(newBook))
                );
    }

}
