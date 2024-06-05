package din.norms.dinspringbootprojectworkspace.repository;

import din.norms.dinspringbootprojectworkspace.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for the Standards table, to manage CRUD operations on this table.
 */
public interface StandardRepository extends JpaRepository<Standard, Integer> {
    List<Standard> findAllByOrderByIssueDateDesc();
}
