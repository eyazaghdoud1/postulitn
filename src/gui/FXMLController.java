/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.AuthInterface;
import interfaces.UtilisateurInterface;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.AuthenticationService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private Button loginbtn;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button btnsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void login (ActionEvent event) {
          AuthInterface as = new AuthenticationService();
//          Utilisateur u = new Utilisateur();
         if (as.authentification(mail.getText(), mdp.getText())){
          try {
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/Users2.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Erreur d'authentification");
            alert.showAndWait();
         }
    }

    @FXML
    private void goToSignIn(ActionEvent event) {
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/SignIn.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
}
