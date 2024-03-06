package kg.alatoo.libraryapp.controllers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookApiController {

    @GetMapping
    public Page<BookDTO> getBooks(
            @PageableDefault(
                    size = 25,
                    sort = {"publishedYear", "title"},
                    direction = Sort.Direction.DESC)
            Pageable pageable
//            @RequestParam(required = false, defaultValue = "0") Integer page,
//            @RequestParam(required = false, defaultValue = "25") Integer size,
//            String[] sort
    ) {

        System.out.println("pageable = " + pageable);

        /*System.out.println("page = " + page);
        System.out.println("size = " + size);
        System.out.println("sort = " + String.join("; ",sort));*/

        return bookService.getAllBooks(pageable);
    }

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@Validated @RequestBody BookDTO newBook) {
        newBook.setId(null);
        BookDTO savedBook = bookService.saveBook(newBook);
        return ResponseEntity
                .created(URI.create("/api/v1/book/" + savedBook.getId()))
                .body(savedBook);
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Resource with id:%d Not Found", id)
                ));
//                .orElseThrow(NotFoundException::new);
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



}
