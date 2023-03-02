/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Role;
import services.RoleService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class RolesListController implements Initializable {

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
    private ListView<HBox> listviewrole;
    @FXML
    private Button btnrole;
    @FXML
    private TextField roleajoute;

    RoleService rs = new RoleService();
    public static int selectedRole;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           List<Role> roles = rs.fetchRoles();
        for (int i=0; i<roles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../gui/r.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 gui.RController rc = fxmlLoader.getController();
                 rc.setData(roles.get(i));
                 listviewrole.getItems().add(hBox);
             } catch (IOException ex) {
                 Logger.getLogger(gui.Users2Controller.class.getName()).log(Level.SEVERE, null, ex);
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
    private void handlelistroles(MouseEvent event) {
        selectedRole = listviewrole.getSelectionModel().getSelectedIndex();       
    }

    @FXML
    private void AjoutRole(ActionEvent event) {
        try {
            RoleService rs = new RoleService();
            Role r = new Role();
            r.setDescription(roleajoute.getText());
            rs.addRole(r);
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RolesListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
