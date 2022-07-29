package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Declaration {

    public Declaration() {};

    public Declaration(String id, String employeeId)  {
        this.id = id;
        this.employeeId = employeeId;
    }

    @Id
    private String id;
    private String employeeId;

    private DeclarationType declarationType;

    public void setDeclarationType(DeclarationType declarationType) {
        this.declarationType = declarationType;
    }
}
