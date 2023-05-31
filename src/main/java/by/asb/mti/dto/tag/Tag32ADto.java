package by.asb.mti.dto.tag;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tag32ADto {
    @JsonProperty("Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMMM yyyy", locale = "en")
    private Date date;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Amount")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;
}
