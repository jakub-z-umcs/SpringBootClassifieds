package com.projekt.springboot.umcs.ad;

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
    private int price_in_cents;
    //private LocalDateTime created_at;

    public Ad(String title, String description, int price_in_cents, LocalDateTime created_at) {

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

    public void setTitle(String title) {
        this.title = title;
    }
}
