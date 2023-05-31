package by.asb.mti.dto.tag;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tag33BDto {
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Amount")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;
}
