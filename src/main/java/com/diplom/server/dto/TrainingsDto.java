package com.diplom.server.dto;

import com.diplom.server.dao.entity.Employees;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;

@Data
@Builder
public class TrainingsDto {


    private Long id;


    private String place;


    private String qualification;


    private Calendar start_date;


    private Calendar end_date;


    private Employees employees;

}
