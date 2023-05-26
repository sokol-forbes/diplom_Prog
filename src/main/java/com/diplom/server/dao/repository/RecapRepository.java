package com.diplom.server.dao.repository;

import com.diplom.server.dao.entity.Recap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecapRepository extends JpaRepository<Recap, Long> {
}
