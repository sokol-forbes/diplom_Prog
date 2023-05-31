package by.asb.mti.dao.entity.money;

import by.asb.mti.dao.entity.Base;
import by.asb.mti.dao.entity.Case;
import by.asb.mti.dao.entity.tag.Tag32A;
import by.asb.mti.dao.entity.tag.Tag33B;
import by.asb.mti.dao.entity.tag.Tag71F;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Mt103 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column
    private String tag13C;

    @Column(nullable = false)
    private String tag23B;

    @Column
    private String tag23E;

    @Column
    private String tag26T;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag32a_id", foreignKey = @ForeignKey(name = "FK_tag32a_id_mt103"))
    private Tag32A tag32A;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag33b_id", foreignKey = @ForeignKey(name = "FK_tag33b_id_mt103"))
    private Tag33B tag33B;

    @Column
    private String tag36;

    @Column
    private String tag50A;

    @Column
    private String tag50F;

    @Column
    private String tag50K;

    @Column
    private String tag51A;

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
    private String tag55A;

    @Column
    private String tag55B;

    @Column
    private String tag55D;

    @Column
    private String tag56A;

    @Column
    private String tag56C;

    @Column
    private String tag56D;

    @Column
    private String tag57A;

    @Column
    private String tag57B;

    @Column
    private String tag57C;

    @Column
    private String tag57D;

    @Column
    private String tag59;

    @Column
    private String tag59A;

    @Column
    private String tag59F;

    @Column
    private String tag70;

    @Column(nullable = false)
    private String tag71A;

    @Column
    private String tag71G;

    @Column
    private String tag72;

    @Column
    private String tag77B;

    @OneToMany
    @JoinColumn(name = "mt103_id", foreignKey = @ForeignKey(name = "FK_mt103_id_mt103"))
    @ToString.Exclude
    private List<Tag71F> tag71F;

    @OneToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mt103"))
    private Case aCase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mt103 mt103)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mt103.sender) && receiver.equals(mt103.receiver) && tag20.equals(mt103.tag20) && Objects.equals(tag13C, mt103.tag13C) && tag23B.equals(mt103.tag23B) && Objects.equals(tag23E, mt103.tag23E) && Objects.equals(tag26T, mt103.tag26T) && Objects.equals(tag32A, mt103.tag32A) && Objects.equals(tag33B, mt103.tag33B) && Objects.equals(tag36, mt103.tag36) && Objects.equals(tag50A, mt103.tag50A) && Objects.equals(tag50F, mt103.tag50F) && Objects.equals(tag50K, mt103.tag50K) && Objects.equals(tag51A, mt103.tag51A) && Objects.equals(tag52A, mt103.tag52A) && Objects.equals(tag52D, mt103.tag52D) && Objects.equals(tag53A, mt103.tag53A) && Objects.equals(tag53B, mt103.tag53B) && Objects.equals(tag53D, mt103.tag53D) && Objects.equals(tag54A, mt103.tag54A) && Objects.equals(tag54B, mt103.tag54B) && Objects.equals(tag54D, mt103.tag54D) && Objects.equals(tag55A, mt103.tag55A) && Objects.equals(tag55B, mt103.tag55B) && Objects.equals(tag55D, mt103.tag55D) && Objects.equals(tag56A, mt103.tag56A) && Objects.equals(tag56C, mt103.tag56C) && Objects.equals(tag56D, mt103.tag56D) && Objects.equals(tag57A, mt103.tag57A) && Objects.equals(tag57B, mt103.tag57B) && Objects.equals(tag57C, mt103.tag57C) && Objects.equals(tag57D, mt103.tag57D) && Objects.equals(tag59, mt103.tag59) && Objects.equals(tag59A, mt103.tag59A) && Objects.equals(tag59F, mt103.tag59F) && Objects.equals(tag70, mt103.tag70) && tag71A.equals(mt103.tag71A) && Objects.equals(tag71G, mt103.tag71G) && Objects.equals(tag72, mt103.tag72) && Objects.equals(tag77B, mt103.tag77B) && Objects.equals(aCase, mt103.aCase) && Objects.equals(tag71F, mt103.tag71F);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag13C, tag23B, tag23E, tag26T, tag32A, tag33B, tag36, tag50A, tag50F, tag50K, tag51A, tag52A, tag52D, tag53A, tag53B, tag53D, tag54A, tag54B, tag54D, tag55A, tag55B, tag55D, tag56A, tag56C, tag56D, tag57A, tag57B, tag57C, tag57D, tag59, tag59A, tag59F, tag70, tag71A, tag71G, tag72, tag77B, aCase, tag71F);
    }
}
