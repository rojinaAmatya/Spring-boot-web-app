package com.springframework.springWebApp.repositories;

import com.springframework.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
