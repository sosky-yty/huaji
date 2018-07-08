package com.skypointer.huaji.service;

import com.skypointer.huaji.bean.Book;
import com.skypointer.huaji.service.base.BaseService;

public interface IBookService extends BaseService<Book,String>{
    /**
     * 根据图书id查找图书
     * @parameter id
     * @return Book
     */
    Book findByBookId(String id);

    /**
     * 根据书名查图书
     * @parameter bookName
     * @return Book
     */
    Book findByBookName(String bookName);

    /**
     * 根据类别查图书
     * @parameter bookPress
     * @return Book
     */
    Book findByBookPress(String bookPress);

    /**
     * 保存或更新图书信息
     * @parameter book
     * @return void
     */
    void saveOrUpdate(Book book);
}
