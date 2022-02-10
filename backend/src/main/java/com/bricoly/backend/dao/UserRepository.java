package com.bricoly.backend.dao;

import com.bricoly.backend.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "select * from users where email=?1 and password=?2", nativeQuery = true)
    Optional<User> checkCredentials(String email, String password);
}