package nl.codecentric.declarationeventservice.domain.declaration;

import java.util.UUID;

record DecarationCreatedEvent(
    UUID id,
    UUID employeeId
) {}
