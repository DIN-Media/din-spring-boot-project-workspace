package din.norms.dinspringbootprojectworkspace.controller.standards;

import din.norms.dinspringbootprojectworkspace.controller.ApiConstants;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * API Root Controller for the Standards table.
 * <p>
 * This root controller is used to expose API endpoints for the Standards table,
 * for operations that do not apply to Items and therefore do not require Ids.
 */
@Validated
@RestController
@RequestMapping(ApiConstants.STANDARDS_ROOT)
@CrossOrigin(origins = ApiConstants.CROSS_ORIGIN_PATH)
public class StandardsRootController {
}
