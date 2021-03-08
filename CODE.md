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
    ...
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+studentId+" does not Exitsts");
        }
        this.studentRepository.deleteById(studentId);
    ...
```
Der deleteStudent Methode wird Id mitgegeben.\
Die Id sagt, welcher Student gelöscht werden soll.\
Als erstes wird geprüft, ob Student vorhanden ist. 
Ergebnis von Prüfung wird in ein boolean Wert gespeichert.\
Wenn Student nicht vorhanden ist, wird eine Exception geworfen.\
Wenn der Student vorhanden ist wird Student gelöscht.

### Studenten Name oder E-Meil oder Name&Email ändern
```java
    ...
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
    ...
```
Transactional = de. Transaktion = syn. Bündnis, Verbundheit, Auftrag\
@Transactional wird verwendet für Methoden die Datenbanktransaktionen durchführen.\
@Transactional ist unklar auch JPA ist unklar.

Zu erst wird geprüft ob Student mit der studentId vorhanden ist.\
Interessant ist die Funktional Programmierung und Labmda-Ausdruck:\
```java
        Student student = this.studentRepository
                                    .findById(studentId)
                                    .orElseThrow(
                                            ()-> new IllegalStateException(
                                            "student wiht id "+studentId+" does not exists"));
```
.orElse.Throw(...) ist eine schlanke Lösung und ty-catch sowie if-Block wird vermieden.\
Wenn es die studentenId nicht gibt wird die updateStudent(..) Methode sofort verlassen.\

Dann findet die Prüfung von Namen statt.\
Wenn name kein Null Wert ist und\
name länger als 0 und\
name undgleich vorhanden name ist dann\
wird mit student.setName(name) namen für Studenten gesetzt:
```java
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
                student.setName(name);
        }
```
Interessant ist die Verwendung von Objects.equals(..).\

Danach wird Email überprüft:
```java
        if(email!= null &&
                email.length()> 0 &&
                !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
        }student.setEmail(email);
```
email darf nicht null sind\
email muss länger als 0 Zeichen sein\
email muss anderen Wert haben als vorhanden\
Und anschließend wird noch geprüft ob die vorhandene Email Adresse schon bei jemanden eingetragen ist,\
wenn es so ist, dann wird eine Exception geworfen.\


