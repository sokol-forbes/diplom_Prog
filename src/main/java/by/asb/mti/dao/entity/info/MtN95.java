package by.asb.mti.dao.entity.info;

import by.asb.mti.dao.entity.Base;
import by.asb.mti.dao.entity.Case;
import by.asb.mti.dao.entity.User;
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
public class MtN95 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column
    private String tag75;

    @Column(length = 1800)
    private String tag77A;

    @Column(length = 1800)
    private String tag11a;

    @Column(length = 2500)
    private String tag79;

    @ManyToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mtn95"))
    private Case businessCase;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id_mtn95"))
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MtN95 mtN95)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mtN95.sender) && receiver.equals(mtN95.receiver) && tag20.equals(mtN95.tag20) && tag21.equals(mtN95.tag21) && Objects.equals(tag75, mtN95.tag75) && Objects.equals(tag77A, mtN95.tag77A) && Objects.equals(tag11a, mtN95.tag11a) && Objects.equals(tag79, mtN95.tag79) && Objects.equals(businessCase, mtN95.businessCase) && Objects.equals(user, mtN95.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag75, tag77A, tag11a, tag79, businessCase, user);
    }
}
