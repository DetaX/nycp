/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
//import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author zex
 */
@Remote
public interface JudicialDecisionBeanLocal {
    public void insert_judicial_decision(String decision_type_number, Date date_of_decision, String prison_file_number);
}
