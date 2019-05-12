package com.magicworldz.springlearn.security.jpa;

import com.magicworldz.springlearn.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT t FROM users t WHERE t.username = :username")
    User findUserByName(@Param("username") String username);
}
