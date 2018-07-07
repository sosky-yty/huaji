package com.skypointer.huaji.dao;

import com.skypointer.huaji.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao  extends BaseDao<Book,String>{

    Book findBookByBookId(String bookid);

    Book findBookByBookName(String bookname);

    Book findBookByBookPress(String boolpress);
}
