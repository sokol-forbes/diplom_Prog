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
public class MtN92 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column
    private String tag11S;

    @Column(length = 2500)
    private String tag79;

    @ManyToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mtn92"))
    private Case businessCase;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id_mtn92"))
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MtN92 mtN92)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mtN92.sender) && receiver.equals(mtN92.receiver) && tag20.equals(mtN92.tag20) && tag21.equals(mtN92.tag21) && Objects.equals(tag11S, mtN92.tag11S) && Objects.equals(tag79, mtN92.tag79) && Objects.equals(businessCase, mtN92.businessCase) && Objects.equals(user, mtN92.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag11S, tag79, businessCase, user);
    }
}
