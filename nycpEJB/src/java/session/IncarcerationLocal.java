package session;
import java.util.Date;
import javax.ejb.Remote;
import javax.ejb.Local;

/**
 *
 * @author DetaX
 */
@Local
public interface IncarcerationLocal {
    void insert_incarceration(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName, final Date incarcerationDate, final String motive);
    void insert_prisoner_criminal_case(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName);
    String insert_criminal_case(final String jurisdictionName, final Date date);
    String insert_prisoner(final String name, final String surname, final Date birthDate, final String birthPlace);
    void incarcerate(final String name, final String surname, final Date birthDate, final String birthPlace, final String jurisdictionName, final Date date, final Date incarcerationDate, final String motive);
}
