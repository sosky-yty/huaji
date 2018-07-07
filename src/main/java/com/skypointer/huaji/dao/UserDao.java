package com.skypointer.huaji.dao;

import com.skypointer.huaji.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends BaseDao<User,Integer>{

    User findUserByUserName(String username);

    User findUserByUserCode(String usercode);
}
