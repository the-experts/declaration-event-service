package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private UUID id;
    private String password;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        if (!command.email().contains("@")) {
            throw new IllegalArgumentException("Email address must not contain an @");
        }
        apply(new UserCreatedEvent(command.id(), command.name(), command.email(), command.password()));
    }

    @CommandHandler
    public void on(UpdatePasswordCommand command) {
        if (!password.equals(command.password())) {
            apply(new PasswordChangedEvent(command.employeeId(), command.password()));
        }
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        this.id = event.id();
        this.password = event.password();
    }

    @EventSourcingHandler
    public void on(PasswordChangedEvent event) {
        this.password = event.newPassword();
    }
}
