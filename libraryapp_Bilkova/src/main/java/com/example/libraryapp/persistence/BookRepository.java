package com.example.libraryapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {
    List<BookEntity> findByAvailableCopiesGreaterThan(int availableCopies);
    List<BookEntity> findByAvailableCopiesLessThan(int availableCopies);
}
