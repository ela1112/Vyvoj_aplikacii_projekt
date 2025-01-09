package com.example.libraryapp.service.operation;

import com.example.libraryapp.model.BookModel;
import com.example.libraryapp.persistence.BookEntity;
import com.example.libraryapp.persistence.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetBooksOperation {
    private BookRepository bookRepository;

    public GetBooksOperation (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return convert(bookRepository.findAll());
    }

    public List<BookModel> getAvailableBooks() {
        return convert(bookRepository.findByAvailableCopiesGreaterThan(0));
    }

    public List<BookModel> getUnavailableBooks() {
        return convert(bookRepository.findByAvailableCopiesLessThan(1));
    }

    private List<BookModel> convert(List<BookEntity> bookEntityList) {
        return bookEntityList
                .stream()
                .map(bookEntity -> {
                    BookModel bookModel = new BookModel();
                    bookModel.setName(bookEntity.getName());
                    bookModel.setAuthor(bookEntity.getAuthor());
                    bookModel.setPages(bookEntity.getPages());
                    bookModel.setAvailableCopies(bookEntity.getAvailableCopies());
                    return bookModel;
                })
                .collect(Collectors.toList());
    }
}
