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
public class Mt202Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("21")
    private String tag21;
    @JsonProperty("13C")
    private String tag13C;
    @JsonProperty("32A")
    private Tag32ADto tag32A;
    @JsonProperty("52A")
    private String tag52A;
    @JsonProperty("52D")
    private String tag52D;
    @JsonProperty("53A")
    private String tag53A;
    @JsonProperty("53B")
    private String tag53B;
    @JsonProperty("53D")
    private String tag53D;
    @JsonProperty("54A")
    private String tag54A;
    @JsonProperty("54B")
    private String tag54B;
    @JsonProperty("54D")
    private String tag54D;
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
    @JsonProperty("58A")
    private String tag58A;
    @JsonProperty("58D")
    private String tag58D;
    @JsonProperty("72")
    private String tag72;
    @JsonIgnore
    private CaseDto aCase;
}
