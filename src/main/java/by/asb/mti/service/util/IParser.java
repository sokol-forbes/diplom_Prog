package by.asb.mti.service.util;

import by.asb.mti.service.util.parcer.ListMessages;

import java.nio.file.Path;

public interface IParser {

    ListMessages parser(Path path);

}
