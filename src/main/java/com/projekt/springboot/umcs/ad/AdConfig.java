package com.projekt.springboot.umcs.ad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AdConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            AdRepository repository) {
        return args -> {
            Ad ad1 = new Ad(
                    "Mariam",
                    "maria@wa.ld",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Ad ad2 = new Ad(
                    "Angelika",
                    "lika@ange.ld",
                    LocalDate.of(2003, Month.JANUARY, 2)
            );

            repository.saveAll(
                    List.of(ad1, ad2)
            );
        };
    }
}
