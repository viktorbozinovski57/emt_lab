package com.example.rest_con.rest_controllers;

import com.example.rest_con.models.Book;
import com.example.rest_con.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> seeAll(){
        return bookService.findAll();
    }

    @GetMapping("/books")
    public List<Book> seeAllBooks(){
        return bookService.findAll();
    }

    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/edit-book/{bookId}")
    public ResponseEntity<Book> editBook(@PathVariable long bookId, @RequestBody Book book){
        return ResponseEntity.ok().body(bookService.editBooks(bookId,book));
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
