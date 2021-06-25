package com.projekt.springboot.umcs.ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository
        extends JpaRepository<Ad, Long> {

    @Query("select a from Ad a join a.categories c where c.id = :category_id")
    List<Ad> findByCategory(@Param("category_id")Long category_id);
}
