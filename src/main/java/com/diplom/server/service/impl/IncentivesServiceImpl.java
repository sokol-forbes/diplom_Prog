package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Employees;
import com.diplom.server.dao.entity.Incentives;
import com.diplom.server.service.EmployeeService;
import com.diplom.server.service.IncentivesService;

import java.util.List;

public class IncentivesServiceImpl extends GenericServiceImpl<Incentives> implements IncentivesService {

    @Override
    public Incentives saveOrUpdate(Incentives entity) {
        return null;
    }

    @Override
    public Incentives findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Incentives> findAll() {
        return null;
    }
}
