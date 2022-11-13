package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//    @RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Book> books = bookService.list();

        assertEquals( 3, books.size());
    }
}