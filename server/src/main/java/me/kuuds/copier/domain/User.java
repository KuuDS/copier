package me.kuuds.copier.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User pojo
 *
 * @since 1.0.0
 */
@Entity(name = "user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @Id
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "api_key")
    private String apiKey;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;

        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return 562048007;
    }
}
