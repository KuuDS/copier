package me.kuuds.copier.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Relation Primary Key
 *
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Embeddable
public class RelationId implements Serializable {

    @Id
    @Column(name = "uid")
    private Integer userId;
    @Id
    @Column(name = "blob_id")
    private Integer blobId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RelationId that = (RelationId) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (blobId != null ? !blobId.equals(that.blobId) : that.blobId != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (blobId != null ? blobId.hashCode() : 0);
        return result;
    }
}