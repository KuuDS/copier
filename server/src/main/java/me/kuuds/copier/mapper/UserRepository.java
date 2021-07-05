package me.kuuds.copier.mapper;

import me.kuuds.copier.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Optional<User> findUserByUsername(@Param("username") String username);

    Optional<User> findUserByApiKey(@Param("apiKey") String apiKey);

}