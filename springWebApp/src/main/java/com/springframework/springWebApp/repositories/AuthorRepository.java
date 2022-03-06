package com.springframework.springWebApp.repositories;

import com.springframework.springWebApp.domain.Author;
import com.springframework.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Book> {
}
