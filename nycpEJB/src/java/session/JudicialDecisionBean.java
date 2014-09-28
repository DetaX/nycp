/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.JudicialDecision;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author zex
 */
@Stateless(mappedName = "ejb/JudicialDecision")
public class JudicialDecisionBean implements JudicialDecisionBeanLocal {

    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insert_judicial_decision(String decision_type_number, Date date_of_decision, String prison_file_number) {
        JudicialDecision jd = new JudicialDecision(decision_type_number, prison_file_number, date_of_decision);
        _entity_manager.persist(jd);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
