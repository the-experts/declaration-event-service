package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;
import java.util.UUID;

public final class UpdatePasswordCommand {
    @TargetAggregateIdentifier
    private final UUID employeeId;
    private final String password;

    public UpdatePasswordCommand(
            UUID employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    @TargetAggregateIdentifier
    public UUID employeeId() {
        return employeeId;
    }

    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UpdatePasswordCommand) obj;
        return Objects.equals(this.employeeId, that.employeeId) &&
                Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, password);
    }

    @Override
    public String toString() {
        return "UpdatePasswordCommand[" +
                "employeeId=" + employeeId + ", " +
                "password=" + password + ']';
    }

}
