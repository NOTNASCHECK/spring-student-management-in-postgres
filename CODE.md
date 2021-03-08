# Interessante Code Lösungen

## Class Student

### Alter berrechnen
```java

import java.time.LocalDate;
import java.time.Period;

    ...
    private LocalDate dob;
    ...
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
```

## Class StudentService
### Studenten hinzufügen
'''java
    ...
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        this.studentRepository.save(student);
    }
    ...
'''
