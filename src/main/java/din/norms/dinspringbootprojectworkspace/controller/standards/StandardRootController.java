package din.norms.dinspringbootprojectworkspace.controller.standards;

import din.norms.dinspringbootprojectworkspace.controller.ApiConstants;
import din.norms.dinspringbootprojectworkspace.service.StandardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * API Root Controller for the Standards table.
 * <p>
 * This root controller is used to expose API endpoints for the Standards table,
 * for operations that do not apply to Items and therefore do not require Ids.
 */
@Validated
@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = ApiConstants.CROSS_ORIGIN_PATH)
public class StandardRootController {
    private static final Logger log = LoggerFactory.getLogger(StandardRootController.class);
    private final StandardService service;

    /**
     * To display the list of Standards.
     *
     * @return template name for the Standards list view.
     */
    @GetMapping(ApiConstants.STANDARDS_ROOT)
    public String listAll(Model model) {
        log.info(":: Fetch all standards in progress...");
        model.addAttribute("standards", service.listAll());
        log.info(":: Standards list fetched!");

        return "standardsView";
    }
}
