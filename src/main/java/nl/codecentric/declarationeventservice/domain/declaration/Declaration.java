package nl.codecentric.declarationeventservice.domain.declaration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Declaration  {
    public Declaration() {
    }

    public Declaration(UUID id) {
        this.id = id;
    }

    @Id
    private UUID id;
}
