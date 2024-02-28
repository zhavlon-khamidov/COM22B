package kg.alatoo.libraryapp.controllers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    @PostMapping("/api/v1/book")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook) {
        newBook.setId(null);
        BookDTO savedBook = bookService.saveBook(newBook);
        return ResponseEntity
                .created(URI.create("/api/v1/book/" + savedBook.getId()))
                .body(savedBook);
    }

    @GetMapping("/api/v1/book/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Resource with id:%d Not Found", id)
                ));
//                .orElseThrow(NotFoundException::new);
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



}
