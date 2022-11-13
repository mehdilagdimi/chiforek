package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Book;
import com.mehdilagdimi.chiforek.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }
}
