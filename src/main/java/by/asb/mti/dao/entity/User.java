package by.asb.mti.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Objects;

@Entity(name = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login", name = "UK_login"))
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User extends Base implements UserDetails {

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_user_id")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_role_id")
            )
    )
    private List<Role> authorities;

    @Column(nullable = false)
    private boolean accountNonExpired;

    @Column(nullable = false)
    private boolean accountNonLocked;

    @Column(nullable = false)
    private boolean credentialsNonExpired;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Log> logs;

    @OneToMany(mappedBy = "userOpen")
    @ToString.Exclude
    private List<Case> casesOpen;

    @OneToMany(mappedBy = "userClose")
    @ToString.Exclude
    private List<Case> casesClose;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;
        return accountNonExpired == user.accountNonExpired && accountNonLocked == user.accountNonLocked && credentialsNonExpired == user.credentialsNonExpired && enabled == user.enabled && login.equals(user.login) && username.equals(user.username) && password.equals(user.password) && authorities.equals(user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, username, password, authorities, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled);
    }
}
