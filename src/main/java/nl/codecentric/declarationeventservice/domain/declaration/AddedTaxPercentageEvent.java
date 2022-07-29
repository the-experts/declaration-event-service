package nl.codecentric.declarationeventservice.domain.declaration;

import nl.codecentric.declarationeventservice.domain.types.TaxPercentageType;

record AddedTaxPercentageEvent(
        String declarationId,
        TaxPercentageType taxPercentageType
) {}
