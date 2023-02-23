/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Utilisateur;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class Users2Controller implements Initializable {

    

    UtilisateurService us = new UtilisateurService();
    @FXML
    private VBox userlayout;
    @FXML
    private Button btnrole;
            
    public String f;
    public static Utilisateur u;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List <Utilisateur> utilisateurs = us.fetchUsers();
        
        for (int i=0; i<utilisateurs.size();i++){
            u=utilisateurs.get(i);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../gui/u.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 UController uc = fxmlLoader.getController();
                 uc.setData(utilisateurs.get(i));
                 userlayout.getChildren().add(hBox);
             } catch (IOException ex) {
                 Logger.getLogger(Users2Controller.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }    



    @FXML
    private void GoToPageRoles(ActionEvent event) {
         try {
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/Roles.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
           
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

        
     
        
        
        
    

}
