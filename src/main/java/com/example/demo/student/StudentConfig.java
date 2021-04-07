package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
             Student mariam  = new Student(
                    "Mariam",
                    "mariam@dd.com",
                    LocalDate.of(2000, Month.JANUARY, 22)
            );

            Student alex  = new Student(
                    "Alex",
                    "alex@dd.com",
                    LocalDate.of(2001, Month.JANUARY, 7)
            );
            //save list of students to the database
            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
