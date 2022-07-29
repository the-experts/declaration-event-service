package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.repository.declaration.DeclarationRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("declaration")
public class DeclarationProjection {
    private final DeclarationRepository declarationRepository;

    public DeclarationProjection(DeclarationRepository declarationRepository) {
        this.declarationRepository = declarationRepository;
    }

    @EventHandler
    public void on(DeclarationCreatedEvent event) {
        Declaration declaration = new Declaration(event.id(), event.employeeId());
        declarationRepository.save(declaration);
    }

    @EventHandler
    public void on(DeclarationTypeSelectedEvent event) {
        Declaration declaration = declarationRepository.findById(event.id().toString()).get();
        declaration.setType(event.type());
        declarationRepository.save(declaration);
    }
}
