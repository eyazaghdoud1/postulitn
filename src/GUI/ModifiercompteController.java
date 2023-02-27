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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Compte;
import models.GuideEntretien;
import services.CompteServices;
/**
 * FXML Controller class
 *
 * @author dell
 */
public class ModifiercompteController implements Initializable {
    @FXML
    private TextField experiencetf;
    @FXML
    private TextField phototf;
    @FXML
    private TextField diplometf;
    @FXML
    private TextField cvtf;
    @FXML
    private TextField entreprisetf;
    @FXML
    private DatePicker datediplomedp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     @FXML
    private void boutnmodifiercompte(ActionEvent event) {
           CompteServices cs = new CompteServices();
        //date to a string if needed
        LocalDate selectedDate = datediplomedp.getValue();
        String dateString = selectedDate.toString();
        Compte c = new Compte();
        c.setExperience(experiencetf.getText());
        c.setPhoto(phototf.getText());
        c.setDiplome(diplometf.getText());
        c.setPhoto(phototf.getText());
        c.setCv(cvtf.getText());
        c.setEntreprise(entreprisetf.getText());
        c.setDateDiplome(Date.valueOf(datediplomedp.getValue()));
        cs.updateCompte(CompteController.compteUser.getIdCompte(),c);      
        
         
         Compte c1 = new Compte();
    }

    @FXML
    private void boutnvalidermodd(ActionEvent event) {
    }

    
}