package com.diplom.server.dto.converter;

import com.diplom.server.dao.entity.Recap;
import com.diplom.server.dao.entity.Skills;
import com.diplom.server.dto.RecapDto;
import com.diplom.server.dto.SkillsDto;

public class SkillsConverter implements EntityConverter<Skills, SkillsDto> {

    public SkillsDto getDto(Skills entity){
        return SkillsDto.builder()
                .id(entity.getId())
                .skills_name(entity.getSkills_name())
                .grade(entity.getGrade())
                .build();
    }

    @Override
    public Skills getEntity(SkillsDto dto) {
        Skills skills = new Skills();
        skills.setSkills_name(dto.getSkills_name());
        skills.setGrade(dto.getGrade());
        return skills;
    }


}
