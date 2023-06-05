package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Employees;
import com.diplom.server.service.EmployeeService;
import com.diplom.server.service.VacancyService;

import java.util.List;

public class VacancyServiceImpl extends GenericServiceImpl<Vacancy> implements VacancyService {

    @Override
    public Vacancy saveOrUpdate(Vacancy entity) {
        return null;
    }

    @Override
    public Vacancy findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Vacancy> findAll() {
        return null;
    }
}
