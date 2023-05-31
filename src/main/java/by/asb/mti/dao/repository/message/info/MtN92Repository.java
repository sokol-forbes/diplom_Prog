package by.asb.mti.dao.repository.message.info;

import by.asb.mti.dao.entity.info.MtN92;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtN92Repository extends JpaRepository<MtN92, Long> {
}
