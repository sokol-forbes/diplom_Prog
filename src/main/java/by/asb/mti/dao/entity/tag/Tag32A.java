package by.asb.mti.dao.entity.tag;

import by.asb.mti.dao.entity.Base;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Tag32A extends Base {

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar datetime;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag32A tag32A)) return false;
        if (!super.equals(o)) return false;
        return datetime.equals(tag32A.datetime) && currency.equals(tag32A.currency) && amount.equals(tag32A.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), datetime, currency, amount);
    }
}
