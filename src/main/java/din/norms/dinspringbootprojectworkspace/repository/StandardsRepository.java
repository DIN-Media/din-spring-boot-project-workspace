package din.norms.dinspringbootprojectworkspace.repository;

import din.norms.dinspringbootprojectworkspace.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the Standards table, to manage CRUD operations on this table.
 */
public interface StandardsRepository extends JpaRepository<Standard, Integer> {
}
