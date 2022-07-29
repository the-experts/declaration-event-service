package nl.codecentric.declarationeventservice.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Employee {
    public Employee() {
    }

    public Employee(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    private UUID id;
    private String name;
    private String email;
}
