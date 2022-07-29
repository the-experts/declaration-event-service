package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public record UpdatePasswordCommand(
        @TargetAggregateIdentifier UUID employeeId, String password) {
}
