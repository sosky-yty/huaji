package com.skypointer.huaji.service;

import com.skypointer.huaji.bean.Resource;
import com.skypointer.huaji.bean.ZtreeNode;
import com.skypointer.huaji.service.base.BaseService;

import java.util.List;

public interface IResourceService extends BaseService<Resource, Integer> {

    /**
     * 获取角色的权限树
     * @param roleId
     * @return
     */
    List<ZtreeNode> tree(int roleId);

    /**
     * 修改或者新增资源
     * @param resource
     */
    void saveOrUpdate(Resource resource);

}
