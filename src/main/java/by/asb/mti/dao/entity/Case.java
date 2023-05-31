package by.asb.mti.dao.entity;

import by.asb.mti.dao.entity.info.MtN92;
import by.asb.mti.dao.entity.info.MtN95;
import by.asb.mti.dao.entity.info.MtN96;
import by.asb.mti.dao.entity.info.MtN99;
import by.asb.mti.dao.entity.money.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity(name = "cases")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "reference", name = "UK_reference"))
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Case extends Base {

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datetimeOpen;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datetimeClose;

    @Column(nullable = false)
    private Boolean status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id_open", foreignKey = @ForeignKey(name = "FK_user_id_open_case"), referencedColumnName = "id", nullable = false)
    private User userOpen;

    @ManyToOne
    @JoinColumn(name = "user_id_close", foreignKey = @ForeignKey(name = "FK_user_id_close_case"), referencedColumnName = "id")
    private User userClose;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt103 mt103;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt200 mt200;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt202 mt202;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt202COV mt202COV;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt900 mt900;

    @OneToOne(mappedBy = "aCase")
    @ToString.Exclude
    private Mt910 mt910;

    @OneToMany(mappedBy = "businessCase")
    @ToString.Exclude
    private List<MtN92> mtN92List;

    @OneToMany(mappedBy = "businessCase")
    @ToString.Exclude
    private List<MtN95> mtN95List;

    @OneToMany(mappedBy = "businessCase")
    @ToString.Exclude
    private List<MtN96> mtN96List;

    @OneToMany(mappedBy = "businessCase")
    @ToString.Exclude
    private List<MtN99> mtN99List;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Case aCase)) return false;
        if (!super.equals(o)) return false;
        return reference.equals(aCase.reference) && datetimeOpen.equals(aCase.datetimeOpen) && Objects.equals(datetimeClose, aCase.datetimeClose) && status.equals(aCase.status) && userOpen.equals(aCase.userOpen) && Objects.equals(userClose, aCase.userClose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reference, datetimeOpen, datetimeClose, status, userOpen, userClose);
    }
}
