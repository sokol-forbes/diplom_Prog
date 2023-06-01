package com.diplom.server.dto;

import com.diplom.server.dao.entity.Vacancy;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class RecapDto {

    private Long id;


    private String surname;

    private String name;


    private String patronymic;


    private String education;


    private String experience;


    private Vacancy vacancy;

}
