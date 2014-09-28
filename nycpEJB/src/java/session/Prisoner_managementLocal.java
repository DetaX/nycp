package session;

import javax.ejb.Remote;
import java.util.Date;

/**
 *
 * @author DetaX
 */
@Remote
public interface Prisoner_managementLocal {
    void insert_prisoner(final String name, final String surname, final Date birthDate, final String birthPlace);
    
}
