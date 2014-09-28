package session;
import entity.Incarceration;
import entity.Motive;
import entity.PrisonerCriminalCase;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/Incarceration", name = "Incarceration")
public class IncarcerationBean implements IncarcerationLocal {
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insert_incarceration(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName, Date incarcerationDate, String motive) {
        Incarceration i = new Incarceration(prisonFileNumber);
        Motive m = new Motive(motive);
        PrisonerCriminalCase pcc = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);
        i.setDateOfIncarceration(incarcerationDate);
        i.setMotiveNumber(m);
        i.setPrisonerCriminalCase(pcc);
         _entity_manager.persist(i);
    }


}
