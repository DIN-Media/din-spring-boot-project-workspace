package din.norms.dinspringbootprojectworkspace;

import din.norms.dinspringbootprojectworkspace.model.Standard;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Test base class for all tests (unit & integration) in this project.
 */
@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestsBase {
    private final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Sets up the test environment before each test is executed.
     */
    @BeforeEach
    protected void setUp() {
    }

    /**
     * Cleans up the test environment after each test is executed.
     */
    @AfterEach
    protected void cleanup() {
    }

    /**
     * Builds a random standard object.
     *
     * @return a random standard object.
     */
    protected Standard buildRandomStandard() {
        Standard randomStandard = new Standard();
        Random random = new Random();

        randomStandard.setId(random.nextInt(10) + 6);
        randomStandard.setTitle("Standard_" + UUID.randomUUID());
        randomStandard.setDokNr("Standard_" + UUID.randomUUID());
        randomStandard.setIssueDate(dateToTimestampFormattedDate(new Date()));
        randomStandard.setWorkingGrem("Standard_" + UUID.randomUUID());
        randomStandard.setWorkingGremId("Standard_" + UUID.randomUUID());

        return randomStandard;
    }

    /**
     * Builds a list of expected standards.
     *
     * @return a list of expected standards.
     * @throws ParseException if the date string cannot be parsed.
     */
    protected List<Standard> getExpectedStandards() throws ParseException {
        List<Standard> standards = new ArrayList<>();

        standards.add(new Standard(
                1, "Hand-Kegelreibahlen für Kegelstiftbohrungen", "DIN 9", stringToDateParser("1996-12-01"), "NA 121-01-03 AA", "101305013"));
        standards.add(new Standard(
                2, "Vierkante von Zylinderschäften für rotierende Werkzeuge", "DIN 10", stringToDateParser("2009-12-01"), "NA 121-01-04 AA", "54764389"));
        standards.add(new Standard(
                3, "Metrisches ISO-Gewinde allgemeiner Anwendung - Teil 1", "DIN 13-1", stringToDateParser("1999-11-01"), "NA 152-02-01 AA", "129098651"));
        standards.add(new Standard(
                4, "Geometrische Produktspezifikation (GPS)", "ISO 1", stringToDateParser("2022-06-01"), "ISO/TC 213/WG 4", "54772854"));
        standards.add(new Standard(
                5, "Definition einer Erfolgsmethode zum Labelling von Daten zum Training künstlicher Intelligenz", "DIN DKE SPEC 99001", stringToDateParser("2022-05-01"), "", ""));

        return standards;
    }

    /**
     * Parses a date string into a Date object.
     *
     * @param dateString the date string to parse.
     * @return a Date object.
     * @throws ParseException if the date string cannot be parsed.
     */
    protected Date stringToDateParser(String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date parsedDate = simpleDateFormat.parse(dateString);
        return dateToTimestampFormattedDate(parsedDate);
    }

    /**
     * Formats a Date object into a Timestamp object.
     *
     * @param date the date to format.
     * @return a Date object.
     */
    protected Date dateToTimestampFormattedDate(Date date) {
        return new Timestamp(date.getTime());
    }

}
