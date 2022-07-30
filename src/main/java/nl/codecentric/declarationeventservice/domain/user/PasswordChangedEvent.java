package nl.codecentric.declarationeventservice.domain.user;

import java.util.Objects;
import java.util.UUID;

record PasswordChangedEvent(UUID employeeId, String newPassword) {
}
