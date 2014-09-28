package testclient;
import session.PrisonerLocal;
import session.CriminalCaseLocal;
import session.PrisonerCriminalCaseLocal;
import session.IncarcerationLocal;
import java.util.Date;
import javax.ejb.EJB;
import java.util.Calendar;
/**
 *
 * @author DetaX
 */
public class Main {
    public static void main(String[] args) {
        
        try {
            javax.naming.Context jndi_context = new javax.naming.InitialContext();
            PrisonerLocal pm = (PrisonerLocal) jndi_context.lookup("ejb/Prisoner");
            CriminalCaseLocal ccm = (CriminalCaseLocal) jndi_context.lookup("ejb/CriminalCase");
            PrisonerCriminalCaseLocal pccm = (PrisonerCriminalCaseLocal) jndi_context.lookup("ejb/PrisonerCriminalCase");
            IncarcerationLocal im = (IncarcerationLocal) jndi_context.lookup("ejb/Incarceration");
            Date birthDate;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 9);
            cal.set(Calendar.DATE, 24);
            cal.set(Calendar.YEAR, 2013);
            birthDate = cal.getTime();
            //pm.insert_prisoner("Rémi", "Douteaud", birthDate, "Briey");
            //ccm.insert_criminal_case("UPPA", birthDate);
            //pccm.insert_prisoner_criminal_case("1", "0", "UPPA");
            im.insert_incarceration("1", "0", "UPPA", birthDate, "01");
            if (jndi_context != null) {
                jndi_context.close();
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
}
