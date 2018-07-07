package com.skypointer.huaji.bean;

import javax.persistence.*;
import java.util.Date;

@IdClass(BorrowBook.class)
@Embeddable
@Entity
@Table(name = "tb_borrow_books")
public class BorrowBook extends BaseBean {


    private static final long serialVersionUID = 3908318518113587708L;

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Id
    @Column(name = "book_id")
    private String bookId;

    @Column(name = "update_time")
    private Date updateTime;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "userId=" + userId +
                ", bookId='" + bookId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
