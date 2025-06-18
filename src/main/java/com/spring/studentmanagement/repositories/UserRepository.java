package com.spring.studentmanagement.repositories;

import com.spring.studentmanagement.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query(value="SELECT u FROM AppUser u WHERE u.username  = ?1 OR u.email = ?1")
    Optional<AppUser> findBYUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);
}
