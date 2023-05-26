package com.diplom.server.dao.repository;

import com.diplom.server.dao.entity.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepository extends JpaRepository<Departure, Long> {
}
