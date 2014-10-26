package session;

import entity.Prisoner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DetaX
 */
@Local
public interface UnderRemandLocal {
    List<Prisoner> get_under_remand();
}
