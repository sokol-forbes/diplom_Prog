package com.diplom.server.dao.repository;

import com.diplom.server.dao.entity.Incentives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncentivesRepository extends JpaRepository<Incentives, Long> {
}
