package nl.codecentric.declarationeventservice.domain.declaration;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Objects;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DeclarationAggregate {

    @AggregateIdentifier
    private UUID id;
    private UUID employeeId;
    private DeclarationType type;

    public  DeclarationAggregate() {
    }

    @CommandHandler
    public DeclarationAggregate(CreateDeclarationCommand command) {
        // TODO Check for actual User ID
//        if (!Objects.equals(command.employeeId().toString(), "e261abcd-d2a5-46d7-bf10-980e3805a19e")) {
//            throw new IllegalArgumentException("employeeId doesn't match");
//        }
        apply(new DeclarationCreatedEvent(command.id(), command.employeeId()));
    }

    @CommandHandler
    public void handle(SelectDeclarationTypeCommand command) {
        apply(new DeclarationTypeSelectedEvent(command.id(), command.type()));
    }


    @EventSourcingHandler
    public void on(DeclarationCreatedEvent event) {
        this.id = event.id();
        this.employeeId = event.employeeId();
    }

    @EventSourcingHandler
    public void on(DeclarationTypeSelectedEvent event) {
        this.type = event.type();
    }
}
