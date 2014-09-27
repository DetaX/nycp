package testclient;
import nycpEJB.Prisoner_managementLocal;
/**
 *
 * @author DetaX
 */
public class Main {

    public static void main(String[] args) {
        try {
            javax.naming.Context jndi_context = new javax.naming.InitialContext();
            Prisoner_managementLocal pm = (Prisoner_managementLocal) jndi_context.lookup("ejb/Prisoner_management+");
            pm.insert_prisoner("Rémi", "Douteaud", "16-12-90", "Briey");
            if (jndi_context != null) {
                jndi_context.close();
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
}
