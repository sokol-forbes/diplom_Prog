package by.asb.mti.dto.info;

import by.asb.mti.dto.BaseDto;
import by.asb.mti.dto.CaseDto;
import by.asb.mti.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MtN99Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("21")
    private String tag21;
    @JsonProperty("79")
    private String tag79;
    @JsonIgnore
    private CaseDto businessCase;
    @JsonIgnore
    private UserDto user;
}
