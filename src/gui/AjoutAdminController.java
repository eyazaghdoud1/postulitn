/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import static gui.RolesController.r;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class AjoutAdminController implements Initializable {

    @FXML
    private Button btnajadmin;
    @FXML
    private TextField nomadmin;
    @FXML
    private TextField prenomadmin;
    @FXML
    private TextField emailadmin;

     UtilisateurService us = new UtilisateurService();
     public static Utilisateur u;
    @FXML
    private Button previousbtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Utilisateur> users = us.fetchUsers();
         for (int i=0; i<users.size();i++){
            u=users.get(i);
         }}    

    @FXML
    private void previous(ActionEvent event) {
    Parent Login;
        try {
            Login = FXMLLoader.load(getClass().getResource("../gui/users2.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SignInCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
//    @FXML
//    private void AjoutAdmin(ActionEvent event) {
//       
//                u.setNom(nomadmin.getText());
//                u.setPrenom(prenomadmin.getText());
//                u.setEmail(emailadmin.getText());
//                u.setRole(r);
//                us.addUser(u);
//       
//                try { 
//                Parent Login = FXMLLoader.load(getClass().getResource("../gui/users2.fxml"));
//                Scene si = new Scene(Login);
//                Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
//                st.setScene(si);
//                st.show();
//            } catch (IOException ex) {
//                Logger.getLogger(AjoutAdminController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//    }

    }

    


