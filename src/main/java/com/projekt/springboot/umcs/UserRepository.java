package com.projekt.springboot.umcs;

import com.projekt.springboot.umcs.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    User getById(Long userId);
}