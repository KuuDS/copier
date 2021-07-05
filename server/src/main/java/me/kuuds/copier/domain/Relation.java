package me.kuuds.copier.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Relation Pojo
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "relation")
@Data
@IdClass(RelationId.class)
public class Relation {

    @Id
    private Integer userId;
    @Id
    private Integer blobId;
}
