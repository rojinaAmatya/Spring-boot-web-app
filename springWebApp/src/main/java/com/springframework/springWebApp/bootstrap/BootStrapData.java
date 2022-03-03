package com.springframework.springWebApp.bootstrap;

import com.springframework.springWebApp.domain.Author;
import com.springframework.springWebApp.domain.Book;
import com.springframework.springWebApp.repositories.AuthorRepository;
import com.springframework.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author colleen = new Author("Colleen" ,"Hoover");
        Book bk = new Book("Reminders of Him","123123");
        colleen.getBooks().add(bk);
        bk.getAuthors().add(colleen);

        authorRepository.save(colleen);
        bookRepository.save(bk);

        Author eric = new Author("Eric", "Evans");
        Book bk1 = new Book("Domain Driven Design", "465456");
        eric.getBooks().add(bk1);
        bk1.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(bk1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());


    }
}
