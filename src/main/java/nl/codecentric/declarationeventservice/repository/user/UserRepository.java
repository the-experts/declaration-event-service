package nl.codecentric.declarationeventservice.repository.user;

import nl.codecentric.declarationeventservice.domain.user.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Employee, String> {
}
