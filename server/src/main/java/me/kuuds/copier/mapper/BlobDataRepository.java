package me.kuuds.copier.mapper;

import me.kuuds.copier.domain.BlobData;
import me.kuuds.copier.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlobDataRepository extends PagingAndSortingRepository<BlobData, Integer> {

    @Query("select b from BlobData b" +
            " join Relation r on b.id = r.blobId " +
            " where r.userId = :userId " +
            " and b.id = :blobId")
    Optional<BlobData> findByUserIdAndBlobId(@Param("userId") int userId, @Param("blobId") int blobId);

    @Query("select b from BlobData b " +
            "join Relation  r " +
            "on b.id = r.blobId " +
            "where r.userId = :userId")
    Page<BlobData> findAllByUserId(@Param("userId") int userId, Pageable pageable);
}