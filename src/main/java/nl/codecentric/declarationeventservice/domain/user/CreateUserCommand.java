package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;
import java.util.UUID;

public final class CreateUserCommand {
    @TargetAggregateIdentifier
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;

    public CreateUserCommand(
            UUID id,
            String name,
            String email,
            String password
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @TargetAggregateIdentifier
    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateUserCommand) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "CreateUserCommand[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "email=" + email + ", " +
                "password=" + password + ']';
    }

}
