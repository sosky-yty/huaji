package com.skypointer.huaji.service.impl;

import com.skypointer.huaji.bean.Book;
import com.skypointer.huaji.dao.BaseDao;
import com.skypointer.huaji.dao.BookDao;
import com.skypointer.huaji.service.IBookService;
import com.skypointer.huaji.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book,String> implements IBookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public BaseDao<Book, String> getBaseDao() {
        return this.bookDao;
    }


    @Override
    public Book findByBookId(String id) {
        return bookDao.findBookByBookId(id);
    }

    @Override
    public Book findByBookName(String bookName) {
        return bookDao.findBookByBookName(bookName);
    }

    @Override
    public Book findByBookPress(String bookPress) {
        return bookDao.findBookByBookPress(bookPress);
    }

    @Override
    public void saveOrUpdate(Book book) {
        save(book);
    }
}
