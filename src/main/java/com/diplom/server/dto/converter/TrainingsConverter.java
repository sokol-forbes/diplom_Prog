package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Skills;
import com.diplom.server.dao.entity.Trainings;
import com.diplom.server.dto.SkillsDto;
import com.diplom.server.dto.TrainingsDto;

public class TrainingsConverter implements EntityConverter<Trainings, TrainingsDto> {

    public TrainingsDto getDto(Trainings entity){
        return TrainingsDto.builder()
                .id(entity.getId())
                .place(entity.getPlace())
                .qualification(entity.getQualification())
                .start_date(entity.getStart_date())
                .end_date(entity.getEnd_date())
                .employees(entity.getEmployees())
                .build();
    }

    @Override
    public Trainings getEntity(TrainingsDto dto) {
        Trainings trainings = new Trainings();
        trainings.setPlace(dto.getPlace());
        trainings.setQualification(dto.getQualification());
        trainings.setStart_date(dto.getStart_date());
        trainings.setEnd_date(dto.getEnd_date());
        trainings.setEmployees(dto.getEmployees());

        return trainings;
    }


}
