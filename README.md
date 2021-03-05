# spring-student-management-in-postgres

## Postgres in Docker und erstellen von Tabelle und verbindnen mit Spring Boot

1) Create Image\
![grafik](https://user-images.githubusercontent.com/75083505/110099559-b97b3c00-7da1-11eb-8a30-5b141de9b454.png)

2) Start Image if it doesnt\
![grafik](https://user-images.githubusercontent.com/75083505/110099638-d283ed00-7da1-11eb-9473-14c58b2336e0.png)

3) look container\
![grafik](https://user-images.githubusercontent.com/75083505/110099763-f8a98d00-7da1-11eb-9325-8aec68996923.png)

4) Auf Container einlogen\
![grafik](https://user-images.githubusercontent.com/75083505/110099982-34445700-7da2-11eb-8d2e-7bf1457e1732.png)

5) Mit Benutzer einlogen\
![grafik](https://user-images.githubusercontent.com/75083505/110100129-5a69f700-7da2-11eb-8393-4ca3c2396a1a.png)

6) Liste von Databases anzeigen\
![grafik](https://user-images.githubusercontent.com/75083505/110100218-74a3d500-7da2-11eb-9dca-5a2d9907b8bb.png)

7) Neue Database erstellen\
![grafik](https://user-images.githubusercontent.com/75083505/110100370-9d2bcf00-7da2-11eb-8c80-15412a1c88be.png)

8) Rollen anschauen\
![grafik](https://user-images.githubusercontent.com/75083505/110100719-057ab080-7da3-11eb-8e72-d20f2c97f4dc.png)

9) Rolle alle Rechte für Database geben\
![grafik](https://user-images.githubusercontent.com/75083505/110100960-4e326980-7da3-11eb-985b-52e5945534a3.png)

10) Liste Database prüfen\
![grafik](https://user-images.githubusercontent.com/75083505/110101204-93ef3200-7da3-11eb-8f5c-2e683e18db71.png)

11) Mit database verbinden\
![grafik](https://user-images.githubusercontent.com/75083505/110102605-483d8800-7da5-11eb-8457-565ca1a91f4d.png)

13) prüfen von Relationen bzw. Tabellen\
![grafik](https://user-images.githubusercontent.com/75083505/110102684-60150c00-7da5-11eb-86d2-473c48fe5217.png)

14) Uncomment dependency\
![grafik](https://user-images.githubusercontent.com/75083505/110102855-8f2b7d80-7da5-11eb-8acf-26b052070d7f.png)

15) application.properteies:
~~~
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
~~~

## JPA
In dem Annotaions an Model Student angehängt wurden wurde eine Tabelle initiiert:
```java
´@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "sutdent_sequence",
            allocationSize = 1
            )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
            )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student() {
    }
...
```
Beim starten von App erzeugt Hibernate die Tabelle:\
~~~
...
Hibernate: create sequence sutdent_sequence start 1 increment 1
Hibernate: 
    
    create table student (
       id int8 not null,
        age int4,
        dob date,
        email varchar(255),
        name varchar(255),
        primary key (id)
    )
...
~~~
In Postgres kann man dies einsehen\
![grafik](https://user-images.githubusercontent.com/75083505/110109733-21378400-7dae-11eb-9fca-d93dc47691ad.png)


