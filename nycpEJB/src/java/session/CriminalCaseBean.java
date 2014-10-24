package session;

import entity.CriminalCase;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/CriminalCase", name = "CriminalCase")
public class CriminalCaseBean implements CriminalCaseLocal {
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
        
    @Override
    public String insert_criminal_case(String jurisdictionName, Date date) {
        String _query = (String)_entity_manager.createQuery("select max(c.criminalCasePK.criminalCaseNumber) from CriminalCase c").getSingleResult();
        Integer case_number = (_query == null) ? 0 : Integer.valueOf(_query) + 1;
        CriminalCase cc = new CriminalCase(case_number.toString(), jurisdictionName);
        cc.setDateOfCriminalCase(date);
        _entity_manager.persist(cc);
        return case_number.toString();
    }
}
