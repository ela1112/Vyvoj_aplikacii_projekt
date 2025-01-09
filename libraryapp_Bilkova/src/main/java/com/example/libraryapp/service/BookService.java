package com.example.libraryapp.service;

import com.example.libraryapp.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void saveBook(BookModel bookModel);

    boolean borrowBook(String bookName);
    Optional<String> returnBook(String bookName);

    List<BookModel> getAllBooks();
    List<BookModel> getAvailableBooks();
    List<BookModel> getUnavailableBooks();
}
