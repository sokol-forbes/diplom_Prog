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
public class Mt200Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("32A")
    private Tag32ADto tag32A;
    @JsonProperty("53B")
    private String tag53B;
    @JsonProperty("56A")
    private String tag56A;
    @JsonProperty("56D")
    private String tag56D;
    @JsonProperty("57A")
    private String tag57A;
    @JsonProperty("57B")
    private String tag57B;
    @JsonProperty("57D")
    private String tag57D;
    @JsonProperty("72")
    private String tag72;
    @JsonIgnore
    private CaseDto aCase;
}
