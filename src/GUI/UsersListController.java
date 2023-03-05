 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class UsersListController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label userConnecte;
    @FXML
    private VBox offresVB;
    @FXML
    private VBox candidaturesVB;
    @FXML
    private VBox entretiensVB;
    @FXML
    private VBox guidesVB;
    @FXML
    private VBox quizVB;
    @FXML
    private ListView<HBox> userslistview;
    @FXML
    private Label lnom1;
    @FXML
    private Label lprenom1;
    @FXML
    private Label lmail1;
    @FXML
    private Label lrole1;
    @FXML
    private Label ladresse1;
    @FXML
    private Label ltel1;
    @FXML
    private Label ldateNaissance1;
    @FXML
    private Label ldateNaissance11;          
    @FXML
    private ComboBox<String> filterRole;
    @FXML
    private VBox btnajout;
    @FXML
    private Button ajoutAdmin;
    @FXML
    private Button resetbtn;
    @FXML
    private Label ROLE;
    
    private static Role selectedRoleFiltre;  
    public static int selectedUser;
    UtilisateurService us= new UtilisateurService();
    public static List <Utilisateur> utilisateurs;
    RoleService rs = new RoleService();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        if (selectedRoleFiltre ==null){
        utilisateurs = us.fetchUsers();
        } else {
            utilisateurs = us.filtrerByRole(selectedRoleFiltre.getIdRole());
        }
        for (int i=0; i<utilisateurs.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/u.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 GUI.UController uc = fxmlLoader.getController();
                 uc.setData(utilisateurs.get(i));
                 userslistview.getItems().add(hBox);
                 userslistview.setStyle("-fx-control-inner-background:  #0E1947");
             } catch (IOException ex) {
                 Logger.getLogger(UsersListController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        
        for (int i=0; i<rs.fetchRoles().size(); i++){
            filterRole.getItems().add(rs.fetchRoles().get(i).getDescription());
        }
        
        filterRole.setOnAction(e -> {
            selectedRoleFiltre= rs.GetByDescription(filterRole.getValue());
             utilisateurs = us.filtrerByRole(selectedRoleFiltre.getIdRole());
            System.out.println(selectedRoleFiltre);
            try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/UsersList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)filterRole.getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        });
       
    }
    

    @FXML
    private void handleusers(MouseEvent event) {
        selectedUser= userslistview.getSelectionModel().getSelectedIndex();
       
    }

    @FXML
    private void goToAjoutAdmin(ActionEvent event) {
        try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/AjoutAdmin.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void resetlistusers(ActionEvent event) {
     selectedRoleFiltre = null;
     utilisateurs=us.fetchUsers();
     try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/UsersList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToCompte(MouseEvent event) {
    }

    @FXML
    private void goToOffres(MouseEvent event) {
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
    }

    @FXML
    private void goToGuides(MouseEvent event) {
    }

    @FXML
    private void goToRoles(MouseEvent event) {
        try {Parent Login = FXMLLoader.load(getClass().getResource("../GUI/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
