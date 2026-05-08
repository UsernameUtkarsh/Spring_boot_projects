package com.bharath.lms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.lms.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
