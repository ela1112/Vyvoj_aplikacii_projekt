package com.example.libraryapp.service;

import com.example.libraryapp.model.BookModel;
import com.example.libraryapp.service.operation.GetBooksOperation;
import com.example.libraryapp.service.operation.SaveBookOperation;
import com.example.libraryapp.service.operation.UpdateBookOperation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {
    private final GetBooksOperation getBooksOperation;
    private final SaveBookOperation saveBookOperation;
    private final UpdateBookOperation updateBookOperation;

    public BookServiceImpl(GetBooksOperation getBooksOperation, SaveBookOperation saveBookOperation, UpdateBookOperation updateBookOperation) {
        this.getBooksOperation = getBooksOperation;
        this.saveBookOperation = saveBookOperation;
        this.updateBookOperation = updateBookOperation;
    }

    @Override
    public void saveBook(BookModel bookModel) {
        saveBookOperation.saveBook(bookModel);
    }

    @Override
    public boolean borrowBook(String bookName) {
        return updateBookOperation.borrowBook(bookName);
    }

    @Override
    public Optional<String> returnBook(String bookName) {
        return updateBookOperation.returnBook(bookName);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return getBooksOperation.getAllBooks();
    }

    @Override
    public List<BookModel> getAvailableBooks() {
        return getBooksOperation.getAvailableBooks();
    }

    @Override
    public List<BookModel> getUnavailableBooks() {
        return getBooksOperation.getUnavailableBooks();
    }
}
