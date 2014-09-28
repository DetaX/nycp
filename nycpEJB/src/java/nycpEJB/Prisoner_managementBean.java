package nycpEJB;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author DetaX
 */
@Stateless(mappedName = "ejb/Prisoner_management", name = "Prisoner_management")
public class Prisoner_managementBean implements Prisoner_managementLocal {
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
        /*Customer client = new Customer(bank_code, customer_PIN);
        client.set_name(name);
        client.set_address(address);
        _entity_manager.persist(client);*/
    }

}
