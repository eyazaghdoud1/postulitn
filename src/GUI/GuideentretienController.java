/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.CompteController.compteUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import models.Compte;
import models.GuideEntretien;
import services.CompteServices;
import services.GuideEntretienService;
  
/**
 * FXML Controller class
 *
 * @author dell
 */
public class GuideentretienController implements Initializable {
    @FXML
    private Text domguide;
    @FXML
    private Text specguide;
    
    public static GuideEntretien guideUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         GuideEntretienService ges = new GuideEntretienService();
         GuideEntretien ge =ges.GetByIdGuideEntretiens(10);
         guideUser= ge; 

         domguide.setText(ge.getDomaine()); 
          specguide.setText(ge.getSpecialite());
    }    
    
}
