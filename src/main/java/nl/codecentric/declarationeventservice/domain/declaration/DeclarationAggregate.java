package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DeclarationAggregate {
    @AggregateIdentifier
    private UUID id;
    private UUID employeeId;
    private DeclarationType declarationType;

    public DeclarationAggregate () {
    }

    @CommandHandler
    public DeclarationAggregate (CreateDeclarationCommand command) {
        apply(new DecarationCreatedEvent(command.id(), command.employeeId()));
    }

    @CommandHandler
    public void handle(SelectDeclarationTypeCommand command) {
        apply(new DeclarationTypeSelectedEvent(
                command.declarationId(),
                command.declarationType())
        );
    }

    @EventSourcingHandler
    public void on(DeclarationTypeSelectedEvent declarationTypeSelectedEvent) {
        this.declarationType = declarationTypeSelectedEvent.declarationType();
    }

    @EventSourcingHandler
    public void on(DecarationCreatedEvent event){
        this.id = event.id();
        this.employeeId = event.employeeId();
    }
}
