package session;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author DetaX
 */
@Remote
public interface IncarcerationLocal {
    void insert_incarceration(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName, final Date incarcerationDate, final String motive);
}
