package nl.codecentric.declarationeventservice.api;

import nl.codecentric.declarationeventservice.domain.declaration.CreateDeclarationCommand;
import nl.codecentric.declarationeventservice.domain.declaration.Declaration;
import nl.codecentric.declarationeventservice.domain.declaration.DeclarationRepository;
import nl.codecentric.declarationeventservice.domain.declaration.SelectDeclarationTypeCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DeclarationController {
    private final DeclarationRepository declarationRepository;
    private final CommandGateway commandGateway;

    public DeclarationController(DeclarationRepository declarationRepository, CommandGateway commandGateway) {
        this.declarationRepository = declarationRepository;
        this.commandGateway = commandGateway;
    }

    @QueryMapping
    public Declaration declaration(@Argument String id) {
        return declarationRepository.findById(id).get();
    }

    @MutationMapping
    public String createDeclaration(@Argument CreateDeclarationCommand command) {
        commandGateway.sendAndWait(command);
        return "accepted";
    }

    @MutationMapping
    public String selectDeclarationType(@Argument SelectDeclarationTypeCommand command) {
        commandGateway.sendAndWait(command);
        return "accepted";
    }
}
