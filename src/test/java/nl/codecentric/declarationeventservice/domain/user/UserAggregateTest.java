package nl.codecentric.declarationeventservice.domain.user;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;


class UserAggregateTest {
    private FixtureConfiguration<UserAggregate> fixture;

    @BeforeEach
    void setUp() {
        this.fixture = new AggregateTestFixture(UserAggregate.class);
    }

    @Test
    void shouldHandleRegisterCustomerCommand() {
        var uuid = UUID.randomUUID();
        fixture.givenNoPriorActivity()
                .when(new CreateUserCommand(uuid, "John", "John@codecentric.nl", "password"))
                .expectEvents(new UserCreatedEvent(uuid, "John", "John@codecentric.nl", "password"));
    }

    @Test
    void itShouldFail() {
        var uuid = UUID.randomUUID();
        fixture.given(new UserCreatedEvent(uuid, "John", "John@codecentric.nl", "password"))
                .when(new UpdatePasswordCommand(uuid, "otherPassword"))
                .expectEvents(new PasswordChangedEvent(uuid, "otherPassword"));
    }
}