package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Departure;
import com.diplom.server.dao.entity.Recap;
import com.diplom.server.dto.DepartureDto;
import com.diplom.server.dto.RecapDto;

public class RecapConverter implements EntityConverter<Recap, RecapDto> {
    public RecapDto getDto(Recap entity){
        return RecapDto.builder()
                .id(entity.getId())
                .surname(entity.getSurname())
                .name(entity.getName())
                .patronymic(entity.getPatronymic())
                .education(entity.getEducation())
                .experience(entity.getExperience())
                .vacancy(entity.getVacancy())
                .build();
    }

    @Override
    public Recap getEntity(RecapDto dto) {
        Recap recap = new Recap();
        recap.setSurname(dto.getSurname());
        recap.setName(dto.getName());
        recap.setPatronymic(dto.getPatronymic());
        recap.setEducation(dto.getEducation());
        recap.setExperience(dto.getExperience());
        recap.setVacancy(dto.getVacancy());
        return recap;
    }


}
