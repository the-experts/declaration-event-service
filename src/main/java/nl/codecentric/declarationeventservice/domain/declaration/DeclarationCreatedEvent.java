package nl.codecentric.declarationeventservice.domain.declaration;

import java.util.UUID;

public record DeclarationCreatedEvent(UUID id, UUID employeeId) {
}
