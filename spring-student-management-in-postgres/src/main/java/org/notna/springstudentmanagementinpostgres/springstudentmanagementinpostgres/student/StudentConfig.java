package org.notna.springstudentmanagementinpostgres.springstudentmanagementinpostgres.student;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args->{
                    Student mariam = new Student("Mariam", "mariam.ziff@gmail.com", LocalDate.of(2000, 1, 30), 22);
                    Student phillip = new Student("Phillip", "phillip.ziff@gmail.com", LocalDate.of(2000, 1, 30), 22);
                    repository.saveAll(Arrays.asList(mariam, phillip));
        };
    }
}