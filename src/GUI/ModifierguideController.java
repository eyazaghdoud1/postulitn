/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Compte;
import models.GuideEntretien;
import services.CompteServices;
import services.GuideEntretienService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ModifierguideController implements Initializable {
    @FXML
    private TextField domainetf;
    @FXML
    private TextField specialitetf;
    @FXML
    private TextField supporttf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void boutnmodifierguide(ActionEvent event) {
        
           // GuideEntretienService ges = new GuideEntretienService();
        //date to a string if needed
      //  LocalDate selectedDate = datediplomedp.getValue();
       // String dateString = selectedDate.toString();
//        GuideEntretien ge = new GuideEntretien();
//        ge.setDomaine(domainetf.getText());
//        ge.setSpecialite(specialitetf.getText());
//        ge.setSupport(supporttf.getText());
//       
//      //  ges.updateGuideEntretien(GuideentretienController.compteUser.getIdGuide(),ge);      
//        
//         
//         GuideEntretien ge1 = new GuideEntretien();
//        
    }
    
}
