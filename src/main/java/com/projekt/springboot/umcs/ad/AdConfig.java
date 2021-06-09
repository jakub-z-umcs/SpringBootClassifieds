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

        };
    }
}
