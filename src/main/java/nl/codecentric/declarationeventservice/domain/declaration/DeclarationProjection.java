package nl.codecentric.declarationeventservice.domain.declaration;

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
        Declaration declaration = new Declaration(event.id());
        declarationRepository.save(declaration);
    }
}
