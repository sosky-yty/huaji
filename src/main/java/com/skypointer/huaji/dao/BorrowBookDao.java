package com.skypointer.huaji.dao;

import com.skypointer.huaji.bean.BorrowBook;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookDao extends BaseDao<BorrowBook,String> {
    BorrowBook[]  findBorrowBookByUserId(int user_id);

    BorrowBook[] findBorrowBookByBookId(String book_id);

    BorrowBook findBorrowBookByUserIdAndBookId(int user_id,String book_id);

    @Modifying
    @Query("DELETE FROM BorrowBook b WHERE b.userId = ?1 and b.bookId= ?2")
    void mDelet(int userId,String bookId);
}
