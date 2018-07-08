package com.skypointer.huaji.service;

import com.skypointer.huaji.bean.Role;
import com.skypointer.huaji.bean.User;
import com.skypointer.huaji.service.base.BaseService;
import org.omg.PortableInterceptor.USER_EXCEPTION;

public interface IUserService extends BaseService<User,Integer>{
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUserName(String username);

    User findByUserCode(String userCode);

    /**
     * 增加或者修改用户
     * @param user
     */
    void saveOrUpdate(User user);

    /**
     * 给用户分配角色
     * @param id 用户ID
     * @param roleIds 角色Ids
     */
    void grant(Integer id, String[] roleIds);
}
