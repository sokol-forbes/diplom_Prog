package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Incentives;
import com.diplom.server.dto.IncentivesDto;

public class IncentivesConverter implements EntityConverter<Incentives, IncentivesDto> {

    public IncentivesDto getDto(Incentives entity){
        return IncentivesDto.builder()
                .id(entity.getId())
                .date_incentive(entity.getDate_incentive())
                .employees(entity.getEmployees())
                .build();
    }

    @Override
    public Incentives getEntity(IncentivesDto dto) {
        Incentives incentives = new Incentives();

        incentives.setDate_incentive(dto.getDate_incentive());
        incentives.setEmployees(dto.getEmployees());
        return incentives;
    }


}
