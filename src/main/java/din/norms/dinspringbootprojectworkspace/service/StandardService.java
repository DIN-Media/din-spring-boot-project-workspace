package din.norms.dinspringbootprojectworkspace.service;

import din.norms.dinspringbootprojectworkspace.model.Standard;
import din.norms.dinspringbootprojectworkspace.repository.StandardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for the Standards table, for logic implementation that apply to this table.
 */
@Service
@RequiredArgsConstructor
public class StandardService {
    private final StandardRepository repository;

    /**
     * To fetch all Standards from the database.
     * @return List of Standards
     */
    public List<Standard> listAll() {
        return repository.findAll();
    }
}
