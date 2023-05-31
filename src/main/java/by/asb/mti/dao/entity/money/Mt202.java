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
public class Mt202 extends Base {
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
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt202"))
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

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt202"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt202 mt202)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt202.sender) && receiver.equals(mt202.receiver) && tag20.equals(mt202.tag20) && tag21.equals(mt202.tag21) && Objects.equals(tag13C, mt202.tag13C) && Objects.equals(tag32A, mt202.tag32A) && Objects.equals(tag52A, mt202.tag52A) && Objects.equals(tag52D, mt202.tag52D) && Objects.equals(tag53A, mt202.tag53A) && Objects.equals(tag53B, mt202.tag53B) && Objects.equals(tag53D, mt202.tag53D) && Objects.equals(tag54A, mt202.tag54A) && Objects.equals(tag54B, mt202.tag54B) && Objects.equals(tag54D, mt202.tag54D) && Objects.equals(tag56A, mt202.tag56A) && Objects.equals(tag56D, mt202.tag56D) && Objects.equals(tag57A, mt202.tag57A) && Objects.equals(tag57B, mt202.tag57B) && Objects.equals(tag57D, mt202.tag57D) && Objects.equals(tag58A, mt202.tag58A) && Objects.equals(tag58D, mt202.tag58D) && Objects.equals(tag72, mt202.tag72) && Objects.equals(aCase, mt202.aCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag13C, tag32A, tag52A, tag52D, tag53A, tag53B, tag53D, tag54A, tag54B, tag54D, tag56A, tag56D, tag57A, tag57B, tag57D, tag58A, tag58D, tag72, aCase);
    }
}
