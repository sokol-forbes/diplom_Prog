package com.diplom.server.dao.repository;

import com.diplom.server.dao.entity.BusinessTrips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessTripsRepository extends JpaRepository<BusinessTrips, Long> {
}
