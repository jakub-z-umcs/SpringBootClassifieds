package com.projekt.springboot.umcs.ad;

import javax.persistence.*;
import java.time.LocalDate;
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
    private String name;

    public Ad(String name) {
        this.name = name;
    }

    public Ad() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
