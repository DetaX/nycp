package session;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author DetaX
 */
@Remote
public interface PrisonerCriminalCaseLocal {
    void insert_prisoner_criminal_case(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName);
}
