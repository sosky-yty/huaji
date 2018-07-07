package com.skypointer.huaji.dao;

import com.skypointer.huaji.bean.Resource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDao extends BaseDao<Resource,Integer>{


    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM tb_role_resource WHERE resource_id = :id")
    void deleteGrant(@Param("id") Integer id);

}
