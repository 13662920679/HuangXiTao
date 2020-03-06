package com.ithxt.service;

import com.ithxt.dao.BookDao;
import com.ithxt.domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    BookDao bd=new BookDao();
    public List<Book> findAllBook(String category) throws SQLException {
        return bd.findAllBook(category);
    }

    public Book findBookById(String id) throws SQLException {
       return bd.findBookById(id);
    }
}
