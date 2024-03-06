package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.mappers.BookMapper;
import kg.alatoo.libraryapp.repostiories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<BookDTO> getAllBooks(Integer page, Integer size) {

        return bookRepository.findAll(getPageable(page, size))
                .map(bookMapper::bookToBookDto);

        /*return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDto)
                .toList();*/
    }

    @Override
    public Page<BookDTO> getAllBooks(Pageable pageable) {
        if (pageable.getPageSize()>1000) {
            // create custom exception and handle it
            pageable = PageRequest.of(pageable.getPageNumber(), 1000, pageable.getSort());
        }


        return bookRepository.findAll(pageable).map(bookMapper::bookToBookDto);
    }

    public PageRequest getPageable(Integer page, Integer size) {

        if (page == null || page < 0)
            page = 0;

        if (size == null || size <= 0)
            size = 25;

        if (size > 1000)
            size = 1000;

//        Sort.by(Sort.Direction.DESC,"publishedYear", "title");
        Sort sort = Sort.by(
                Sort.Order.desc("publishedYear"),
                Sort.Order.asc("title"));

        return PageRequest.of(page, size, sort);
    }

}
