package din.norms.dinspringbootprojectworkspace;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test base class for all unit tests in this project.
 */
@RequiredArgsConstructor
public class UtBase extends TestsBase {

    /**
     * Sets up the test environment before each test is executed.
     */
    @BeforeEach
    protected void setUp() {
        super.setUp();
    }

    /**
     * Cleans up the test environment after each test is executed.
     */
    @AfterEach
    protected void cleanup() {
        super.cleanup();
    }

}
