package session;
import entity.Incarceration;
import entity.Motive;
import entity.PrisonerCriminalCase;
import entity.Prisoner;
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
            
    private void insert_incarceration(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName, Date incarcerationDate, String motive) {
        Incarceration i = new Incarceration(prisonFileNumber);
        Motive m = new Motive(motive);
        PrisonerCriminalCase pcc = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);
        i.setDateOfIncarceration(incarcerationDate);
        i.setMotiveNumber(m);
        i.setPrisonerCriminalCase(pcc);
         _entity_manager.persist(i);
    }

    private void insert_prisoner_criminal_case(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName) {
        PrisonerCriminalCase pcc = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);
         _entity_manager.persist(pcc);
    }
    
    private String insert_prisoner(String name, String surname, Date birthDate, String birthPlace) {
        String _query = (String)_entity_manager.createQuery("select max(p.prisonFileNumber) from Prisoner p").getSingleResult();
        Integer file_number = (_query == null) ? 0 : Integer.valueOf(_query) + 1;
        Prisoner prisoner = new Prisoner(file_number.toString());
        prisoner.setGivenName(name);
        prisoner.setSurname(surname);
        prisoner.setDateOfBirth(birthDate);
        prisoner.setPlaceOfBirth(birthPlace);
        _entity_manager.persist(prisoner);
        return file_number.toString();
    }

    @Override
    public void incarcerate(String name, String surname, Date birthDate, String birthPlace, String jurisdictionName, Date date, Date incarcerationDate, String motive) {
        try {
       javax.naming.Context jndi_context = new javax.naming.InitialContext();
       CriminalCaseLocal ccm = (CriminalCaseLocal) jndi_context.lookup("ejb/CriminalCase");
       String file_number = insert_prisoner(name,surname,birthDate,birthPlace);
       String case_number = ccm.insert_criminal_case(jurisdictionName, date);
       insert_prisoner_criminal_case(file_number,case_number,jurisdictionName);
       insert_incarceration(file_number,case_number,jurisdictionName,incarcerationDate,motive);
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
       
    }

    @Override
    public void insert_motive(String label) {
        String _query = (String)_entity_manager.createQuery("select max(m.motiveNumber) from Motive m").getSingleResult();
        Integer motive_number = (_query == null) ? 0 : Integer.valueOf(_query) + 1;
        Motive m = new Motive(motive_number.toString());
        m.setMotiveLabel(label);
        _entity_manager.persist(m);
    }

}
