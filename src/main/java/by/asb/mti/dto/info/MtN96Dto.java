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
public class MtN96Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("21")
    private String tag21;
    @JsonProperty("76")
    private String tag76;
    @JsonProperty("77A")
    private String tag77A;
    @JsonProperty("11a")
    private String tag11a;
    @JsonProperty("79")
    private String tag79;
    @JsonIgnore
    private CaseDto businessCase;
    @JsonIgnore
    private UserDto user;
}
