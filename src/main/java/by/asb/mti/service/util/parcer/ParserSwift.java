package by.asb.mti.service.util.parcer;

import by.asb.mti.dto.money.*;
import by.asb.mti.service.util.IParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ParserSwift extends Parser implements IParser {

    private static final String MESSAGE_HEADER = "--------------------------- Message Header ------------------------";
    private static final String MESSAGE_TRAILER = "--------------------------- Message Trailer ------------------------";
    private static final String MESSAGE_TEXT = "--------------------------- Message Text ---------------------------";
    private static final String tagSender = "Sender";
    private static final String tagReceiver = "Receiver";

    private final ListMessages listMessages = new ListMessages();

    @Override
    public ListMessages parser(Path path) {

        for (File file : readFiles(path)) {
            String textFile = "";
            try {
                textFile = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String senderReceiver = "";
            String numberMessage = "";
            String bodyMessage = "";
            Matcher checkMatcher = Pattern.compile(MESSAGE_HEADER + "[\\s\\S]*?" + ": FIN (\\d{3}?)([\\s\\S]{4}?)[\\s\\S]*?" +
                    tagSender + " *?: ([\\s\\S]*?)\n[\\s\\S]*?\n?" +
                    tagReceiver + " *?: ([\\s\\S]*?)\n[\\s\\S]*?" +
                    MESSAGE_TEXT + "([\\s\\S]*?)" + MESSAGE_TRAILER).matcher(textFile);
            while (checkMatcher.find()) {
                String numberFin = checkMatcher.group(1);
                String strCOV = checkMatcher.group(2);
                String lineSender = checkMatcher.group(3);
                String lineReceiver = checkMatcher.group(4);
                bodyMessage = checkMatcher.group(5);
                numberMessage = Objects.equals(strCOV, ".COV") ? numberFin.concat(strCOV) : numberFin;
                senderReceiver = String.format("\"%s\":\"%s\",\"%s\":\"%s\",", tagSender, lineSender, tagReceiver, lineReceiver);
            }
            choiceMtDto(numberMessage, bodyMessage, senderReceiver);
        }
        return listMessages;
    }

    private void choiceMtDto(String numberMessage, String message, String senderReceiver) {

        switch (numberMessage) {
            case "103" -> {
                Optional<Mt103Dto> mt103Dto = creatMtDto(message, senderReceiver, Mt103Dto.class);
                mt103Dto.ifPresent(listMessages::addMt103DtoToList);
            }
            case "200" -> {
                Optional<Mt200Dto> mt200Dto = creatMtDto(message, senderReceiver, Mt200Dto.class);
                mt200Dto.ifPresent(listMessages::addMt200DtoToList);
            }
            case "202" -> {
                Optional<Mt202Dto> mt202Dto = creatMtDto(message, senderReceiver, Mt202Dto.class);
                mt202Dto.ifPresent(listMessages::addMt202DtoToList);
            }
            case "202.COV" -> {
                Optional<Mt202COVDto> mt202COVDto = creatMtDto(message, senderReceiver, Mt202COVDto.class);
                mt202COVDto.ifPresent(listMessages::addMt202COVDtoToList);
            }
            case "900" -> {
                Optional<Mt900Dto> mt900Dto = creatMtDto(message, senderReceiver, Mt900Dto.class);
                mt900Dto.ifPresent(listMessages::addMt900DtoToList);
            }
            case "910" -> {
                Optional<Mt910Dto> mt910Dto = creatMtDto(message, senderReceiver, Mt910Dto.class);
                mt910Dto.ifPresent(listMessages::addMt910DtoToList);
            }
        }
    }

    <T> Optional<T> creatMtDto(String dataMessage, String senderReceiver, Class<T> typeClass) {
        String dataMessageLocal = "";
        int indexStart = 0;
        int indexEnd;

        dataMessage = dataMessage.trim().replaceAll(" {2,}", "");
        String patternLine = "(\\d{2}?[\\w]??:)";
        Matcher checkMatcherSenderLine = Pattern.compile(patternLine).matcher(dataMessage);
        while (checkMatcherSenderLine.find()) {
            indexEnd = checkMatcherSenderLine.start();
            dataMessageLocal = dataMessageLocal.concat(dataMessage.substring(indexStart, indexEnd));
            String tag = checkMatcherSenderLine.group(1);
            dataMessageLocal = dataMessageLocal.concat(tag).concat(tag);
            indexStart = checkMatcherSenderLine.end();
        }
        dataMessageLocal = dataMessageLocal.concat(dataMessage.substring(indexStart)).concat("\n00A:");

        StringBuilder sb32A = new StringBuilder();
        StringBuilder sb33B = new StringBuilder();
        StringBuilder sb71F = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        sbResult.append(senderReceiver);
        String pattern = "((\\d{2}?[\\w]??):[\\s\\S]*?\\n([\\s\\S]*?)\\n??)\\d{2}?[\\w]??:";
        Matcher checkMatcherSender = Pattern.compile(pattern).matcher(dataMessageLocal);
        while (checkMatcherSender.find()) {
            String tagName = checkMatcherSender.group(2);
            String tagData = checkMatcherSender.group(3);
            switch (tagName) {
                case "32A" -> {
                    addListTag(tagData, sb32A);
                    sbResult.append("\"32A\":").append(sb32A.deleteCharAt(sb32A.length() - 1)).append(",");
                }
                case "33B" -> {
                    addListTag(tagData, sb33B);
                    sbResult.append("\"33B\":").append(sb33B.deleteCharAt(sb33B.length() - 1)).append(",");
                }
                case "71F" -> addListTag(tagData, sb71F);
                default -> sbResult.append("\"").append(tagName).append("\":\"").append(tagData).append("\",");
            }
        }
        if (!sb71F.isEmpty()) {
            sbResult.append("\"71F\":[")
                    .append(sb71F.deleteCharAt(sb71F.length() - 1))
                    .append("],");
        }
        String strMtDto = String.format("{%s}", sbResult.deleteCharAt(sbResult.length() - 1));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        T dto = null;
        try {
            dto = mapper.readValue(strMtDto, typeClass);
        } catch (JsonProcessingException e) {
            log.info("e.getMessage()");
        }
        return Optional.ofNullable(dto);
    }

    void addListTag(String tagData, StringBuilder stringBuilderTag) {
        String pattern = "(Date\\s*?: ([\\s\\S]*?)\n)?Currency\\s*?:\\s*?([\\s\\S]*?)[(][\\s\\S]*?[)]\nAmount\\s*?:\\s*?[#]([\\s\\S]*?)[#]";
        Matcher checkMatcherSender = Pattern.compile(pattern).matcher(tagData);
        while (checkMatcherSender.find()) {
            stringBuilderTag.append("{");
            String date = checkMatcherSender.group(2);
            if (date != null) {
                stringBuilderTag.append("\"Date\":\"")
                        .append(date)
                        .append("\",");
            }
            stringBuilderTag.append("\"Currency\":\"")
                    .append(checkMatcherSender.group(3).trim())
                    .append("\",")
                    .append("\"Amount\":\"")
                    .append(checkMatcherSender.group(4).replaceAll("\\.", "").replaceAll(",", "."))
                    .append("\"},");
        }
    }

}
