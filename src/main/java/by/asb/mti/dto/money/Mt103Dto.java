package by.asb.mti.dto.money;

import by.asb.mti.dto.BaseDto;
import by.asb.mti.dto.CaseDto;
import by.asb.mti.dto.tag.Tag32ADto;
import by.asb.mti.dto.tag.Tag33BDto;
import by.asb.mti.dto.tag.Tag71FDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mt103Dto extends BaseDto {
    @JsonProperty("Sender")
    private String sender;
    @JsonProperty("Receiver")
    private String receiver;
    @JsonProperty("20")
    private String tag20;
    @JsonProperty("13C")
    private String tag13C;
    @JsonProperty("23B")
    private String tag23B;
    @JsonProperty("23E")
    private String tag23E;
    @JsonProperty("26T")
    private String tag26T;
    @JsonProperty("32A")
    private Tag32ADto tag32A;
    @JsonProperty("33B")
    private Tag33BDto tag33B;
    @JsonProperty("36")
    private String tag36;
    @JsonProperty("50A")
    private String tag50A;
    @JsonProperty("50F")
    private String tag50F;
    @JsonProperty("50K")
    private String tag50K;
    @JsonProperty("51A")
    private String tag51A;
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
    @JsonProperty("55A")
    private String tag55A;
    @JsonProperty("55B")
    private String tag55B;
    @JsonProperty("55D")
    private String tag55D;
    @JsonProperty("56A")
    private String tag56A;
    @JsonProperty("56C")
    private String tag56C;
    @JsonProperty("56D")
    private String tag56D;
    @JsonProperty("57A")
    private String tag57A;
    @JsonProperty("57B")
    private String tag57B;
    @JsonProperty("57C")
    private String tag57C;
    @JsonProperty("57D")
    private String tag57D;
    @JsonProperty("59")
    private String tag59;
    @JsonProperty("59A")
    private String tag59A;
    @JsonProperty("59F")
    private String tag59F;
    @JsonProperty("70")
    private String tag70;
    @JsonProperty("71A")
    private String tag71A;
    @JsonProperty("71G")
    private String tag71G;
    @JsonProperty("72")
    private String tag72;
    @JsonProperty("77B")
    private String tag77B;
    @JsonProperty("71F")
    private List<Tag71FDto> tag71F;
    @JsonIgnore
    private CaseDto aCase;
}
