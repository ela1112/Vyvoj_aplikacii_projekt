package com.example.libraryapp.service.operation;

import com.example.libraryapp.model.BookModel;
import com.example.libraryapp.persistence.BookEntity;
import com.example.libraryapp.persistence.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateBookOperation {
    private BookRepository bookRepository;

    public UpdateBookOperation (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean borrowBook(String bookName) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookName);
        if (optionalBookEntity.isPresent()) {
            BookEntity bookEntity = optionalBookEntity.get();
            bookEntity.setAvailableCopies(bookEntity.getAvailableCopies() - 1);
            bookRepository.saveAndFlush(bookEntity);
            return true;
        }
        return false;
    }

    public Optional<String> returnBook(String bookName) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(bookName);
        if (optionalBookEntity.isPresent()) {
            BookEntity bookEntity = optionalBookEntity.get();
            bookEntity.setAvailableCopies(bookEntity.getAvailableCopies() + 1);
            bookRepository.saveAndFlush(bookEntity);
            return Optional.of(bookName);
        }
        return Optional.empty();
    }
}
