package com.projekt.springboot.umcs.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student student1 = new Student(
                    "Mariam",
                    "maria@wa.ld",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student student2 = new Student(
                    "Angelika",
                    "lika@ange.ld",
                    LocalDate.of(2003, Month.JANUARY, 2)
            );

//            repository.saveAll(
//                    List.of(student1, student2)
//            );
        };
    }
}
