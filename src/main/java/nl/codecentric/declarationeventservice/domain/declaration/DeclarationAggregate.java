package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import nl.codecentric.declarationeventservice.domain.types.TaxPercentageType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DeclarationAggregate {
    @AggregateIdentifier
    private String id;
    private String employeeId;
    private DeclarationType declarationType;

    private TaxPercentageType taxPercentage;

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

    @CommandHandler
    public void handle(AddTaxPercentageCommand command) {
        apply(new AddedTaxPercentageEvent(
                command.declarationId(),
                command.taxPercentageType()
        ));
    }

    @EventSourcingHandler
    public void on(DeclarationTypeSelectedEvent declarationTypeSelectedEvent) {
        this.declarationType = declarationTypeSelectedEvent.declarationType();
    }

    @EventSourcingHandler
    public void on(AddedTaxPercentageEvent event){
        this.taxPercentage = event.taxPercentageType();
    }

    @EventSourcingHandler
    public void on(DecarationCreatedEvent event){
        this.id = event.id();
        this.employeeId = event.employeeId();
    }
}
