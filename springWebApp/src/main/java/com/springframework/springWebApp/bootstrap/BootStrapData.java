package com.springframework.springWebApp.bootstrap;

import com.springframework.springWebApp.domain.Author;
import com.springframework.springWebApp.domain.Book;
import com.springframework.springWebApp.domain.Publisher;
import com.springframework.springWebApp.repositories.AuthorRepository;
import com.springframework.springWebApp.repositories.BookRepository;
import com.springframework.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddress("");
        publisher.setCity("St. Petersburg");
        publisher.setState("NYC");
        publisher.setZip(112251);

        publisherRepository.save(publisher);
        System.out.println("Started in Bootstrap");
        System.out.println("Publisher Count: " + publisherRepository.count());

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


        System.out.println("Number of Books:" + bookRepository.count());


    }
}
