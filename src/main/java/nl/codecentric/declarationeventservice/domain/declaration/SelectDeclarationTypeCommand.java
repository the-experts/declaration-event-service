package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record SelectDeclarationTypeCommand(
    @TargetAggregateIdentifier UUID declarationId,
    DeclarationType declarationType
){}
