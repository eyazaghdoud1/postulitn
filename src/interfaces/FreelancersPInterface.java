
package interfaces;

import java.util.List;
import models.FreelancersP;
import models.Utilisateur;

/**
 *
 * @author ezine
 */
public interface FreelancersPInterface {
    
    //add
    public void addAffectation(FreelancersP fp);
 
    //delete
    public void deleteAffectation (FreelancersP fp);

    
    //filterbyprojet
    public List<Utilisateur> fetchfreelancers(int idProjet);
    
   //filterbyuser
   
    
}
