package by.asb.mti.dao.entity.money;

import by.asb.mti.dao.entity.Base;
import by.asb.mti.dao.entity.Case;
import by.asb.mti.dao.entity.tag.Tag32A;
import by.asb.mti.dao.entity.tag.Tag33B;
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
public class Mt202COV extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column
    private String tag13C;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt202cov"))
    private Tag32A tag32A;

    @Column
    private String tag52A;

    @Column
    private String tag52D;

    @Column
    private String tag53A;

    @Column
    private String tag53B;

    @Column
    private String tag53D;

    @Column
    private String tag54A;

    @Column
    private String tag54B;

    @Column
    private String tag54D;

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
    private String tag58A;

    @Column
    private String tag58D;

    @Column
    private String tag72;

    @Column
    private String tag50A;

    @Column
    private String tag50F;

    @Column
    private String tag50K;

    @Column
    private String tag52A_2;

    @Column
    private String tag52D_2;

    @Column
    private String tag56A_2;

    @Column
    private String tag56C;

    @Column
    private String tag56D_2;

    @Column
    private String tag57A_2;

    @Column
    private String tag57B_2;

    @Column
    private String tag57C;

    @Column
    private String tag57D_2;

    @Column
    private String tag59;

    @Column
    private String tag59A;

    @Column
    private String tag59F;

    @Column
    private String tag70;

    @Column
    private String tag72_2;

    @OneToOne
    @JoinColumn(name = "tag33b_id", foreignKey = @ForeignKey(name = "FK_tag33b_id_mt202cov"))
    private Tag33B tag33B;

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt202cov"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt202COV mt202COV)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt202COV.sender) && receiver.equals(mt202COV.receiver) && tag20.equals(mt202COV.tag20) && tag21.equals(mt202COV.tag21) && Objects.equals(tag13C, mt202COV.tag13C) && Objects.equals(tag32A, mt202COV.tag32A) && Objects.equals(tag52A, mt202COV.tag52A) && Objects.equals(tag52D, mt202COV.tag52D) && Objects.equals(tag53A, mt202COV.tag53A) && Objects.equals(tag53B, mt202COV.tag53B) && Objects.equals(tag53D, mt202COV.tag53D) && Objects.equals(tag54A, mt202COV.tag54A) && Objects.equals(tag54B, mt202COV.tag54B) && Objects.equals(tag54D, mt202COV.tag54D) && Objects.equals(tag56A, mt202COV.tag56A) && Objects.equals(tag56D, mt202COV.tag56D) && Objects.equals(tag57A, mt202COV.tag57A) && Objects.equals(tag57B, mt202COV.tag57B) && Objects.equals(tag57D, mt202COV.tag57D) && Objects.equals(tag58A, mt202COV.tag58A) && Objects.equals(tag58D, mt202COV.tag58D) && Objects.equals(tag72, mt202COV.tag72) && Objects.equals(tag50A, mt202COV.tag50A) && Objects.equals(tag50F, mt202COV.tag50F) && Objects.equals(tag50K, mt202COV.tag50K) && Objects.equals(tag52A_2, mt202COV.tag52A_2) && Objects.equals(tag52D_2, mt202COV.tag52D_2) && Objects.equals(tag56A_2, mt202COV.tag56A_2) && Objects.equals(tag56C, mt202COV.tag56C) && Objects.equals(tag56D_2, mt202COV.tag56D_2) && Objects.equals(tag57A_2, mt202COV.tag57A_2) && Objects.equals(tag57B_2, mt202COV.tag57B_2) && Objects.equals(tag57C, mt202COV.tag57C) && Objects.equals(tag57D_2, mt202COV.tag57D_2) && Objects.equals(tag59, mt202COV.tag59) && Objects.equals(tag59A, mt202COV.tag59A) && Objects.equals(tag59F, mt202COV.tag59F) && Objects.equals(tag70, mt202COV.tag70) && Objects.equals(tag72_2, mt202COV.tag72_2) && Objects.equals(tag33B, mt202COV.tag33B) && Objects.equals(aCase, mt202COV.aCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag13C, tag32A, tag52A, tag52D, tag53A, tag53B, tag53D, tag54A, tag54B, tag54D, tag56A, tag56D, tag57A, tag57B, tag57D, tag58A, tag58D, tag72, tag50A, tag50F, tag50K, tag52A_2, tag52D_2, tag56A_2, tag56C, tag56D_2, tag57A_2, tag57B_2, tag57C, tag57D_2, tag59, tag59A, tag59F, tag70, tag72_2, tag33B, aCase);
    }
}
