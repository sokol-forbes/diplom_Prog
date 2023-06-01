package com.diplom.server.dto;

import com.diplom.server.dao.entity.Employees;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;


@Data
@Builder
public class VacationDto {

    private Long id;

    private Calendar end_date;

    private Calendar start_date;


    private Employees employees;

}
