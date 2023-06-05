package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Employees;
import com.diplom.server.dao.entity.Vacation;
import com.diplom.server.service.EmployeeService;
import com.diplom.server.service.VacationService;

import java.util.List;

public class VacationServiceImpl extends GenericServiceImpl<Vacation> implements VacationService {

    @Override
    public Vacation saveOrUpdate(Vacation entity) {
        return null;
    }

    @Override
    public Vacation findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Vacation> findAll() {
        return null;
    }
}
