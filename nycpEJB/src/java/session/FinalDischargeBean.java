/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
import javax.ejb.Stateless;
import entity.FinalDischarge;

/**
 *
 * @author zex
 */
@Stateless(mappedName = "ejb/FinalDischarge")
public class FinalDischargeBean implements FinalDischargeLocal {

    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insert_final_discharge(String decision_type_number, String prison_file_number, Date date_of_decision, Date date_of_final_discharge) {
        FinalDischarge fd = new FinalDischarge(decision_type_number, prison_file_number, date_of_decision);
        fd.setDateOfFinalDischarge(date_of_final_discharge);
        _entity_manager.persist(fd);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
