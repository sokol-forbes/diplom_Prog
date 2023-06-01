package com.diplom.server.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class SkillsDto {

    private Long id;

    private String skills_name;

    private String grade;

}
