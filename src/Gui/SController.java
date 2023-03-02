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
import java.util.List;
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
import javafx.scene.control.TextField;
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
    @FXML
    private TextField secteurInputTF;

     SecteurServices ss = new SecteurServices();
     List<Secteur> secteurs = ss.fetchSecteur();
     
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
   
       Secteur s = secteurs.get(AjouterSecteursController.selectedSecteur);
           // s.setDescription(DescriSecteur.getText());
            ss.deleteSecteurById(s);
       try {Parent root= FXMLLoader.load(getClass().getResource("./AjouterSecteurs.fxml"));
            Scene si = new Scene(root);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   @FXML
    private void ModifierSecteur(ActionEvent event) {
        
         /*   Secteur s = secteurs.get(AjouterSecteursController.selectedSecteur);
        //sSecteur s = new Secteur();
//        Secteur s = ListeSecteurFXMLController.s; // get the existing sector object to update
//s.setDescription(secteurInputTF.getText()); // update the description property with the new value
//ss.UpdateSecteur(s.getIdSecteur(), s); // update the sector in the system
        s.setDescription(secteurInputTF.getText());
        ss.UpdateSecteur(ListeSecteurFXMLController.s.getIdSecteur(),s);          
         Secteur s1 = new Secteur(); 
          try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/ListeSecteurFXML.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
   
       Secteur s = secteurs.get(AjouterSecteursController.selectedSecteur);
           s.setDescription(secteurInputTF.getText());
            ss.UpdateSecteur(s.getIdSecteur(), s);
       try {Parent root= FXMLLoader.load(getClass().getResource("./AjouterSecteurs.fxml"));
            Scene si = new Scene(root);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }}
}
/* @FXML
    private void ModifierRole(ActionEvent event) {
        RoleService rs = new RoleService();
        Role r = RolesController.r;
        r.setDescription(fieldmodif.getText());
        rs.updateRole(r, r.getIdRole());  
        
         try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/Roles.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}*/