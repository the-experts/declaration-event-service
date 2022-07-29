package nl.codecentric.declarationeventservice.domain.declaration;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record SelectDeclarationTypeCommand(@TargetAggregateIdentifier UUID id, DeclarationType type) {
}
