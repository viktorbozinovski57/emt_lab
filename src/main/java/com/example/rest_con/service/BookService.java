package com.example.rest_con.service;

import com.example.rest_con.models.Book;
import com.example.rest_con.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public Book editBooks(long bookId,Book bookDetails){
        Book book = bookRepo.findById(bookId).orElse(null);
        book.setAuthor(bookDetails.getAuthor());
        book.setName(bookDetails.getName());
        book.setCategory(bookDetails.getCategory());
        book.setAvailableCopies(bookDetails.getAvailableCopies());
        //bookRepo.save(book);
        return bookRepo.save(book);
    }

    public ResponseEntity<?> deleteBook(long bookId){
        this.bookRepo.deleteById(bookId);
        return ResponseEntity.ok().build();
    }

}
