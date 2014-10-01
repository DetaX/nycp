package session;

import entity.Conviction;
import entity.FinalDischarge;
import entity.JudicialDecision;
import entity.ShortenedSentence;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author zex
 */
@Stateless(mappedName = "ejb/JudicialDecision")
public class JudicialDecisionBean implements JudicialDecisionLocal {

    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    private static final String CONVICTION = "1";
    private static final String SHORTENED_SENTENCE = "2";
    private static final String FINAL_DISCHARGE = "3";
    
    @Override
    public void insert_judicial_decision(String decision_type_number, Date date_of_decision, String prison_file_number) {
        JudicialDecision jd = new JudicialDecision(decision_type_number, prison_file_number, date_of_decision);
        _entity_manager.persist(jd);
    }
    
    @Override
    public void insert_shortened_sentence(String prison_file_number, Date date_of_decision, Integer duration) {
        insert_judicial_decision(SHORTENED_SENTENCE,date_of_decision,prison_file_number);
        ShortenedSentence ss = new ShortenedSentence(SHORTENED_SENTENCE, prison_file_number, date_of_decision);
        ss.setDuration(duration);
        _entity_manager.persist(ss);
    }
    
    @Override
    public void insert_final_discharge(String prison_file_number, Date date_of_decision, Date date_of_final_discharge) {
        insert_judicial_decision(FINAL_DISCHARGE,date_of_decision,prison_file_number);
        FinalDischarge fd = new FinalDischarge(FINAL_DISCHARGE, prison_file_number, date_of_decision);
        fd.setDateOfFinalDischarge(date_of_final_discharge);
        _entity_manager.persist(fd);
    }
    
    @Override
    public void insert_conviction(String prison_file_number, Date date_of_decision, Integer duration) {
        insert_judicial_decision(CONVICTION,date_of_decision,prison_file_number);
        Conviction c = new Conviction(CONVICTION, prison_file_number, date_of_decision);
        c.setDuration(duration);
        _entity_manager.persist(c);
    }

}
