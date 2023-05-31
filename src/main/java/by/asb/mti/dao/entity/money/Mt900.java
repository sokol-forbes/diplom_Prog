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
public class Mt900 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column
    private String tag25;

    @Column
    private String tag25P;

    @Column
    private String tag13D;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt900"))
    private Tag32A tag32A;

    @Column
    private String tag52A;

    @Column
    private String tag52D;

    @Column
    private String tag72;

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt900"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt900 mt900)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt900.sender) && receiver.equals(mt900.receiver) && tag20.equals(mt900.tag20) && tag21.equals(mt900.tag21) && Objects.equals(tag25, mt900.tag25) && Objects.equals(tag25P, mt900.tag25P) && Objects.equals(tag13D, mt900.tag13D) && Objects.equals(tag32A, mt900.tag32A) && Objects.equals(tag52A, mt900.tag52A) && Objects.equals(tag52D, mt900.tag52D) && Objects.equals(tag72, mt900.tag72) && Objects.equals(aCase, mt900.aCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag25, tag25P, tag13D, tag32A, tag52A, tag52D, tag72, aCase);
    }
}
