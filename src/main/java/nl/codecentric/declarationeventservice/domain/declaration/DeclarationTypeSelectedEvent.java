package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;

import java.util.UUID;

public record DeclarationTypeSelectedEvent (
    UUID declarationId,
    DeclarationType declarationType
){}
