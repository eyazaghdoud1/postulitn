/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Role;
import services.RoleService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class RController implements Initializable {

    @FXML
    private Label lrole;
    @FXML
    private HBox rlayout1;
    @FXML
    private Button modifbtn;
    @FXML
    private Button suppbtn1;
    @FXML
    private TextField fieldmodif;

    RoleService rs = new RoleService();
    List<Role> roles = rs.fetchRoles();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData (Role r){
        
            lrole.setText(r.getDescription());
       
    }

    @FXML
    private void supprimerRole(ActionEvent event) {
        
            Role r = roles.get(RolesListController.selectedRole);
            rs.deleteRole(r);
       try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @FXML
    private void ModifierRole(ActionEvent event) {
        Role r = roles.get(RolesListController.selectedRole);
        r.setDescription(fieldmodif.getText());
        rs.updateRole(r, r.getIdRole());  
        
         try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
