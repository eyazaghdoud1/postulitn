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
    private ListView<HBox> listviewrole;
    @FXML
    private Button btnrole;
    @FXML
    private TextField roleajoute;

    RoleService rs = new RoleService();
    public static int selectedRole;
    List<Role> roles = rs.fetchRoles();
    @FXML
    private VBox TypeOffreVB;
    @FXML
    private VBox usersVB;
    @FXML
    private VBox rolesVB;
    @FXML
    private VBox secteurVB;
    
    
    MenuBarAdminController mbac = new MenuBarAdminController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        for (int i=0; i<roles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/r.fxml"));
             try {
                 HBox hBox = fxmlLoader.load();
                 GUI.RController rc = fxmlLoader.getController();
                 rc.setData(roles.get(i));
                 listviewrole.getItems().add(hBox);
                 listviewrole.setStyle("-fx-control-inner-background:  #0E1947");
             } catch (IOException ex) {
                 Logger.getLogger(GUI.UsersListController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }    

    private void goToOffres(MouseEvent event) {
        mbac.goToOffres(event);
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
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/RolesList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RolesListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToListUsers(MouseEvent event) {
         mbac.goToListUsers(event);
    }

    @FXML
    private void goToTypeOffre(MouseEvent event) {
        mbac.goToTypeOffre(event);
    }

    @FXML
    private void goToListSecteurs(MouseEvent event) {
        mbac.goToListSecteurs(event);
    }

    @FXML
    private void goToListRoles(MouseEvent event) {
        mbac.goToListRoles(event);
    }

    
}
