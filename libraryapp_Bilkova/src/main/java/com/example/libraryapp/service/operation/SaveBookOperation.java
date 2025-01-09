package com.example.libraryapp.service.operation;

import com.example.libraryapp.model.BookModel;
import com.example.libraryapp.persistence.BookEntity;
import com.example.libraryapp.persistence.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveBookOperation {
    private BookRepository bookRepository;

    public SaveBookOperation (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookModel.getName());
        bookEntity.setAuthor(bookModel.getAuthor());
        bookEntity.setPages(bookModel.getPages());
        bookEntity.setAvailableCopies(bookModel.getAvailableCopies());

        bookRepository.saveAndFlush(bookEntity);
    }
}
