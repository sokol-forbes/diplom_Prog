package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Vacancy;
import com.diplom.server.dao.entity.Vacation;
import com.diplom.server.dto.VacancyDto;
import com.diplom.server.dto.VacationDto;

public class VacationConverter implements EntityConverter<Vacation, VacationDto> {

    public VacationDto getDto(Vacation entity){
        return VacationDto.builder()
                .id(entity.getId())
                .end_date(entity.getEnd_date())
                .start_date(entity.getStart_date())
                .employees(entity.getEmployees())
                .build();
    }

    @Override
    public Vacation getEntity(VacationDto dto) {
        Vacation vacation = new Vacation();
        vacation.setEnd_date(dto.getEnd_date());
        vacation.setStart_date(dto.getStart_date());
        vacation.setEmployees(dto.getEmployees());
        return vacation;
    }


}
