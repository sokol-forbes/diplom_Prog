package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Skills;
import com.diplom.server.dao.entity.Vacancy;
import com.diplom.server.dto.SkillsDto;
import com.diplom.server.dto.VacancyDto;

public class VacancyConverter implements EntityConverter<Vacancy, VacancyDto> {

    public VacancyDto getDto(Vacancy entity){
        return VacancyDto.builder()
                .id(entity.getId())
                .need_experience(entity.getNeed_experience())
                .position(entity.getPosition())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public Vacancy getEntity(VacancyDto dto) {
        Vacancy vacancy = new Vacancy();
        vacancy.setNeed_experience(dto.getNeed_experience());
        vacancy.setPosition(dto.getPosition());
        vacancy.setDescription(dto.getDescription());
        return vacancy;
    }


}
