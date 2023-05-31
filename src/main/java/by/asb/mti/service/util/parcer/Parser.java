package by.asb.mti.service.util.parcer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Parser {

    static String tagSender = "Sender";
    static String tagReceiver = "Receiver";

    List<File> readFiles(Path path) {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<File> result = null;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    List<File> readAllFilesByFilter(Path path, String beginningFile) {
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        List<File> result = null;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().startsWith(beginningFile))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    <T> Optional<T> creatMtDto(String dataMessage, String senderReceiver, Class<T> typeClass) {
        StringBuilder sb32A = new StringBuilder();
        StringBuilder sb33B = new StringBuilder();
        StringBuilder sb71F = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        sbResult.append(senderReceiver);
        Pattern pattern = Pattern.compile("(\\d{2}\\w?):([\\s\\S]+?):");
        Matcher matcher = pattern.matcher(dataMessage);
        while (matcher.find()) {
            String tagName = matcher.group(1);
            String tagData = matcher.group(2).replaceAll("\r", "");
            tagData = StringUtils.chop(tagData);
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

    void addListTag(String tagDate, StringBuilder stringBuilderTag) {
        String pattern = "(\\d{6})(\\w{3})([\\s\\S]+)";
        Matcher checkMatcherSender = Pattern.compile(pattern).matcher(tagDate);
        while (checkMatcherSender.find()) {
            stringBuilderTag.append("{");
            String date = checkMatcherSender.group(1);
            if (date != null) {
                if (date.length() == 6) {
                    date = format6Number(date);
                }
                stringBuilderTag.append("\"Date\":\"")
                        .append(date)
                        .append("\",");
            }
            stringBuilderTag.append("\"Currency\":\"")
                    .append(checkMatcherSender.group(2).trim())
                    .append("\",")
                    .append("\"Amount\":\"")
                    .append(checkMatcherSender.group(3).replaceAll("\\.", "").replaceAll(",", "."))
                    .append("\"},");
        }
    }

    private String format6Number(String strData) {
        return strData.substring(4, 6)
                .concat(" ")
                .concat(Month.of(Integer.parseInt(strData.substring(2, 4))).toString())
                .concat(" ")
                .concat(strData.substring(0, 2));
    }

    int numberMessageSPFX(String textMessage) {
        int numberMessage;
        String number = textMessage.substring(textMessage.lastIndexOf("{2:") + 4, textMessage.lastIndexOf("{2:") + 7);
        numberMessage = Integer.parseInt(number);
        return numberMessage;
    }

}
