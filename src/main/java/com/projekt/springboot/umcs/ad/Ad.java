package com.projekt.springboot.umcs.ad;

import javax.persistence.*;

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
    }

    public Ad() {
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

    public void setUserId(Long user_id) { this.user_id = user_id; }

    public int getPriceInCents() {
        return price_in_cents;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
