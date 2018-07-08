package com.skypointer.huaji.service.impl;

import com.skypointer.huaji.bean.Resource;
import com.skypointer.huaji.bean.Role;
import com.skypointer.huaji.bean.ZtreeNode;
import com.skypointer.huaji.dao.BaseDao;
import com.skypointer.huaji.dao.ResourceDao;
import com.skypointer.huaji.service.IResourceService;
import com.skypointer.huaji.service.IRoleService;
import com.skypointer.huaji.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource,Integer> implements IResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private IRoleService roleService;

    @Override
    @Cacheable(value = "resourceCache", key = "'tree' + #roleId")
    public List<ZtreeNode> tree(int roleId) {
        List<ZtreeNode> resulTreeNodes = new ArrayList<ZtreeNode>();
        Role role = roleService.find(roleId);
        Set<Resource> roleResources = role.getResources();
        resulTreeNodes.add(new ZtreeNode(0L, null, "系统菜单", true));
        ZtreeNode node;
        Sort sort = new Sort(Sort.Direction.ASC, "parent", "id", "sort");
        List<Resource> all = resourceDao.findAll(sort);
        for (Resource resource : all) {
            node = new ZtreeNode();
            node.setId(Long.valueOf(resource.getId()));
            if (resource.getParent() == null) {
                node.setpId(0L);
            } else {
                node.setpId(Long.valueOf(resource.getParent().getId()));
            }
            node.setName(resource.getName());
            if (roleResources != null && roleResources.contains(resource)) {
                node.setChecked(true);
            }
            resulTreeNodes.add(node);
        }
        return resulTreeNodes;
    }

    @Override
    @CacheEvict(value = "resourceCache")
    public void saveOrUpdate(Resource resource) {
        if(resource.getId() != null){
            Resource dbResource = find(resource.getId());
            dbResource.setUpdateTime(new Date());
            dbResource.setName(resource.getName());
            dbResource.setSourceKey(resource.getSourceKey());
            dbResource.setType(resource.getType());
            dbResource.setSourceUrl(resource.getSourceUrl());
            dbResource.setLevel(resource.getLevel());
            dbResource.setSort(resource.getSort());
            dbResource.setIsHide(resource.getIsHide());
            dbResource.setIcon(resource.getIcon());
            dbResource.setDescription(resource.getDescription());
            dbResource.setUpdateTime(new Date());
            dbResource.setParent(resource.getParent());
            update(dbResource);
        }else{
            resource.setCreateTime(new Date());
            resource.setUpdateTime(new Date());
            save(resource);
        }
    }

    @Override
    @CacheEvict(value = "resourceCache")
    public void delete(Integer id) {
        resourceDao.deleteGrant(id);
        super.delete(id);
    }


    @Override
    public BaseDao<Resource, Integer> getBaseDao() {
        return this.resourceDao;
    }
}
