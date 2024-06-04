package din.norms.dinspringbootprojectworkspace.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * Model Entity for the Standards table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STANDARDS")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The title must not be null")
    private String title;

    @Column(name = "dok_nr")
    @NotEmpty(message = "The dokNr must not be null")
    private String dokNr;

    @Column(name = "issue_date", nullable = false)
    @NotEmpty(message = "The issueDate must not be null")
    private Date issueDate;

    @Column(name = "working_grem")
    private String workingGrem;

    @Column(name = "working_grem_id")
    private String workingGremId;
}
