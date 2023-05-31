package by.asb.mti.service;

import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.*;
import org.springframework.data.domain.Page;

public interface TestService {

    Page<Mt103Dto> getMessagesMt103(Integer pageNumber);

    Page<Mt200Dto> getMessagesMt200(Integer pageNumber);

    Page<Mt202Dto> getMessagesMt202(Integer pageNumber);

    Page<Mt202COVDto> getMessagesMt202COV(Integer pageNumber);

    Page<Mt900Dto> getMessagesMt900(Integer pageNumber);

    Page<Mt910Dto> getMessagesMt910(Integer pageNumber);

    Page<MtN92Dto> getMessagesMtN92(Integer pageNumber);

    Page<MtN95Dto> getMessagesMtN95(Integer pageNumber);

    Page<MtN96Dto> getMessagesMtN96(Integer pageNumber);

    Page<MtN99Dto> getMessagesMtN99(Integer pageNumber);


}
