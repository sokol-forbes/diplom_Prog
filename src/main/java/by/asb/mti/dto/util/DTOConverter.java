package by.asb.mti.dto.util;

import by.asb.mti.dao.entity.User;
import by.asb.mti.dao.entity.info.MtN92;
import by.asb.mti.dao.entity.info.MtN95;
import by.asb.mti.dao.entity.info.MtN96;
import by.asb.mti.dao.entity.info.MtN99;
import by.asb.mti.dao.entity.money.*;
import by.asb.mti.dto.UserDto;
import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class DTOConverter {

    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public User userDtoToEntity(UserDto userDto) {
        log.info("UserDto -> {}", userDto.toString());
        Converter<String, String> encodeConverter =
                src -> src.getSource() == null ? null : passwordEncoder.encode(src.getSource());
        User user = modelMapper
                .typeMap(UserDto.class, User.class)
                .addMappings(mapper -> mapper.using(encodeConverter).map(UserDto::getPassword, User::setPassword))
                .map(userDto);
        log.info("User -> {}", user);
        return user;
    }

    public UserDto userEntityToDto(User entity) {
        log.info("User -> {}", entity.toString());
        UserDto user = modelMapper
                .typeMap(User.class, UserDto.class)
                .addMappings(mapper -> mapper.skip(UserDto::setPassword))
                .map(entity);
        log.info("UserDto -> {}", user);
        return user;
    }

    public List<UserDto> userEntityToDto(List<User> entity) {
        List<UserDto> userDtoList = new ArrayList<>();
        entity.forEach(item -> userDtoList.add(userEntityToDto(item)));
        return userDtoList;
    }

    //Convert Dto to Entity
    public List<Mt103> mt103DtoToEntity(List<Mt103Dto> listDto) {
        List<Mt103> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt103DtoToEntity(item)));
        return listEntity;
    }

    public Mt103 mt103DtoToEntity(Mt103Dto dto) {
        log.info("Mt103Dto -> {}", dto.toString());
        Mt103 entity = modelMapper
                .typeMap(Mt103Dto.class, Mt103.class)
                .map(dto);
        log.info("Mt103Entity -> {}", entity);
        return entity;
    }

    public List<Mt200> mt200DtoToEntity(List<Mt200Dto> listDto) {
        List<Mt200> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt200DtoToEntity(item)));
        return listEntity;
    }

    public Mt200 mt200DtoToEntity(Mt200Dto dto) {
        log.info("Mt200Dto -> {}", dto.toString());
        Mt200 entity = modelMapper
                .typeMap(Mt200Dto.class, Mt200.class)
                .map(dto);
        log.info("Mt200Entity -> {}", entity);
        return entity;
    }

    public List<Mt202> mt202DtoToEntity(List<Mt202Dto> listDto) {
        List<Mt202> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt202DtoToEntity(item)));
        return listEntity;
    }

    public Mt202 mt202DtoToEntity(Mt202Dto dto) {
        log.info("Mt202Dto -> {}", dto.toString());
        Mt202 entity = modelMapper
                .typeMap(Mt202Dto.class, Mt202.class)
                .map(dto);
        log.info("Mt202Entity -> {}", entity);
        return entity;
    }

    public List<Mt202COV> mt202COVDtoToEntity(List<Mt202COVDto> listDto) {
        List<Mt202COV> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt202COVDtoToEntity(item)));
        return listEntity;
    }

    public Mt202COV mt202COVDtoToEntity(Mt202COVDto dto) {
        log.info("Mt200Dto -> {}", dto.toString());
        Mt202COV entity = modelMapper
                .typeMap(Mt202COVDto.class, Mt202COV.class)
                .map(dto);
        log.info("Mt202Entity -> {}", entity);
        return entity;
    }

    public List<Mt900> mt900DtoToEntity(List<Mt900Dto> listDto) {
        List<Mt900> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt900DtoToEntity(item)));
        return listEntity;
    }

    public Mt900 mt900DtoToEntity(Mt900Dto dto) {
        log.info("Mt200Dto -> {}", dto.toString());
        Mt900 entity = modelMapper
                .typeMap(Mt900Dto.class, Mt900.class)
                .map(dto);
        log.info("Mt202Entity -> {}", entity);
        return entity;
    }

    public List<Mt910> mt910DtoToEntity(List<Mt910Dto> listDto) {
        List<Mt910> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mt910DtoToEntity(item)));
        return listEntity;
    }

    public Mt910 mt910DtoToEntity(Mt910Dto dto) {
        log.info("Mt200Dto -> {}", dto.toString());
        Mt910 entity = modelMapper
                .typeMap(Mt910Dto.class, Mt910.class)
                .map(dto);
        log.info("Mt202Entity -> {}", entity);
        return entity;
    }

    public List<MtN92> mtN92DtoToEntity(List<MtN92Dto> listDto) {
        List<MtN92> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mtN92DtoToEntity(item)));
        return listEntity;
    }

    public MtN92 mtN92DtoToEntity(MtN92Dto dto) {
        log.info("MtN92Dto -> {}", dto.toString());
        MtN92 entity = modelMapper
                .typeMap(MtN92Dto.class, MtN92.class)
                .map(dto);
        log.info("MtN92Entity -> {}", entity);
        return entity;
    }

    public List<MtN95> mtN95DtoToEntity(List<MtN95Dto> listDto) {
        List<MtN95> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mtN95DtoToEntity(item)));
        return listEntity;
    }

    public MtN95 mtN95DtoToEntity(MtN95Dto dto) {
        log.info("MtN92Dto -> {}", dto.toString());
        MtN95 entity = modelMapper
                .typeMap(MtN95Dto.class, MtN95.class)
                .map(dto);
        log.info("MtN92Entity -> {}", entity);
        return entity;
    }

    public List<MtN96> mtN96DtoToEntity(List<MtN96Dto> listDto) {
        List<MtN96> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mtN96DtoToEntity(item)));
        return listEntity;
    }

    public MtN96 mtN96DtoToEntity(MtN96Dto dto) {
        log.info("MtN96Dto -> {}", dto.toString());
        MtN96 entity = modelMapper
                .typeMap(MtN96Dto.class, MtN96.class)
                .map(dto);
        log.info("MtN96Entity -> {}", entity);
        return entity;
    }

    public List<MtN99> mtN99DtoToEntity(List<MtN99Dto> listDto) {
        List<MtN99> listEntity = new ArrayList<>();
        listDto.forEach(item -> listEntity.add(mtN99DtoToEntity(item)));
        return listEntity;
    }

    public MtN99 mtN99DtoToEntity(MtN99Dto dto) {
        log.info("MtN99Dto -> {}", dto.toString());
        MtN99 entity = modelMapper
                .typeMap(MtN99Dto.class, MtN99.class)
                .map(dto);
        log.info("MtN99Entity -> {}", entity);
        return entity;
    }

    //Convert Entity to Dto
    public List<Mt103Dto> mt103EntityToDto(List<Mt103> listEntity) {
        List<Mt103Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt103EntityToDto(item)));
        return listDto;
    }

    public Mt103Dto mt103EntityToDto(Mt103 entity) {
        log.info("Mt103Entity -> {}", entity.toString());
        Mt103Dto dto = modelMapper
                .typeMap(Mt103.class, Mt103Dto.class)
                .map(entity);
        log.info("Mt103Dto -> {}", dto);
        return dto;
    }

    public List<Mt200Dto> mt200EntityToDto(List<Mt200> listEntity) {
        List<Mt200Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt200EntityToDto(item)));
        return listDto;
    }

    public Mt200Dto mt200EntityToDto(Mt200 entity) {
        log.info("Mt200Entity -> {}", entity.toString());
        Mt200Dto dto = modelMapper
                .typeMap(Mt200.class, Mt200Dto.class)
                .map(entity);
        log.info("Mt200Dto -> {}", dto);
        return dto;
    }

    public List<Mt202Dto> mt202EntityToDto(List<Mt202> listEntity) {
        List<Mt202Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt202EntityToDto(item)));
        return listDto;
    }

    public Mt202Dto mt202EntityToDto(Mt202 entity) {
        log.info("Mt202Entity -> {}", entity.toString());
        Mt202Dto dto = modelMapper
                .typeMap(Mt202.class, Mt202Dto.class)
                .map(entity);
        log.info("Mt202Dto -> {}", dto);
        return dto;
    }

    public List<Mt202COVDto> mt202COVEntityToDto(List<Mt202COV> listEntity) {
        List<Mt202COVDto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt202COVEntityToDto(item)));
        return listDto;
    }

    public Mt202COVDto mt202COVEntityToDto(Mt202COV entity) {
        log.info("Mt202COVEntity -> {}", entity.toString());
        Mt202COVDto dto = modelMapper
                .typeMap(Mt202COV.class, Mt202COVDto.class)
                .map(entity);
        log.info("Mt202COVDto -> {}", dto);
        return dto;
    }

    public List<Mt900Dto> mt900EntityToDto(List<Mt900> listEntity) {
        List<Mt900Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt900EntityToDto(item)));
        return listDto;
    }

    public Mt900Dto mt900EntityToDto(Mt900 entity) {
        log.info("Mt900Entity -> {}", entity.toString());
        Mt900Dto dto = modelMapper
                .typeMap(Mt900.class, Mt900Dto.class)
                .map(entity);
        log.info("Mt900Dto -> {}", dto);
        return dto;
    }

    public List<Mt910Dto> mt910EntityToDto(List<Mt910> listEntity) {
        List<Mt910Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mt910EntityToDto(item)));
        return listDto;
    }

    public Mt910Dto mt910EntityToDto(Mt910 entity) {
        log.info("Mt910Entity -> {}", entity.toString());
        Mt910Dto dto = modelMapper
                .typeMap(Mt910.class, Mt910Dto.class)
                .map(entity);
        log.info("Mt910Dto -> {}", dto);
        return dto;
    }


    public List<MtN92Dto> mtN92EntityToDto(List<MtN92> listEntity) {
        List<MtN92Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mtN92EntityToDto(item)));
        return listDto;
    }

    public MtN92Dto mtN92EntityToDto(MtN92 entity) {
        log.info("MtN92Entity -> {}", entity.toString());
        MtN92Dto dto = modelMapper
                .typeMap(MtN92.class, MtN92Dto.class)
                .map(entity);
        log.info("MtN92Dto -> {}", dto);
        return dto;
    }

    public List<MtN95Dto> mtN95EntityToDto(List<MtN95> listEntity) {
        List<MtN95Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mtN95EntityToDto(item)));
        return listDto;
    }

    public MtN95Dto mtN95EntityToDto(MtN95 entity) {
        log.info("MtN95Entity -> {}", entity.toString());
        MtN95Dto dto = modelMapper
                .typeMap(MtN95.class, MtN95Dto.class)
                .map(entity);
        log.info("MtN95Dto -> {}", dto);
        return dto;
    }

    public List<MtN96Dto> mtN96EntityToDto(List<MtN96> listEntity) {
        List<MtN96Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mtN96EntityToDto(item)));
        return listDto;
    }

    public MtN96Dto mtN96EntityToDto(MtN96 entity) {
        log.info("MtN96Entity -> {}", entity.toString());
        MtN96Dto dto = modelMapper
                .typeMap(MtN96.class, MtN96Dto.class)
                .map(entity);
        log.info("MtN96Dto -> {}", dto);
        return dto;
    }

    public List<MtN99Dto> mtN99EntityToDto(List<MtN99> listEntity) {
        List<MtN99Dto> listDto = new ArrayList<>();
        listEntity.forEach(item -> listDto.add(mtN99EntityToDto(item)));
        return listDto;
    }

    public MtN99Dto mtN99EntityToDto(MtN99 entity) {
        log.info("MtN99Entity -> {}", entity.toString());
        MtN99Dto dto = modelMapper
                .typeMap(MtN99.class, MtN99Dto.class)
                .map(entity);
        log.info("MtN99Dto -> {}", dto);
        return dto;
    }
}

