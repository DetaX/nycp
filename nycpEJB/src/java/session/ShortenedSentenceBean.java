/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
import javax.ejb.Stateless;
import entity.ShortenedSentence;

/**
 *
 * @author zex
 */
@Stateless(mappedName = "ejb/ShortenedSentence")
public class ShortenedSentenceBean implements ShortenedSentenceLocal {

    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insert_shortened_sentence(String decision_type_number, String prison_file_number, Date date_of_decision, Integer duration) {
        ShortenedSentence ss = new ShortenedSentence(decision_type_number, prison_file_number, date_of_decision);
        ss.setDuration(duration);
        _entity_manager.persist(ss);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
