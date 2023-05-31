package by.asb.mti.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;
import java.util.Objects;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Log extends Base {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datetime;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id_log"),nullable = false)
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log log)) return false;
        if (!super.equals(o)) return false;
        return datetime.equals(log.datetime) && url.equals(log.url) && description.equals(log.description) && user.equals(log.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), datetime, url, description, user);
    }
}
