package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;
import java.util.UUID;

public record CreateUserCommand(@TargetAggregateIdentifier UUID id, String name, String email, String password) {
}
