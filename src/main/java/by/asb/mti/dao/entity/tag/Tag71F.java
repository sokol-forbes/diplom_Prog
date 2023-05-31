package by.asb.mti.dao.entity.tag;

import by.asb.mti.dao.entity.Base;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Tag71F extends Base {

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag71F tag71F)) return false;
        if (!super.equals(o)) return false;
        return currency.equals(tag71F.currency) && amount.equals(tag71F.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, amount);
    }
}
