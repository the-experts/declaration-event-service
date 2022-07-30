package nl.codecentric.declarationeventservice.domain.declaration;

import java.util.UUID;

record DecarationCreatedEvent(
    String id,
    String employeeId
) {}
