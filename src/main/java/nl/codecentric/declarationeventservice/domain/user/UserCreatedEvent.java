package nl.codecentric.declarationeventservice.domain.user;

import java.util.Objects;
import java.util.UUID;

record UserCreatedEvent(UUID id, String name, String email, String password) {
}
