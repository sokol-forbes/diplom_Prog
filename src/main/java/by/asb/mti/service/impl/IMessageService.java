package by.asb.mti.service.impl;

import by.asb.mti.config.bean.Folder;
import by.asb.mti.dao.repository.message.info.MtN92Repository;
import by.asb.mti.dao.repository.message.info.MtN95Repository;
import by.asb.mti.dao.repository.message.info.MtN96Repository;
import by.asb.mti.dao.repository.message.info.MtN99Repository;
import by.asb.mti.dao.repository.message.money.*;
import by.asb.mti.dto.util.DTOConverter;
import by.asb.mti.service.MessageService;
import by.asb.mti.service.util.parcer.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IMessageService implements MessageService {

    private Mt103Repository mt103Repository;
    private Mt200Repository mt200Repository;
    private Mt202Repository mt202Repository;
    private Mt900Repository mt900Repository;
    private Mt910Repository mt910Repository;
    private Mt202COVRepository mt202COVRepository;

    private MtN92Repository mtN92Repository;
    private MtN95Repository mtN95Repository;
    private MtN96Repository mtN96Repository;
    private MtN99Repository mtN99Repository;

    private Folder folder;
    private DTOConverter dtoConverter;

    @Override
    //@Scheduled(fixedRate = 10000)
    public void parseAndSaveMessages() {
        log.info("Start : " + LocalDateTime.now());

        ParserSwift parserSWIFT = new ParserSwift();
        ParserSpfs ParserSpfs = new ParserSpfs();
        ParserSpfi parserSpfi = new ParserSpfi();
        ParserFinline parserFinline = new ParserFinline();

        ListMessages parser = parserSWIFT.parser(Path.of(folder.getSwift()));
        ListMessages parser1 = ParserSpfs.parser(Path.of(folder.getSpfs()));
        ListMessages parser2 = parserSpfi.parser(Path.of(folder.getSpfi()));
        ListMessages parser3 = parserFinline.parser(Path.of(folder.getFinline()));

        saveMessageLists(parser);
        saveMessageLists(parser1);
        saveMessageLists(parser2);
        saveMessageLists(parser3);

    }

    private void saveMessageLists(ListMessages listMessages) {
        mt103Repository.saveAll(
                dtoConverter.mt103DtoToEntity(listMessages.getMt103DtoList())
        );
        mt200Repository.saveAll(
                dtoConverter.mt200DtoToEntity(listMessages.getMt200DtoList())
        );
        mt202Repository.saveAll(
                dtoConverter.mt202DtoToEntity(listMessages.getMt202DtoList())
        );
        mt202COVRepository.saveAll(
                dtoConverter.mt202COVDtoToEntity(listMessages.getMt202COVDtoList())
        );
        mt900Repository.saveAll(
                dtoConverter.mt900DtoToEntity(listMessages.getMt900DtoList())
        );
        mt910Repository.saveAll(
                dtoConverter.mt910DtoToEntity(listMessages.getMt910DtoList())
        );

        mtN92Repository.saveAll(
                dtoConverter.mtN92DtoToEntity(listMessages.getMtN92DtoList())
        );
        mtN95Repository.saveAll(
                dtoConverter.mtN95DtoToEntity(listMessages.getMtN95DtoList())
        );
        mtN96Repository.saveAll(
                dtoConverter.mtN96DtoToEntity(listMessages.getMtN96DtoList())
        );
        mtN99Repository.saveAll(
                dtoConverter.mtN99DtoToEntity(listMessages.getMtN99DtoList())
        );
    }

}
