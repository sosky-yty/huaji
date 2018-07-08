package com.skypointer.huaji.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.skypointer.huaji.bean.Role;
import com.skypointer.huaji.service.base.BaseService;

public interface IRoleService  extends BaseService<Role,Integer>{
    /**
     * 添加或者修改角色
     * @param role
     */
    void saveOrUpdate(Role role);

    /**
     * 给角色分配资源
     * @param id 角色ID
     * @param resourceIds 资源ids
     */
    void grant(Integer id, String[] resourceIds);

}
