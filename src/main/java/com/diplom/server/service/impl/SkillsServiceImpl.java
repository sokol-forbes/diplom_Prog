package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Employees;
import com.diplom.server.dao.entity.Skills;
import com.diplom.server.service.EmployeeService;
import com.diplom.server.service.SkillsService;

import java.util.List;

public class SkillsServiceImpl extends GenericServiceImpl<Skills> implements SkillsService {

    @Override
    public Skills saveOrUpdate(Skills entity) {
        return null;
    }

    @Override
    public Skills findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Skills> findAll() {
        return null;
    }
}
