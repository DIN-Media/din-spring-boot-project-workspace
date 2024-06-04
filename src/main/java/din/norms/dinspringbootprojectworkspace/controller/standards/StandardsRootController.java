package din.norms.dinspringbootprojectworkspace.controller.standards;

import org.slf4j.*;
import din.norms.dinspringbootprojectworkspace.controller.ApiConstants;
import din.norms.dinspringbootprojectworkspace.model.Standard;
import din.norms.dinspringbootprojectworkspace.service.StandardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * API Root Controller for the Standards table.
 * <p>
 * This root controller is used to expose API endpoints for the Standards table,
 * for operations that do not apply to Items and therefore do not require Ids.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.STANDARDS_ROOT)
@CrossOrigin(origins = ApiConstants.CROSS_ORIGIN_PATH)
public class StandardsRootController {
    private static final Logger log = LoggerFactory.getLogger(StandardsRootController.class);
    private final StandardsService service;

    /**
     * To fetch all Standards from the database.
     * @return List of Standards
     */
    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(method = RequestMethod.GET)
    public List<Standard> listAll() {
        log.info("Fetch all standards in progress...");
        List<Standard> standards = service.listAll();
        log.info("Standards list fetched!");

        return standards;
    }
}
