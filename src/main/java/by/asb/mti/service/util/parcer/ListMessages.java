package by.asb.mti.service.util.parcer;

import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.*;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ListMessages {

    private final List<Mt103Dto> mt103DtoList = new ArrayList<>();
    private final List<Mt200Dto> mt200DtoList = new ArrayList<>();
    private final List<Mt202Dto> mt202DtoList = new ArrayList<>();
    private final List<Mt202COVDto> mt202COVDtoList = new ArrayList<>();
    private final List<Mt900Dto> mt900DtoList = new ArrayList<>();
    private final List<Mt910Dto> mt910DtoList = new ArrayList<>();

    private final List<MtN92Dto> mtN92DtoList = new ArrayList<>();
    private final List<MtN95Dto> mtN95DtoList = new ArrayList<>();
    private final List<MtN96Dto> mtN96DtoList = new ArrayList<>();
    private final List<MtN99Dto> mtN99DtoList = new ArrayList<>();

    public void addMt103DtoToList(Mt103Dto dto) {
        mt103DtoList.add(dto);
    }

    public void addMt200DtoToList(Mt200Dto dto) {
        mt200DtoList.add(dto);
    }

    public void addMt202DtoToList(Mt202Dto dto) {
        mt202DtoList.add(dto);
    }

    public void addMt202COVDtoToList(Mt202COVDto dto) {
        mt202COVDtoList.add(dto);
    }

    public void addMt900DtoToList(Mt900Dto dto) {
        mt900DtoList.add(dto);
    }

    public void addMt910DtoToList(Mt910Dto dto) {
        mt910DtoList.add(dto);
    }

    public void addMtN92DtoToList(MtN92Dto dto) {
        mtN92DtoList.add(dto);
    }

    public void addMtN95DtoToList(MtN95Dto dto) {
        mtN95DtoList.add(dto);
    }

    public void addMtN96DtoToList(MtN96Dto dto) {
        mtN96DtoList.add(dto);
    }

    public void addMtN99DtoToList(MtN99Dto dto) {
        mtN99DtoList.add(dto);
    }

}
