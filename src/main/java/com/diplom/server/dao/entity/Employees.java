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
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "vacancy_id", foreignKey = @ForeignKey(name = "FK_vacancy_id_vacancy"))
    @ToString.Exclude
    private Vacancy vacancy;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar begin_date;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar last_promotion_date;

    @OneToOne
    @JoinColumn(name = "departyre_id", foreignKey = @ForeignKey(name = "FK_departure_id_departure"))
    @ToString.Exclude
    private Departure departure;


}
