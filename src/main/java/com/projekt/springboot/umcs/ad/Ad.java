package com.projekt.springboot.umcs.ad;

import com.projekt.springboot.umcs.category.Category;
import com.projekt.springboot.umcs.user.CustomUser;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.Authentication;
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
    @SequenceGenerator(
            name = "ad_sequence",
            sequenceName = "ad_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ad_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private Long user_id;
    private int price_in_cents;
//    @CreationTimestamp
//    private LocalDateTime created_at;
//    @UpdateTimestamp
//    private LocalDateTime updated_at;

//    @ManyToOne
//    private Category category;


    public Ad(String title, String description, int price_in_cents) {
        this.title = title;
        this.description = description;
        this.price_in_cents = 100;
    }

    public Ad() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CustomUser user = null;
//        if(auth.isAuthenticated()) {
//            user = (CustomUser) auth.getPrincipal();
//        }
//
//        if (maybe_user != null) {
//            user = (CustomUser) maybe_user;
//        }
//        CustomUser user = (CustomUser) maybe_user;
        System.out.println("############");
//        System.out.println(user);
        System.out.println("############");
//        this.user_id = (long) user.getUserID();
        this.price_in_cents = 100;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getUserId() {
        return user_id;
    }

    public int getPriceInCents() {
        return price_in_cents;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
