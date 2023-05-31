package by.asb.mti.service;

import by.asb.mti.dto.money.Mt103Dto;
import org.springframework.data.domain.Page;

public interface Mt103Service {
    Page<Mt103Dto> find(Integer page, Integer size);
}
