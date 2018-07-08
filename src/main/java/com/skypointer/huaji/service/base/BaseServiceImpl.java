package com.skypointer.huaji.service.base;

import com.skypointer.huaji.bean.BaseBean;
import com.skypointer.huaji.dao.BaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Transactional
public abstract class BaseServiceImpl<T extends BaseBean, ID extends Serializable> implements BaseService<T,ID> {

    public abstract BaseDao<T, ID> getBaseDao();

    @Override
    public T find(ID id) {
       return getBaseDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public List<T> findList(ID[] ids) {
        List<ID> idList = Arrays.asList(ids);
        return getBaseDao().findAll(idList);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getBaseDao().findAll(pageable);
    }

    @Override
    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return getBaseDao().findAll(specification, pageable);
    }

    @Override
    public long count() {
        return getBaseDao().count();
    }

    @Override
    public long count(Specification<T> specification) {
        return getBaseDao().count(specification);
    }

    @Override
    public boolean exists(ID id) {
        return getBaseDao().exists(id);
    }

    @Override
    public void save(T bean) {
        getBaseDao().save(bean);
    }

    @Override
    public T update(T bean) {
       return getBaseDao().saveAndFlush(bean);
    }

    @Override
    public void save(Iterable<T> entitys) {
        getBaseDao().save(entitys);
    }

    @Override
    public void delete(ID id) {
        getBaseDao().delete(id);
    }

    @Override
    public void deleteByIds(ID... ids) {
        for (ID id :
                ids) {
            this.delete(id);
        }
    }

    @Override
    public void delete(T[] entitys) {
        List<T> list = Arrays.asList(entitys);
        getBaseDao().delete(list);
    }

    @Override
    public void delete(Iterable<T> entitys) {
        getBaseDao().delete(entitys);
    }

    @Override
    public void delete(T entity) {
        getBaseDao().delete(entity);
    }

    @Override
    public List<T> findList(Specification<T> spec, Sort sort) {
        return getBaseDao().findAll(spec, sort);
    }
}
