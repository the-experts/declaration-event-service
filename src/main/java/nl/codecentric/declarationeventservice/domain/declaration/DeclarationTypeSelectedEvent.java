package nl.codecentric.declarationeventservice.domain.declaration;

import java.util.UUID;

public record DeclarationTypeSelectedEvent(UUID id, DeclarationType type) {
}
