package nl.codecentric.declarationeventservice.domain.user;

import java.util.UUID;

record UserCreatedEvent(String id, String name, String email, String password) {
}
