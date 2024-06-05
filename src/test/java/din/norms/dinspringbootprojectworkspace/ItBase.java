package din.norms.dinspringbootprojectworkspace;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

/**
 * Test base class for all intégration tests in this project.
 */
@RequiredArgsConstructor
public class ItBase extends TestsBase {
    protected RequestSpecification preLoadedGiven;

    @LocalServerPort
    protected int port;

    /**
     * Sets up the test environment before each test is executed.
     */
    @BeforeEach
    protected void setUp() {
        super.setUp();

        // set the current port to the restAssured instance for the test
        RestAssured.port = port;

        // a given() function pre-loaded with init parameters (token, user, etc.)
        preLoadedGiven = given().contentType(ContentType.JSON);
    }

    /**
     * Cleans up the test environment after each test is executed.
     */
    @AfterEach
    protected void cleanup() {
        super.cleanup();
    }
}
