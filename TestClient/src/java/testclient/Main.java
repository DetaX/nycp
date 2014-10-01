package testclient;
import session.IncarcerationLocal;
import java.util.Date;
import java.util.Calendar;
import session.JudicialDecisionLocal;
/**
 *
 * @author DetaX
 */
public class Main {
    public static void main(String[] args) {
        
        try {
            javax.naming.Context jndi_context = new javax.naming.InitialContext();
            IncarcerationLocal im = (IncarcerationLocal) jndi_context.lookup("ejb/Incarceration");
            JudicialDecisionLocal jdm = (JudicialDecisionLocal) jndi_context.lookup("ejb/JudicialDecision");
            Date birthDate;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 8);
            cal.set(Calendar.DATE, 30);
            cal.set(Calendar.YEAR, 2014);
            birthDate = cal.getTime();
            //im.incarcerate("Pierre", "Caretero", birthDate, "Talence", "UPPA", birthDate, birthDate, "01");
            jdm.insert_final_discharge("0", birthDate, birthDate);
            if (jndi_context != null) {
                jndi_context.close();
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
}
