package com.book.service.impl;

import com.book.dao.BookMapper;
import com.book.dao.UserMapper;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;
import com.book.entity.User;
import com.book.service.BookService;
import com.book.util.SqlUtils;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/13 18:12
 */
public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrowList() {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
           return bookMapper.getBorrowList();
        }
    }

    @Override
    @SneakyThrows
    public void returnBook(String id) {
        try (SqlSession sqlSession = SqlUtils.getSqlSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.deleteBorrow(id);
        }
    }
//获取学生列表，熟悉相关的类之间的实现方法
    @Override
    public List<Student> getStudentList() {
        List<Student> students=null;

        try (SqlSession sqlSession = SqlUtils.getSqlSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            students=mapper.getStudentList();
        }
        return students;
    }

    @Override
    public List<Borrow> getAllBorrowList() {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBorrowList();
        }
    }

    @Override
    public void addBorrow(int sid, int bid) {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            bookMapper.addBorrow(sid,bid);
        }
    }

    @Override
    public void addBook(String title, double price) {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            bookMapper.addBook(title,price);
        }
    }

    @Override
    public List<Book> getActiveBookList() {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            return (List<Book>) bookMapper.getBook();
        }
    }

    @Override
    public void deleteBook(int bid) {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            bookMapper.deleteBook(bid);
        }
    }

    @Override
    public Map<Object, Object> getBookList() {
        return null;
    }

    @Override
    public Book getBook() {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
            return (Book) bookMapper.getBook();
        }
    }
}
