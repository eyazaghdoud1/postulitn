/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.Users2Controller.u;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    
    UtilisateurService us= new UtilisateurService();
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
    private ComboBox<Role> filter;
    private Role f;
    RoleService rs = new RoleService();
    
    
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
                 userslistview.getItems().add(hBox);
             } catch (IOException ex) {
                 Logger.getLogger(Users2Controller.class.getName()).log(Level.SEVERE, null, ex);
             }
            
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
    private void handleusers(MouseEvent event) {
    }

//    @FXML
//   private void FiltrerUser(ActionEvent event) {
//    List<Role> roles = rs.fetchRoles(); 
//    for (Role role : roles) {
//        filter.getItems().add(role.getDescription()); // Ajoute la description du rôle
//    }
//    filter.setOnAction(e -> {
//        Role selectedRole = filter.getValue();
//        List<Utilisateur> filteredUsers = us.filtrerByRole(selectedRole.getIdRole());
//        // Faire quelque chose avec la liste d'utilisateurs filtrés
//    });
//}

    @FXML
    private void FiltrerUser(ActionEvent event) {
    }
}
