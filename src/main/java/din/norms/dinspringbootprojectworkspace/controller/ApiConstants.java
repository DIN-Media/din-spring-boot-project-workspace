package din.norms.dinspringbootprojectworkspace.controller;

/**
 * API Constants for the all the API endpoints in this project.
 */
public class ApiConstants {
    // API
    public static final String API = "api";

    // Cross-Origin: to allow other domains to access the API (actually are all domains allowed because of the "*")
    public static final String CROSS_ORIGIN_PATH = "*";

    // Standards:
    public static final String STANDARDS_ROOT = API + "/standards";
    public static final String STANDARD_ITEM = STANDARDS_ROOT + "/{standardsId}";
}
