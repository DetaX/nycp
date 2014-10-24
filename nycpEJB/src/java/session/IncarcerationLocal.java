package session;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author DetaX
 */
@Local
public interface IncarcerationLocal {
    void incarcerate(final String name, final String surname, final Date birthDate, final String birthPlace, final String jurisdictionName, final Date date, final Date incarcerationDate, final String motive);
    void insert_motive(final String label);
}
