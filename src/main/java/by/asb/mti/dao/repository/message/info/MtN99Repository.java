package by.asb.mti.dao.repository.message.info;

import by.asb.mti.dao.entity.info.MtN99;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtN99Repository extends JpaRepository<MtN99, Long> {
}
