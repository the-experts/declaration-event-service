package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserAggregateTest {
    private FixtureConfiguration<UserAggregate> fixture;

    @BeforeEach
    void setUp() {
        this.fixture = new AggregateTestFixture(UserAggregate.class);
    }

    @Test
    void shouldHandleRegisterCustomerCommand() {
        var uuid = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new CreateUserCommand(uuid, "John", "John@codecentric.nl", "password"))
                .expectEvents(new UserCreatedEvent(uuid, "John", "John@codecentric.nl", "password"));
    }
}
