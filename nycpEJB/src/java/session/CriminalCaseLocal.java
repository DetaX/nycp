package session;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author DetaX
 */
@Remote
public interface CriminalCaseLocal {
    void insert_criminal_case(final String jurisdictionName, final Date date);
}
