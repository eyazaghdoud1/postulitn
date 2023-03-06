/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import models.Utilisateur;
import services.AuthenticationService;
import services.MailUtils;
import services.Passwordutils;
import services.UtilisateurService;
import utilities.MaConnexion;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class MdpoublieController implements Initializable {

    @FXML
    private Button btnmodifmdp;

    /**
     * Initializes the controller class.
     */
    Connection cnx = MaConnexion.getInstance().getCnx();
    @FXML
    private Button btnlog;
    @FXML
    private TextField fmail;
    @FXML
    private Label err;
    @FXML
    private Label btnmail;
    @FXML
    private Label lcode;
    @FXML
    private TextField fcode;
    @FXML
    private Label validercode;
    
    UtilisateurService us = new UtilisateurService();
    public static Utilisateur u;
     
     String code = getRandomCode();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void SendCode(ActionEvent event) {
       u=us.GetByEmail(fmail.getText()); 
        if (u.getEmail() != null){
            
            try {
                 MailUtils.SendMail(u.getEmail(), code);
                 err.setText("Le code vous a été envoyé sur votre mail");
                
            } catch (MessagingException ex) {
                Logger.getLogger(MdpoublieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
                err.setText("Vérifiez votre email");
        }
        
    } 
    
     public static String getRandomCode() 
    {
        String code = "0123456789"; 
  
        StringBuilder s = new StringBuilder(4); 
  
        for (int i = 0; i < 4; i++) { 
            int index = (int)(code.length() * Math.random()); 
            s.append(code.charAt(index)); 
        } 
        return s.toString();  
    } 

    @FXML
    private void goToLogin(ActionEvent event) {
         try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SignInCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void ValiderCode(MouseEvent event) {
        
        if (fcode.getText().equalsIgnoreCase(code)){
            try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/Modifmdp.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SignInCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Code non compatible");
            alert.showAndWait();
        }
    
    }
    
}
