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
public class MtN99 extends Base {
    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String tag20;

    @Column(nullable = false)
    private String tag21;

    @Column(length = 2500)
    private String tag79;

    @ManyToOne
    @JoinColumn(name = "case_id", foreignKey = @ForeignKey(name = "FK_case_id_mtn99"))
    private Case businessCase;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id_mtn99"))
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MtN99 mtN99)) return false;
        if (!super.equals(o)) return false;
        return sender.equals(mtN99.sender) && receiver.equals(mtN99.receiver) && tag20.equals(mtN99.tag20) && tag21.equals(mtN99.tag21) && Objects.equals(tag79, mtN99.tag79) && Objects.equals(businessCase, mtN99.businessCase) && Objects.equals(user, mtN99.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, receiver, tag20, tag21, tag79, businessCase, user);
    }
}
