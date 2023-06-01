package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Departure;
import com.diplom.server.dao.entity.Employees;
import com.diplom.server.dto.DepartureDto;
import com.diplom.server.dto.EmployeesDto;

public class EmployeesConverter implements EntityConverter<Employees, EmployeesDto> {
    public EmployeesDto getDto(Employees entity){
        return EmployeesDto.builder()
                .id(entity.getId())
                .vacancy(entity.getVacancy())
                .status(entity.getStatus())
                .begin_date(entity.getBegin_date())
                .last_promotion_date(entity.getLast_promotion_date())
                .departure(entity.getDeparture())
                .build();
    }

    @Override
    public Employees getEntity(EmployeesDto dto) {
        Employees employees = new Employees();
        employees.setVacancy(dto.getVacancy());
        employees.setStatus(dto.getStatus());
        employees.setBegin_date(dto.getBegin_date());
        employees.setLast_promotion_date(dto.getLast_promotion_date());
        employees.setDeparture(dto.getDeparture());
        return employees;
    }


}
