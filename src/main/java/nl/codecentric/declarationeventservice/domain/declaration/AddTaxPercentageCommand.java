package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.TaxPercentageType;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


public record AddTaxPercentageCommand(

    @TargetAggregateIdentifier
    String declarationId,

    TaxPercentageType taxPercentageType
) {}
