package com.skypointer.huaji.service.impl;

import com.skypointer.huaji.bean.BorrowBook;
import com.skypointer.huaji.dao.BaseDao;
import com.skypointer.huaji.dao.BorrowBookDao;
import com.skypointer.huaji.service.IBorrowBookService;
import com.skypointer.huaji.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookServiceImpl extends BaseServiceImpl<BorrowBook,String> implements IBorrowBookService {

    @Autowired
    private BorrowBookDao borrowBookDao;

    @Override
    public BorrowBook[] findByUserId(int userId) {
        // TODO Auto-generated method stub
        return borrowBookDao.findBorrowBookByUserId(userId);
    }

    @Override
    public BorrowBook[] findByBookId(String bookId) {
        return borrowBookDao.findBorrowBookByBookId(bookId);
    }

    @Override
    public BorrowBook findByUserIdAndBookId(int userId, String bookId) {
        return borrowBookDao.findBorrowBookByUserIdAndBookId(userId, bookId);
    }

    @Override
    public void saveOrUpdate(BorrowBook borrowBook) {
        save(borrowBook);
    }

    @Override
    public void deletByUserIdAndBookId(int userId, String bookId) {
        borrowBookDao.mDelet(userId, bookId);
    }

    @Override
    public BaseDao<BorrowBook, String> getBaseDao() {
        return this.borrowBookDao;
    }
}
