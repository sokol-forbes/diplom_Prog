package com.diplom.server.service;

import java.util.List;

public interface CrudOperations <T>{
    T saveOrUpdate(T entity);
    T findById( Integer id);
    void deleteById(Integer id);
    List<T> findAll();
}
