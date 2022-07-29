package nl.codecentric.declarationeventservice.api;

import nl.codecentric.declarationeventservice.domain.declaration.AddDeclarationTaxPercentageCommand;
import nl.codecentric.declarationeventservice.domain.declaration.CreateDeclarationCommand;
import nl.codecentric.declarationeventservice.domain.declaration.SelectDeclarationTypeCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DeclarationController {
    private final CommandGateway commandGateway;

    public DeclarationController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @MutationMapping
    public String createDeclaration(@Argument CreateDeclarationCommand command) {
        commandGateway.send(command);
        return "accepted";
    }

    @MutationMapping
    public String selectDeclarationType(@Argument SelectDeclarationTypeCommand command) {
        commandGateway.send(command);
        return "declaration type accepted";
    }

    @MutationMapping
    public String addDeclarationTaxPercentage(@Argument AddDeclarationTaxPercentageCommand command) {
        commandGateway.send(command);
        return "declaration tax percentage accepted";
    }
}
