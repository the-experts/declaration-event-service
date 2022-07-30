package nl.codecentric.declarationeventservice.domain.declaration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationRepository extends CrudRepository<Declaration, String> {
}
