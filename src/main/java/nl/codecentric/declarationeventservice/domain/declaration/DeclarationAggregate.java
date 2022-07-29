package nl.codecentric.declarationeventservice.domain.declaration;

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
    private DeclarationType type;

    public  DeclarationAggregate() {
    }

    @CommandHandler
    public DeclarationAggregate(CreateDeclarationCommand command) {
        apply(new DeclarationCreatedEvent(command.id()));
    }

    @CommandHandler
    public DeclarationAggregate(SelectDeclarationTypeCommand command) {
        apply(new DeclarationTypeSelectedEvent(command.id(), command.type()));
    }


    @EventSourcingHandler
    public void on(DeclarationCreatedEvent event) {
        this.id = event.id();
    }

    @EventSourcingHandler
    public void on(DeclarationTypeSelectedEvent event) {
        this.type = event.type();
    }
}
