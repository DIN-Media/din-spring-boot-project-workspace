package din.norms.dinspringbootprojectworkspace.controller;

import din.norms.dinspringbootprojectworkspace.ItBase;
import din.norms.dinspringbootprojectworkspace.model.Standard;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * Integration-Test suite for the API-Controller class, which provides functionality for managing standards.
 * This test suite actually verifies the behavior of the listAll() API-Method, which returns a list of all standards.
 */
@RequiredArgsConstructor
public class StandardControllerIT extends ItBase {
    /**
     * Sets up the test environment before each test is executed.
     */
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    /**
     * Cleans up the test environment after each test is executed.
     */
    @AfterEach
    public void cleanup() {
        super.cleanup();
    }


    /**
     * Tests that the listAll() API-Method returns a non-empty list of standards.
     */
    @Test
    void listAll_ShouldReturnNotEmptyList() {
        preLoadedGiven
                .log().all()
                .get(ApiConstants.STANDARDS_ROOT)
                .then()
                .log().body()
                .statusCode(200)
                .body("size()", is(equalTo(5)))
        ;

    }

    /**
     * Tests that the listAll() API-Method returns a list of standards that matches the expected list of standards.
     *
     * @throws ParseException if there is an error parsing the standard data
     */
    @Test
    void listAll_ShouldReturnAllStandards() throws ParseException {
        // Given
        List<Standard> expectedStandards = getExpectedStandards();
        List<Integer> expectedIds = expectedStandards.stream().map(Standard::getId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> expectedTitles = expectedStandards.stream().map(Standard::getTitle).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> expectedDokNrs = expectedStandards.stream().map(Standard::getDokNr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> expectedWorkingGrems = expectedStandards.stream().map(Standard::getWorkingGrem).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<String> expectedWorkingGremIds = expectedStandards.stream().map(Standard::getWorkingGremId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // When
        preLoadedGiven
                .log().all()
                .get(ApiConstants.STANDARDS_ROOT)
                .then()
                .log().body()
                .statusCode(200)
                .body("size()", is(equalTo(5)))
                .body("id", containsInAnyOrder(expectedIds.get(0), expectedIds.get(1), expectedIds.get(2), expectedIds.get(3), expectedIds.get(4)))
                .body("title", containsInAnyOrder(expectedTitles.get(0), expectedTitles.get(1), expectedTitles.get(2), expectedTitles.get(3), expectedTitles.get(4)))
                .body("dokNr", containsInAnyOrder(expectedDokNrs.get(0), expectedDokNrs.get(1), expectedDokNrs.get(2), expectedDokNrs.get(3), expectedDokNrs.get(4)))
                .body("workingGrem", containsInAnyOrder(expectedWorkingGrems.get(0), expectedWorkingGrems.get(1), expectedWorkingGrems.get(2), expectedWorkingGrems.get(3), expectedWorkingGrems.get(4)))
                .body("workingGremId", containsInAnyOrder(expectedWorkingGremIds.get(0), expectedWorkingGremIds.get(1), expectedWorkingGremIds.get(2), expectedWorkingGremIds.get(3), expectedWorkingGremIds.get(4)))
        ;
    }

    /**
     * Tests that the listAll() API-Method does not include a randomly generated standard in the list of returned standards.
     */
    @Test
    void testListAll_StandardItemNotIncludedInActualStandardsList() {
        // Given
        Standard randomStandard = buildRandomStandard();

        // When
        preLoadedGiven
                .log().all()
                .get(ApiConstants.STANDARDS_ROOT)
                .then()
                .log().body()
                .statusCode(200)
                .body("size()", is(equalTo(5)))
                .body("id", not(contains(randomStandard.getId())))
                .body("title", not(contains(randomStandard.getTitle())))
                .body("dokNr", not(contains(randomStandard.getDokNr())))
                .body("workingGrem", not(contains(randomStandard.getWorkingGrem())))
                .body("workingGremId", not(contains(randomStandard.getWorkingGremId())))
        ;
    }

    /**
     * Tests that the listAll() API-Method returns the list of standards sorted by issue date in descending order.
     */
    @Test
    void testListAll_StandardsListSortedByIssueDateDesc() throws ParseException {
        // Given
        List<Standard> sortedExpectedStandards = getExpectedStandardsSortedByIssueDateDesc();
        List<Integer> expectedSortedIds = sortedExpectedStandards.stream().map(Standard::getId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // When
        preLoadedGiven
                .log().all()
                .get(ApiConstants.STANDARDS_ROOT)
                .then()
                .log().body()
                .statusCode(200)
                .body("size()", is(equalTo(sortedExpectedStandards.size())))
                .body("id", is(equalTo(expectedSortedIds)))
        ;
    }
}
