package com.projekt.springboot.umcs.ad;

import com.projekt.springboot.umcs.category.Category;
import com.projekt.springboot.umcs.user.CustomUser;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long user_id;
    private int price_in_cents;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne
    private Category category;


    public Ad(String title, String description, int price_in_cents, LocalDateTime created_at) {
        this.title = title;
        this.description = description;
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication();
        this.user_id = (long) user.getUserID();
    }

    public Ad() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
