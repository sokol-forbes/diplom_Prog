package by.asb.mti.dao.entity.money;

import by.asb.mti.dao.entity.Base;
import by.asb.mti.dao.entity.Case;
import by.asb.mti.dao.entity.tag.Tag32A;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Mt200 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt200"))
    private Tag32A tag32A;

    @Column
    private String tag53B;

    @Column
    private String tag56A;

    @Column
    private String tag56D;

    @Column
    private String tag57A;

    @Column
    private String tag57B;

    @Column
    private String tag57D;

    @Column
    private String tag72;

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt200"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt200 mt200)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt200.sender) && receiver.equals(mt200.receiver) && tag20.equals(mt200.tag20) && Objects.equals(tag32A, mt200.tag32A) && Objects.equals(tag53B, mt200.tag53B) && Objects.equals(tag56A, mt200.tag56A) && Objects.equals(tag56D, mt200.tag56D) && Objects.equals(tag57A, mt200.tag57A) && Objects.equals(tag57B, mt200.tag57B) && Objects.equals(tag57D, mt200.tag57D) && Objects.equals(tag72, mt200.tag72) && Objects.equals(aCase, mt200.aCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag32A, tag53B, tag56A, tag56D, tag57A, tag57B, tag57D, tag72, aCase);
    }
}
