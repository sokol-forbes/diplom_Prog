package com.diplom.server.dto;

import com.diplom.server.dao.entity.Employees;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;


@Data
@Builder
public class IncentivesDto {


    private Long id;

    private String incentives;


    private String qualification;


    private Calendar date_incentive;



    private Employees employees;

}
