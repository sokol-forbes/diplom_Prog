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
public class MtN96 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column
    private String tag76;

    @Column(length = 1800)
    private String tag77A;

    @Column(length = 1800)
    private String tag11a;

    @Column(length = 2500)
    private String tag79;

    @ManyToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mtn96"))
    private Case businessCase;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id_mtn96"))
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MtN96 mtN96)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mtN96.sender) && receiver.equals(mtN96.receiver) && tag20.equals(mtN96.tag20) && tag21.equals(mtN96.tag21) && Objects.equals(tag76, mtN96.tag76) && Objects.equals(tag77A, mtN96.tag77A) && Objects.equals(tag11a, mtN96.tag11a) && Objects.equals(tag79, mtN96.tag79) && Objects.equals(businessCase, mtN96.businessCase) && Objects.equals(user, mtN96.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag76, tag77A, tag11a, tag79, businessCase, user);
    }
}
