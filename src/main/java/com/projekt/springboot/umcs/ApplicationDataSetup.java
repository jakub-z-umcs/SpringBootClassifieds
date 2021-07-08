//package com.projekt.springboot.umcs;
//
//import com.projekt.springboot.umcs.category.Category;
//import com.projekt.springboot.umcs.category.CategoryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ApplicationDataSetup {
//
//    @Bean
//    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository) {
//        return args -> {
//            Category books_category = new Category("books");
//            Category car_category = new Category("cars");
//
//            categoryRepository.saveAll(List.of(books_category, car_category));
//        };
//    }
//}
