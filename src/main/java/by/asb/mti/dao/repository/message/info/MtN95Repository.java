package by.asb.mti.dao.repository.message.info;

import by.asb.mti.dao.entity.info.MtN95;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtN95Repository extends JpaRepository<MtN95, Long> {
}
