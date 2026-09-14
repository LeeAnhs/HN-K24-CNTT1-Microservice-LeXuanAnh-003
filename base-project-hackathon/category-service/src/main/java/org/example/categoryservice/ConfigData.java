package org.example.categoryservice;

import org.example.categoryservice.entity.Category;
import org.example.categoryservice.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigData {

    @Bean
    CommandLineRunner loadCategories(CategoryRepository categoryRepository) {
        return args -> {
            if (categoryRepository.count() == 0) {
                categoryRepository.save(new Category("Pain relief"));
                categoryRepository.save(new Category("Antibiotic"));
            }
        };
    }
}
