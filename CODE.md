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
