/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import static gui.Users2Controller.u;
import static gui.RolesListController.selectedRole;
import static gui.Users2Controller.u;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Role;
import models.Utilisateur;
import services.RoleService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class UController implements Initializable {

    @FXML
    private Label lnom;
    @FXML
    private Label lprenom;
    @FXML
    private Label lmail;
    @FXML
    private Label lrole;
    @FXML
    private Button suppbtn1;
    @FXML
    private Label ladresse;
    @FXML
    private Label ltel;
    @FXML
    private Label ldateNaissance;
    
     UtilisateurService us = new UtilisateurService();
      List<Utilisateur> utilisateurs = us.fetchUsers();
    @FXML
    private Button modifbtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void setData (Utilisateur u){
        
            lnom.setText(u.getNom());
            lprenom.setText(u.getPrenom());
            lmail.setText(u.getEmail());
            lrole.setText(u.getRole().getDescription());
            ladresse.setText(u.getAdresse());
            ltel.setText(u.getTel());
            ldateNaissance.setText(u.getDateNaissance().toString());
            
            
    }

    @FXML
    private void supprimerUtilisateur(ActionEvent event) {
        
            Utilisateur u = utilisateurs.get(UsersListController.selectedUser);
            us.deleteUser(u);
            
       try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/UsersList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ModifierUtilisateur(ActionEvent event) {
        
         try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/Modifuser.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


    
}
