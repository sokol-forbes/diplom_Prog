package com.diplom.server.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;


public class BusinessTrips {


    private Long id;

    private String place;

    private Calendar end_date;

    private Calendar start_date;


    private Employees employees;

}
