package by.asb.mti.dto.money;

import by.asb.mti.dto.BaseDto;
import by.asb.mti.dto.CaseDto;
import by.asb.mti.dto.tag.Tag32ADto;
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
public class Mt900Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("21")
    private String tag21;
    @JsonProperty("25")
    private String tag25;
    @JsonProperty("25P")
    private String tag25P;
    @JsonProperty("13D")
    private String tag13D;
    @JsonProperty("32A")
    private Tag32ADto tag32A;
    @JsonProperty("52A")
    private String tag52A;
    @JsonProperty("52D")
    private String tag52D;
    @JsonProperty("72")
    private String tag72;
    @JsonIgnore
    private CaseDto aCase;
}
