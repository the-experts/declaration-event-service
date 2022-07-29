package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.DeclarationType;
import nl.codecentric.declarationeventservice.domain.types.TaxPercentageType;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static nl.codecentric.declarationeventservice.domain.types.DeclarationType.FUEL;

class DeclarationAggregateTest {
    private FixtureConfiguration<DeclarationAggregate> fixture;

    @BeforeEach
    void setUp() {
        this.fixture = new AggregateTestFixture(DeclarationAggregate.class);
    }

    @Test
    void shouldHandleCreateDeclarationCommand() {
        var uuid = UUID.randomUUID().toString();
        var employeeId = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new CreateDeclarationCommand(uuid, employeeId))
                .expectEvents(new DecarationCreatedEvent(uuid, employeeId));
    }

    @Test
    void shouldHandleAddTaxPercentageCommand() {
        var uuid = UUID.randomUUID().toString();
        var declarationId = UUID.randomUUID().toString();
        var employeeId = UUID.randomUUID().toString();
        fixture.given(List.of(new DecarationCreatedEvent(declarationId, employeeId), new DeclarationTypeSelectedEvent(declarationId, FUEL)))
                .when(new AddTaxPercentageCommand(declarationId, TaxPercentageType.LOW))
                .expectEvents(new AddedTaxPercentageEvent(declarationId, TaxPercentageType.LOW));
    }

    @Test
    void shouldHandleSelectDeclarationTypeCommand() {
        var declarationId = UUID.randomUUID().toString();
        fixture.given(new DecarationCreatedEvent(declarationId, UUID.randomUUID().toString()))
                .when(new SelectDeclarationTypeCommand(declarationId, DeclarationType.ITEM))
                .expectEvents(new DeclarationTypeSelectedEvent(declarationId, DeclarationType.ITEM));
    }
}
