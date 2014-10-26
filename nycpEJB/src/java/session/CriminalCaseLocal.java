package session;

import java.util.Date;
import javax.ejb.Local;
/**
 *
 * @author DetaX
 */
@Local
public interface CriminalCaseLocal {
    public String insert_criminal_case(final String jurisdictionName, final Date date);
}
