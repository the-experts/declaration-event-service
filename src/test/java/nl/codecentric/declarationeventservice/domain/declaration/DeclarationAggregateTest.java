package nl.codecentric.declarationeventservice.domain.declaration;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class DeclarationAggregateTest {
    private FixtureConfiguration<DeclarationAggregate> fixture;

    @BeforeEach
    void setUp() {
        this.fixture = new AggregateTestFixture<>(DeclarationAggregate.class);
    }

    @Test
    void shouldHandleCreateDeclarationCommand() {
        var uuid = UUID.randomUUID();
        fixture.givenNoPriorActivity()
                .when(new CreateDeclarationCommand(uuid))
                .expectEvents(new DeclarationCreatedEvent(uuid));
    }

    @Test
    void shouldHandleSelectDeclarationTypeCommand() {
        var uuid = UUID.randomUUID();
        fixture.given(new DeclarationCreatedEvent(uuid))
                .when(new SelectDeclarationTypeCommand(uuid, DeclarationType.FUEL))
                .expectEvents(new DeclarationTypeSelectedEvent(uuid, DeclarationType.FUEL));
    }
}
