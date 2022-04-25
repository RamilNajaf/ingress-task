package com.ingressaca.bookstoretask.controller;

import com.ingressaca.bookstoretask.dto.BookDTO;
import com.ingressaca.bookstoretask.entity.Book;
import com.ingressaca.bookstoretask.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")

public class BookController extends GenericController<BookDTO, Book> {

    private final BookService bookService;

    public BookController(BookService bookService) {
        super(bookService);
        this.bookService = bookService;
    }

    @PutMapping("/{bookId}/update_by_publisher")
    public ResponseEntity<BookDTO> updateByPublisher(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateByPublisher(bookId, bookDTO));
    }

    @DeleteMapping("/{bookId}/delete_by_publisher")
    public ResponseEntity deleteByPublisher(@PathVariable Long bookId) {
        bookService.deleteByPublisher(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find_specific_book")
    public ResponseEntity<List<BookDTO>> findSpecificBookWithFilter(@RequestParam(value = "name", required = false) String name,
                                                                    @RequestParam(value = "price", required = false) String price,
                                                                    @RequestParam(value = "author_id", required = false) Long authorId,
                                                                    @RequestParam(value = "price_id", required = false) Long priceId) {

        return ResponseEntity.ok(bookService.findSpecificBookWithFilter(name, price, authorId, priceId));

    }
}