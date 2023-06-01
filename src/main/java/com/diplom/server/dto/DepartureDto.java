package com.diplom.server.dto;

import com.diplom.server.dao.entity.Employees;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class DepartureDto {
    private Long id;
    private String departure_name;
    private Employees employees;
}
