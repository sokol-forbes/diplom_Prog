package by.asb.mti.dao.repository;

import by.asb.mti.dao.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
