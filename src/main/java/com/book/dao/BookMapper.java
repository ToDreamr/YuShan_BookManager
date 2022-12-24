package com.book.dao;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/11 15:42
 */
public interface BookMapper {
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "sid", property = "student_id")
            //做好映射
    })

    @Select("select *from borrow,student,book where borrow.bid=book.bid and student.sid=borrow.sid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(String id);

    @Select("select * from student")
    List<Student> getStudentList();

    @Select("select *from borrow")
    List<Borrow> getAllBorrowList();

    @Insert("insert into borrow(sid,bid) values(#{sid},#{bid})")
    void addBorrow(@Param("sid")int sid,@Param("bid") int bid);

    @Select("select *from book")
    Book getBook();

    @Delete("delete from book where bid=#{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(title,price) values(#{title},#{price})")
    void  addBook(@Param("title") String title,@Param("price") double price);
}
