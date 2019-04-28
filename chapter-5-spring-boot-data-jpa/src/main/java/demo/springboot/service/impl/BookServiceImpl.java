package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }
}
