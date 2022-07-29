package nl.codecentric.declarationeventservice.domain.declaration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Declaration {

    public Declaration() {};

    public Declaration(UUID id, UUID employeeId)  {
        this.id = id;
        this.employeeId = employeeId;
    }

    @Id
    private UUID id;
    private UUID employeeId;
}
