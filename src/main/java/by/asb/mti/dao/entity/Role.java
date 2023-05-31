package by.asb.mti.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity(name = "roles")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "authority", name = "UK_authority"))
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Role extends Base implements GrantedAuthority {

    @Column(nullable = false)
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        if (!super.equals(o)) return false;
        return authority.equals(role.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), authority);
    }
}
