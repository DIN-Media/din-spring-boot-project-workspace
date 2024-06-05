package din.norms.dinspringbootprojectworkspace.service;

import din.norms.dinspringbootprojectworkspace.UtBase;
import din.norms.dinspringbootprojectworkspace.model.Standard;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Test suite for the StandardService class, which provides functionality for managing standards.
 * This test suite actually verifies the behavior of the listAll() method, which returns a list of all standards.
 */
@RequiredArgsConstructor
public class StandardServiceTest extends UtBase {
    @Autowired
    private StandardService service;

    /**
     * Sets up the test environment before each test is executed.
     */
    @BeforeEach
    public void setUp() {
        super.setUp();
        openMocks(this);
    }

    /**
     * Cleans up the test environment after each test is executed.
     */
    @AfterEach
    public void cleanup() {
        super.cleanup();
    }


    /**
     * Tests that the listAll() method returns a non-empty list of standards.
     */
    @Test
    void listAll_ShouldReturnNotEmptyList() {
        // When
        List<Standard> actualStandards = service.listAll();

        // Then
        assertEquals(5, actualStandards.size());
        assertTrue(actualStandards.get(0).getId() != 0);
        assertTrue(actualStandards.get(1).getId() != 0);
        assertTrue(actualStandards.get(2).getId() != 0);
        assertTrue(actualStandards.get(3).getId() != 0);
        assertTrue(actualStandards.get(4).getId() != 0);
    }

    /**
     * Tests that the listAll() method returns a list of standards that matches the expected list of standards.
     *
     * @throws ParseException if there is an error parsing the standard data
     */
    @Test
    void listAll_ShouldReturnAllStandards() throws ParseException {
        // Given
        List<Standard> expectedStandards = getExpectedStandards();

        // When
        List<Standard> actualStandards = service.listAll();

        // Then
        assertEquals(expectedStandards.size(), actualStandards.size());

        assertEquals(expectedStandards.get(0).getId(), actualStandards.get(0).getId());
        assertEquals(expectedStandards.get(1).getId(), actualStandards.get(1).getId());
        assertEquals(expectedStandards.get(2).getId(), actualStandards.get(2).getId());
        assertEquals(expectedStandards.get(3).getId(), actualStandards.get(3).getId());
        assertEquals(expectedStandards.get(4).getId(), actualStandards.get(4).getId());

        assertEquals(expectedStandards.get(2).getTitle(), actualStandards.get(2).getTitle());
        assertEquals(expectedStandards.get(2).getDokNr(), actualStandards.get(2).getDokNr());
        assertEquals(expectedStandards.get(2).getIssueDate(), actualStandards.get(2).getIssueDate());
        assertEquals(expectedStandards.get(2).getWorkingGrem(), actualStandards.get(2).getWorkingGrem());
        assertEquals(expectedStandards.get(2).getWorkingGremId(), actualStandards.get(2).getWorkingGremId());
    }

    /**
     * Tests that the listAll() method does not include a randomly generated standard in the list of returned standards.
     */
    @Test
    void testListAll_StandardItemNotIncludedInActualStandardsList() {
        // Given
        Standard randomStandard = buildRandomStandard();

        // When
        List<Standard> actualStandards = service.listAll();

        // Then
        assertEquals(5, actualStandards.size());

        List<Integer> actualStandardIds = actualStandards.stream().map(Standard::getId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(5, actualStandardIds.size());
        assertFalse(actualStandardIds.contains(randomStandard.getId()));

        assertNotEquals(randomStandard.getTitle(), actualStandards.get(0).getTitle());
        assertNotEquals(randomStandard.getDokNr(), actualStandards.get(0).getDokNr());
        assertNotEquals(randomStandard.getIssueDate(), actualStandards.get(0).getIssueDate());
        assertNotEquals(randomStandard.getWorkingGrem(), actualStandards.get(0).getWorkingGrem());
        assertNotEquals(randomStandard.getWorkingGremId(), actualStandards.get(0).getWorkingGremId());
    }
}
