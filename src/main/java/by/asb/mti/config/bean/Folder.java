package by.asb.mti.config.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Folder {
    private String archive;
    private String spfi;
    private String spfs;
    private String swift;
    private String finline;
}
