package nl.codecentric.declarationeventservice.domain.declaration;

import java.util.UUID;

public record DeclarationTaxPercentageAddedEvent(UUID id, Integer taxPercentrage) {
}
