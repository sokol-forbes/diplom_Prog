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
public class Mt910 extends Base {
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
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt910"))
    private Tag32A tag32A;

    @Column
    private String tag50A;

    @Column
    private String tag50F;

    @Column
    private String tag50K;

    @Column
    private String tag52A;

    @Column
    private String tag52D;

    @Column
    private String tag56A;

    @Column
    private String tag56D;

    @Column
    private String tag72;

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt910"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt910 mt910)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt910.sender) && receiver.equals(mt910.receiver) && tag20.equals(mt910.tag20) && tag21.equals(mt910.tag21) && Objects.equals(tag25, mt910.tag25) && Objects.equals(tag25P, mt910.tag25P) && Objects.equals(tag13D, mt910.tag13D) && Objects.equals(tag32A, mt910.tag32A) && Objects.equals(tag50A, mt910.tag50A) && Objects.equals(tag50F, mt910.tag50F) && Objects.equals(tag50K, mt910.tag50K) && Objects.equals(tag52A, mt910.tag52A) && Objects.equals(tag52D, mt910.tag52D) && Objects.equals(tag56A, mt910.tag56A) && Objects.equals(tag56D, mt910.tag56D) && Objects.equals(tag72, mt910.tag72) && Objects.equals(aCase, mt910.aCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag25, tag25P, tag13D, tag32A, tag50A, tag50F, tag50K, tag52A, tag52D, tag56A, tag56D, tag72, aCase);
    }
}
