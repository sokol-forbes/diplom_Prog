package by.asb.mti.service.impl;

import by.asb.mti.dao.entity.money.Mt103;
import by.asb.mti.dao.repository.message.money.Mt103Repository;
import by.asb.mti.dto.money.Mt103Dto;
import by.asb.mti.dto.util.DTOConverter;
import by.asb.mti.service.Mt103Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class IMt103Service implements Mt103Service {

    private Mt103Repository mt103Repository;
    private DTOConverter converter;

    @Override
    public Page<Mt103Dto> find(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Mt103> mt103page = mt103Repository.findAll(pageRequest);
        return mt103page.map(item -> converter.mt103EntityToDto(item));
    }
}
