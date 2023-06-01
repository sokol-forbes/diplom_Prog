package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.BusinessTrips;
import com.diplom.server.dto.BusinessTripsDto;

public class BusissnesTripsConverter implements EntityConverter<BusinessTrips, BusinessTripsDto> {

    public BusinessTripsDto getDto(BusinessTrips entity){
        return BusinessTripsDto.builder()
                .id(entity.getId())
                .end_date(entity.getEnd_date())
                .start_date(entity.getStart_date())
                .employees(entity.getEmployees())
                .build();
    }

    @Override
    public BusinessTrips getEntity(BusinessTripsDto dto) {
        BusinessTrips businessTrips = new BusinessTrips();
        businessTrips.setEnd_date(dto.getEnd_date());
        businessTrips.setStart_date(dto.getStart_date());
        businessTrips.setEmployees(dto.getEmployees());
        return businessTrips;
    }


}
