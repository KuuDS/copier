package me.kuuds.copier.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Data Pojo
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "blob_data")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BlobData {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BlobData blobData = (BlobData) o;

        return id != null && id.equals(blobData.id);
    }

    @Override
    public int hashCode() {
        return 2076872449;
    }
}
