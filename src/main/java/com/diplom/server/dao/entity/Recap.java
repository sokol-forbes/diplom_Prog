package com.diplom.server.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Recap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private String education;

    @Column(nullable = false)
    private String experience;

    @OneToOne
    @JoinColumn(name = "vacancy_id", foreignKey = @ForeignKey(name = "FK_vacancy_id_vacancy"))
    @ToString.Exclude
    private Vacancy vacancy;

}
