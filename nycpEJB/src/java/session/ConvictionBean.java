/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Conviction;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author zex
 */
@Stateless(mappedName = "ejb/Conviction")
public class ConvictionBean implements ConvictionLocal {
    
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insert_conviction(String decision_type_number, String prison_file_number, Date date_of_decision, Integer duration) {
        Conviction c = new Conviction(decision_type_number, prison_file_number, date_of_decision);
        c.setDuration(duration);
        _entity_manager.persist(c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
