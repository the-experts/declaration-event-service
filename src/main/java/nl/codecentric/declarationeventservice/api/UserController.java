package nl.codecentric.declarationeventservice.api;

import nl.codecentric.declarationeventservice.domain.user.CreateUserCommand;
import nl.codecentric.declarationeventservice.domain.user.UpdatePasswordCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final CommandGateway commandGateway;

    public UserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @QueryMapping
    public String hello() {
        return "Hello World";
    }

    @MutationMapping
    public String createUser(@Argument CreateUserCommand command) {
        commandGateway.send(command);
        return "accepted";
    }

    @MutationMapping
    public String updatePassword(@Argument UpdatePasswordCommand command) {
        commandGateway.send(command);
        return "accepted";
    }
}
