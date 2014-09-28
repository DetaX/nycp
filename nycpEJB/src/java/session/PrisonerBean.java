package session;

import entity.Prisoner;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/Prisoner_management", name = "Prisoner_management")
public class PrisonerBean implements PrisonerLocal {
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insert_prisoner(String name, String surname, Date birthDate, String birthPlace) {
        Integer file_number = Integer.valueOf((String)_entity_manager.createQuery("select max(p.prisonFileNumber) from Prisoner p").getSingleResult()) + 1;
        Prisoner prisoner = new Prisoner(file_number.toString());
        prisoner.setGivenName(name);
        prisoner.setSurname(surname);
        prisoner.setDateOfBirth(birthDate);
        prisoner.setPlaceOfBirth(birthPlace);
        _entity_manager.persist(prisoner);
    }

}
