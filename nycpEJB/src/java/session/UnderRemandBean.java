package session;

import entity.Prisoner;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/UnderRemand")
public class UnderRemandBean implements UnderRemandLocal {
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public List<Prisoner> get_under_remand() {
        TypedQuery<Prisoner> query = _entity_manager.createQuery("SELECT p FROM Prisoner p WHERE p.prisonFileNumber NOT IN (SELECT c.convictionPK.prisonFileNumber FROM Conviction c)", Prisoner.class);
        List<Prisoner> results = query.getResultList();
        return results;
    }
}
