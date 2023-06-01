package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Departure;
import com.diplom.server.dto.DepartureDto;

public class DepartureConverter implements EntityConverter<Departure, DepartureDto> {
    public DepartureDto getDto(Departure entity){
        return DepartureDto.builder()
                .id(entity.getId())
                .departure_name(entity.getDeparture_name())
                .employees(entity.getEmployees())
                .build();
    }

    @Override
    public Departure getEntity(DepartureDto dto) {
        Departure departure = new Departure();
        departure.setDeparture_name(dto.getDeparture_name());
        departure.setEmployees(dto.getEmployees());
        return departure;
    }


}
