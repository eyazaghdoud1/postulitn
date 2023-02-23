/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import Models.Secteur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.SecteurServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class SController implements Initializable {

    @FXML
    private HBox Shbox;
    @FXML
    private Label DescriSecteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    
    
    
    public void setData(Secteur s){
            DescriSecteur.setText(s.getDescription()); 
    }
    
    
    
@FXML
    private void supprimerSecteur(ActionEvent event) {
       
            SecteurServices ss = new SecteurServices();
        Secteur s = ListeSecteurFXMLController.s;
            s.setDescription(DescriSecteur.getText());
            ss.deleteSecteurById(s);
       try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/ListeSecteurFXML.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   @FXML
    private void ModifierSecteur(ActionEvent event) {
            SecteurServices ss = new SecteurServices();
       //     Secteur s = ListeSecteurFXMLController.s;
        Secteur s = new Secteur();
        s.setDescription(DescriSecteur.getText());
        ss.UpdateSecteur(ListeSecteurFXMLController.s.getIdSecteur(),s);          
         Secteur s1 = new Secteur(); 
        
    }
   
    
}
