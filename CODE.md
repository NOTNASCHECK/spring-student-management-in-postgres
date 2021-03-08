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
```java
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+studentId+" does not Exitsts");
        }
        this.studentRepository.deleteById(studentId);
    }
```
Der deleteStudent Methode wird Id mitgegeben.\
Die Id sagt, welcher Student gelöscht werden soll.\
Als erstes wird geprüft, ob Student vorhanden ist. 
Ergebnis von Prüfung wird in ein boolean Wert gespeichert.\
Wenn Student nicht vorhanden ist, wird eine Exception geworfen.\
Wenn der Student vorhanden ist wird Student gelöscht.

### Studenten Name | E-Meil | Name&Email ändern
```java
 @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = this.studentRepository
                                    .findById(studentId)
                                    .orElseThrow(
                                            ()-> new IllegalStateException(
                                            "student wiht id "+studentId+" does not exists"));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
                student.setName(name);
        }

        if(email!= null &&
                email.length()> 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
        }student.setEmail(email);
    }
```
