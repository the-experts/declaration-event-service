package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public record SelectDeclarationTypeCommand(
    @TargetAggregateIdentifier String declarationId,
    DeclarationType declarationType
){}
