package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.Accounts;
import com.diplom.server.service.AccountService;

import java.util.List;

public class AccountServiceImpl extends GenericServiceImpl<Accounts> implements AccountService {

    @Override
    public Accounts saveOrUpdate(Accounts entity) {
        return null;
    }

    @Override
    public Accounts findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Accounts> findAll() {
        return null;
    }
}
