package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Employees;
import com.diplom.server.dao.entity.Recap;
import com.diplom.server.service.EmployeeService;
import com.diplom.server.service.RecapService;

import java.util.List;

public class RecapServiceImpl extends GenericServiceImpl<Recap> implements RecapService {

    @Override
    public Recap saveOrUpdate(Recap entity) {
        return null;
    }

    @Override
    public Recap findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Recap> findAll() {
        return null;
    }
}
