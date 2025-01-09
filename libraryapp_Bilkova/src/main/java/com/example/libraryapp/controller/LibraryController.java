package com.example.libraryapp.controller;

import com.example.libraryapp.model.BookModel;
import com.example.libraryapp.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {
    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/available")
    public List<BookModel> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @GetMapping("/books/unavailable")
    public List<BookModel> getUnAvailableBooks() {
        return bookService.getUnavailableBooks();
    }

    @PostMapping("/books/borrow")
    public String borrowBook(@RequestBody String bookName) {
        if (bookService.borrowBook(bookName)) {
            return "You borrowed book: " + bookName + " successfully.";
        }
        else {
            return "You cannot borrow book: " + bookName + " .";
        }
    }

    @PostMapping("/books/return")
    public String returnBook(@RequestBody String bookName) {
        Optional<String> optionalBookName = bookService.returnBook(bookName);
        return optionalBookName
                .map(bookNameInner -> "You have successfully returned book: " + bookNameInner + " .")
                .orElseGet(() -> "You cannot return book: " + bookName);
    }
}
