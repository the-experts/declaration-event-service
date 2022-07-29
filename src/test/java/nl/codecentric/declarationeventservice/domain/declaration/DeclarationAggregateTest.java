package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class DeclarationAggregateTest {
    private FixtureConfiguration<DeclarationAggregate> fixture;

    @BeforeEach
    void setUp() {
        this.fixture = new AggregateTestFixture(DeclarationAggregate.class);
    }

    @Test
    void shouldHandleCreateDeclarationCommand() {
        var uuid = UUID.randomUUID();
        var employeeId = UUID.randomUUID();
        fixture.givenNoPriorActivity()
                .when(new CreateDeclarationCommand(uuid, employeeId))
                .expectEvents(new DecarationCreatedEvent(uuid, employeeId));
    }

    @Test
    void shouldHandleSelectDeclarationTypeCommand() {
        var declarationId = UUID.randomUUID();
        fixture.given(new DecarationCreatedEvent(declarationId, UUID.randomUUID()))
                .when(new SelectDeclarationTypeCommand(declarationId, DeclarationType.ITEM))
                .expectEvents(new DeclarationTypeSelectedEvent(declarationId, DeclarationType.ITEM));
    }
}
