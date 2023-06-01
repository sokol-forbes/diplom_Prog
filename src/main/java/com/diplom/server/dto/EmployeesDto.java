package com.diplom.server.dto;

import com.diplom.server.dao.entity.Departure;
import com.diplom.server.dao.entity.Vacancy;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Calendar;
@Data
@Builder
public class EmployeesDto {

    private Long id;


    private Vacancy vacancy;


    private String status;


    private Calendar begin_date;


    private Calendar last_promotion_date;


    private Departure departure;
}
