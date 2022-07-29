package nl.codecentric.declarationeventservice.domain.user;

import nl.codecentric.declarationeventservice.repository.user.UserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("user")
public class UserProjection {
    private final UserRepository userRepository;

    public UserProjection(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        Employee employee = new Employee(event.id(), event.name(), event.email());
        userRepository.save(employee);
    }
}
