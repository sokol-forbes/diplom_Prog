package by.asb.mti.service.impl;

import by.asb.mti.dao.entity.info.MtN92;
import by.asb.mti.dao.entity.info.MtN95;
import by.asb.mti.dao.entity.info.MtN96;
import by.asb.mti.dao.entity.info.MtN99;
import by.asb.mti.dao.entity.money.*;
import by.asb.mti.dao.repository.message.info.MtN92Repository;
import by.asb.mti.dao.repository.message.info.MtN95Repository;
import by.asb.mti.dao.repository.message.info.MtN96Repository;
import by.asb.mti.dao.repository.message.info.MtN99Repository;
import by.asb.mti.dao.repository.message.money.*;
import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.*;
import by.asb.mti.dto.util.DTOConverter;
import by.asb.mti.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ITestService implements TestService {

    private final int defaultSize = 10;

    private Mt103Repository mt103Repository;
    private Mt200Repository mt200Repository;
    private Mt202Repository mt202Repository;
    private Mt202COVRepository mt202COVRepository;
    private Mt900Repository mt900Repository;
    private Mt910Repository mt910Repository;
    private MtN92Repository mtN92Repository;
    private MtN95Repository mtN95Repository;
    private MtN96Repository mtN96Repository;
    private MtN99Repository mtN99Repository;

    private DTOConverter dtoConverter;

    @Override
    public Page<Mt103Dto> getMessagesMt103(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt103> page = mt103Repository.findAll(pageable);
        return page.map(dtoConverter::mt103EntityToDto);
    }

    @Override
    public Page<Mt200Dto> getMessagesMt200(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt200> page = mt200Repository.findAll(pageable);
        return page.map(dtoConverter::mt200EntityToDto);
    }

    @Override
    public Page<Mt202Dto> getMessagesMt202(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt202> page = mt202Repository.findAll(pageable);
        return page.map(dtoConverter::mt202EntityToDto);
    }

    @Override
    public Page<Mt202COVDto> getMessagesMt202COV(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt202COV> page = mt202COVRepository.findAll(pageable);
        return page.map(dtoConverter::mt202COVEntityToDto);
    }

    @Override
    public Page<Mt900Dto> getMessagesMt900(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt900> page = mt900Repository.findAll(pageable);
        return page.map(dtoConverter::mt900EntityToDto);
    }

    @Override
    public Page<Mt910Dto> getMessagesMt910(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<Mt910> page = mt910Repository.findAll(pageable);
        return page.map(dtoConverter::mt910EntityToDto);
    }

    @Override
    public Page<MtN92Dto> getMessagesMtN92(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<MtN92> page = mtN92Repository.findAll(pageable);
        return page.map(dtoConverter::mtN92EntityToDto);
    }

    @Override
    public Page<MtN95Dto> getMessagesMtN95(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<MtN95> page = mtN95Repository.findAll(pageable);
        return page.map(dtoConverter::mtN95EntityToDto);
    }

    @Override
    public Page<MtN96Dto> getMessagesMtN96(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<MtN96> page = mtN96Repository.findAll(pageable);
        return page.map(dtoConverter::mtN96EntityToDto);
    }

    @Override
    public Page<MtN99Dto> getMessagesMtN99(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, defaultSize);
        Page<MtN99> page = mtN99Repository.findAll(pageable);
        return page.map(dtoConverter::mtN99EntityToDto);
    }
}
