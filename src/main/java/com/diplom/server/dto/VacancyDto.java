package com.diplom.server.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class VacancyDto {

    private Long id;


    private String need_experience;

    private String position;

    private String description;

}
