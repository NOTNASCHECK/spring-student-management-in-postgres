package org.notna.springstudentmanagementinpostgres.springstudentmanagementinpostgres.student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StudentService {

    public List<Student> getStudents(){
        return Arrays.asList(
                new Student(1L, "Mariam", "mariam.ziff@gmail.com", LocalDate.of(2000, 1, 30), 22),
                new Student(1L, "Max", "max.moritz@gmail.com", LocalDate.of(2000, 1, 30), 30)
                );
    }

}
