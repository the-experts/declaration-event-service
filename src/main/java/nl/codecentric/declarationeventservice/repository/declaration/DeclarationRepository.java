package nl.codecentric.declarationeventservice.repository.declaration;

import nl.codecentric.declarationeventservice.domain.declaration.Declaration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationRepository extends CrudRepository<Declaration, String> {
}
