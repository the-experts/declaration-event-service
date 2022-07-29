package nl.codecentric.declarationeventservice.domain.user;

import java.util.Objects;
import java.util.UUID;

final class PasswordChangedEvent {
    private final UUID employeeId;
    private final String newPassword;

    PasswordChangedEvent(UUID employeeId, String newPassword) {
        this.employeeId = employeeId;
        this.newPassword = newPassword;
    }

    public UUID employeeId() {
        return employeeId;
    }

    public String newPassword() {
        return newPassword;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PasswordChangedEvent) obj;
        return Objects.equals(this.employeeId, that.employeeId) &&
                Objects.equals(this.newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, newPassword);
    }

    @Override
    public String toString() {
        return "PasswordChangedEvent[" +
                "employeeId=" + employeeId + ", " +
                "newPassword=" + newPassword + ']';
    }

}
