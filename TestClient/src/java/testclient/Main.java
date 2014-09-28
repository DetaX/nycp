package testclient;
import nycpEJB.Prisoner_managementLocal;
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
            Prisoner_managementLocal pm = (Prisoner_managementLocal) jndi_context.lookup("ejb/Prisoner_management");
            Date birthDate;
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 9);
            cal.set(Calendar.DATE, 24);
            cal.set(Calendar.YEAR, 2013);
            birthDate = cal.getTime();
            pm.insert_prisoner("Rémi", "Douteaud", birthDate, "Briey");
            if (jndi_context != null) {
                jndi_context.close();
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
}
