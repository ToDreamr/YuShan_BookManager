package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/13 18:11
 */
public interface BookService {
    List<Borrow> getBorrowList();
    void returnBook(String id);

    List<Student> getStudentList();
    List<Borrow> getAllBorrowList();

    void addBorrow(int sid, int bid);

    void addBook(String title, double price);

    List<Book> getActiveBookList();

    void deleteBook(int bid);

    Map<Object, Object> getBookList();

    Book getBook();
}
