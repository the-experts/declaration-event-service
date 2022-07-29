package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


public record UpdatePasswordCommand(
        @TargetAggregateIdentifier String employeeId, String password) {
}
