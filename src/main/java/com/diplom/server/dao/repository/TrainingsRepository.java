package com.diplom.server.dao.repository;

import com.diplom.server.dao.entity.Trainings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsRepository extends JpaRepository<Trainings, Long> {
}
