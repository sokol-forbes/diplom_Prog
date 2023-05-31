package by.asb.mti.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
