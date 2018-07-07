package com.skypointer.huaji.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book extends BaseBean{
    private static final long serialVersionUID = 3908318518113587708L;

    @Id
    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_press")
    private String bookPress;

    @Column(name = "book_inventory", nullable = false)
    private int bookInventory;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "current_inventory")
    private int currentInventory;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public int getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(int bookInventory) {
        this.bookInventory = bookInventory;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(int currentInventory) {
        this.currentInventory = currentInventory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookInventory='" + bookInventory + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", currentInventory='" + currentInventory + '\'' +
                '}';
    }
}
