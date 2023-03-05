/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import models.Utilisateur;
import services.Passwordutils;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class ModifmdpController implements Initializable {

    @FXML
    private Button btnlog;
    @FXML
    private PasswordField nouveaumdp;
    @FXML
    private Button btnnouvmdp;
    @FXML
    private PasswordField nouveaumdp1;

    
    UtilisateurService us = new UtilisateurService();
//    Utilisateur u = new Utilisateur();
       
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToLogin(ActionEvent event) {
    }

    @FXML
    private void modifmdp(ActionEvent event) {
         if (nouveaumdp.getText().equals(nouveaumdp1.getText())){
             
                 us.UpdateMdp(MdpoublieController.u,nouveaumdp.getText());
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setHeaderText(null);
                 alert.setContentText("Mot de passe modifié avec succès !");
                 alert.showAndWait();
                 try {
                 Parent Login = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
                 Scene si = new Scene(Login);
                 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                 st.setScene(si);
                 st.show();
             } catch (IOException ex) {
                 Logger.getLogger(ModifmdpController.class.getName()).log(Level.SEVERE, null, ex);
             }
         } 
         else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Mot de passes non identiques !");
            alert.showAndWait();
         }
    }

    
}
