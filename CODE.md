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
````java
    ...
    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        this.studentRepository.save(student);
    }
    ...
````
Methode addNewStudent(Student student) hat einen Parameter.\
Parameter ist der zu hinzufügende Student.\
Es wird geprüft, ob Student vorhanden ist, wenn es so ist wird eine Exception geworfen.\
Wenn Student nicht vorhanden ist wird dieser hinzugefügt.\
Überprüfung wird mittles Optional gemacht.\
\
Es wird in Optional ein Student Objekt abgelegt, dass auch nicht vorhanden sein kann.

### Studenten entfernen
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+studentId+" does not Exitsts");
        }
        this.studentRepository.deleteById(studentId);
    }
