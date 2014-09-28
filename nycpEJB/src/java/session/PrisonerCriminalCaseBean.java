package session;
import entity.PrisonerCriminalCase;
import javax.ejb.Stateless;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/PrisonerCriminalCase", name = "PrisonerCriminalCase")
public class PrisonerCriminalCaseBean implements PrisonerCriminalCaseLocal {
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insert_prisoner_criminal_case(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName) {
        PrisonerCriminalCase pcc = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);
         _entity_manager.persist(pcc);
    }

}
