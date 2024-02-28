package kg.alatoo.libraryapp.controllers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

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
