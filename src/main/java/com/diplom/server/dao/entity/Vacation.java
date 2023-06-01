package com.diplom.server.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Incentives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String incentives;

    @Column(nullable = false)
    private String qualification;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar date_incentive;


    @OneToOne
    @JoinColumn(name = "employees_id", foreignKey = @ForeignKey(name = "FK_employees_id_employees"))
    @ToString.Exclude
    private Employees employees;

}
