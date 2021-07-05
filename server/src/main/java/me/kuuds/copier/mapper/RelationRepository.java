package me.kuuds.copier.mapper;

import me.kuuds.copier.domain.Relation;
import me.kuuds.copier.domain.RelationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RelationRepository extends PagingAndSortingRepository<Relation, RelationId> {

    @Query("select r from Relation r " +
            "where r.userId = :userId " +
            "and r.blobId = :blobId")
    Optional<Relation> findWithUserIdAndBlobId(@Param("userId") int userId, @Param("blobId") int blobId);

}