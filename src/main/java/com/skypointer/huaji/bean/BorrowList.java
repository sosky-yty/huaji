package com.skypointer.huaji.bean;

import java.util.Arrays;

public class BorrowList extends BaseBean {
    private static final long serialVersionUID = -1894163644285296223L;

    private int id;
    private String[] booklist;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String[] getBooklist() {
        return booklist;
    }
    public void setBooklist(String[] booklist) {
        this.booklist = booklist;
    }
    @Override
    public String toString() {
        return "BorrowList [id=" + id + ", booklist=" + Arrays.toString(booklist) + "]";
    }


}
