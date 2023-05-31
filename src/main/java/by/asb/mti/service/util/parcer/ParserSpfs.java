package by.asb.mti.service.util.parcer;

import by.asb.mti.dto.info.MtN92Dto;
import by.asb.mti.dto.info.MtN95Dto;
import by.asb.mti.dto.info.MtN96Dto;
import by.asb.mti.dto.info.MtN99Dto;
import by.asb.mti.dto.money.Mt103Dto;
import by.asb.mti.dto.money.Mt200Dto;
import by.asb.mti.dto.money.Mt202Dto;
import by.asb.mti.service.util.IParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserSpfs extends Parser implements IParser {

    private final ListMessages listMessages = new ListMessages();

    private List<File> listFiles(Path path) {
        List<File> generalListFile;
        generalListFile = readAllFilesByFilter(path, "ED503");
        generalListFile.addAll(readAllFilesByFilter(path, "ED508"));
        return generalListFile;
    }

    @Override
    public ListMessages parser(Path path) {
        for (File file : listFiles(path)) {
            String textFile = "";
            try {
                textFile = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String senderReceiver = "";
            String numberMessage = "";
            String startMessage = textFile.substring(0, textFile.lastIndexOf("}{4:"));
            String bodyMessage = textFile.substring(textFile.lastIndexOf("}{4:\r\n") + 7, textFile.length() - 4).concat(":");
            Pattern patternSenRes = Pattern.compile("[\\s\\S]*\\{1:F01([\\s\\S]{12})[\\s\\S]*\\{2:[\\s\\S](\\d{3})([\\s\\S]{11})");
            Matcher matcherSenRes = patternSenRes.matcher(startMessage);
            while (matcherSenRes.find()) {
                String receiver = matcherSenRes.group(1);
                if (receiver.charAt(8) == 'A') {
                    receiver = receiver.substring(0, 8).concat(receiver.substring(9, 12));
                } else {
                    receiver = receiver.substring(0, 11);
                }
                String sender = matcherSenRes.group(3);
                numberMessage = matcherSenRes.group(2);
                senderReceiver = String.format("\"%s\":\"%s\",\"%s\":\"%s\",", tagSender, sender, tagReceiver, receiver);
            }
            choiceMtDto(numberMessage, bodyMessage, senderReceiver);
        }
        return listMessages;
    }

    void choiceMtDto(String numberMessage, String message, String senderReceiver) {
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
            case "192", "292", "992" -> {
                Optional<MtN92Dto> mtN92Dto = creatMtDto(message, senderReceiver, MtN92Dto.class);
                mtN92Dto.ifPresent(listMessages::addMtN92DtoToList);
            }
            case "195", "295", "995" -> {
                Optional<MtN95Dto> mtN95Dto = creatMtDto(message, senderReceiver, MtN95Dto.class);
                mtN95Dto.ifPresent(listMessages::addMtN95DtoToList);
            }
            case "196", "296", "996" -> {
                Optional<MtN96Dto> mtN96Dto = creatMtDto(message, senderReceiver, MtN96Dto.class);
                mtN96Dto.ifPresent(listMessages::addMtN96DtoToList);
            }
            case "199", "299", "999" -> {
                Optional<MtN99Dto> mtN99Dto = creatMtDto(message, senderReceiver, MtN99Dto.class);
                mtN99Dto.ifPresent(listMessages::addMtN99DtoToList);
            }
        }
    }

}
