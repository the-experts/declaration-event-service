package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;


public record DeclarationTypeSelectedEvent (
        String declarationId,
    DeclarationType declarationType
){}
