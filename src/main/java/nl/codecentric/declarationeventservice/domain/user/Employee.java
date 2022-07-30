package nl.codecentric.declarationeventservice.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Employee {
    public Employee() {
    }

    public Employee(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    private String id;
    private String name;
    private String email;
}
