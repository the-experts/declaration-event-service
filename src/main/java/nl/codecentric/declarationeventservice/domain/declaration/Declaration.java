package nl.codecentric.declarationeventservice.domain.declaration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Declaration  {
    @Id
    private String declarationId;
    private Boolean isFinished;
    private UUID employeeId;
    private DeclarationType type;

    public Declaration() {
    }

    public Declaration(UUID id, UUID employeeId) {
        this.declarationId = id.toString();
        this.employeeId = employeeId;
        this.isFinished = false;
    }
    public void setType(DeclarationType type) {
        this.type = type;
    }
}
