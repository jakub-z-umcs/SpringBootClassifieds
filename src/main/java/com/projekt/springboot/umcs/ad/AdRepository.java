package com.projekt.springboot.umcs.ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdRepository
        extends JpaRepository<Ad, Long> {

    @Query("SELECT s FROM Ad s WHERE s.email = ?1")
    Optional<Ad> findStudentByEmail(String email);
}
