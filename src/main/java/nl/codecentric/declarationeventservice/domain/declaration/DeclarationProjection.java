package nl.codecentric.declarationeventservice.domain.declaration;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("declaration")
public class DeclarationProjection {
    private final DeclarationRepository declarationRepository;

    public DeclarationProjection(DeclarationRepository declarationRepository) {
        this.declarationRepository = declarationRepository;
    }

    @EventHandler
    public void on(DecarationCreatedEvent event){
        Declaration declaration = new Declaration(event.id(), event.employeeId());
        declarationRepository.save(declaration);
    }

    @EventHandler
    public void on(DeclarationTypeSelectedEvent event){
        Optional<Declaration> declaration = declarationRepository.findById(event.declarationId());
        if(declaration.isPresent()) {
            Declaration updatedDeclaration = declaration.get();
            updatedDeclaration.setDeclarationType(event.declarationType());

            declarationRepository.save(updatedDeclaration);
        }
    }
}
