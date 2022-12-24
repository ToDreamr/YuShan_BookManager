package com.book.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Borrow {
    int id;
    int book_id;
    String book_name;
    String student_name;
    Date time;
    int student_id;

    public String getTime() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd   HH:mm:mm");
        return  dateFormat.format(this.time);
    }

}
