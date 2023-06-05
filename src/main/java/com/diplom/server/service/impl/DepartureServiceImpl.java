package com.diplom.server.service.impl;

import com.diplom.server.dao.entity.BusinessTrips;
import com.diplom.server.dao.entity.Departure;
import com.diplom.server.service.BussinesTripService;
import com.diplom.server.service.DepartmentService;

import java.util.List;

public class DepartureServiceImpl extends GenericServiceImpl<Departure> implements DepartmentService {

    @Override
    public Departure saveOrUpdate(Departure entity) {
        return null;
    }

    @Override
    public Departure findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Departure> findAll() {
        return null;
    }
}
