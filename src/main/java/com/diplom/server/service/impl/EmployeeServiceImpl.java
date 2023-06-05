package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Departure;
import com.diplom.server.dao.entity.Employees;
import com.diplom.server.service.DepartmentService;
import com.diplom.server.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl extends GenericServiceImpl<Employees> implements EmployeeService {

    @Override
    public Employees saveOrUpdate(Employees entity) {
        return null;
    }

    @Override
    public Employees findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Employees> findAll() {
        return null;
    }
}
