/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import services.RoleService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class MenuBarAdminController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private VBox offresVB;
   
    @FXML
    private VBox TypeOffreVB;
    @FXML
    private VBox usersVB;
    @FXML
    private VBox rolesVB;
    
     RoleService rs = new RoleService();

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox secteurVB;
    @FXML
    private ListView<?> listviewrole;
    @FXML
    private Button btnrole;
    @FXML
    private TextField roleajoute;
           
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
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
    }

    @FXML
    private void AjoutRole(ActionEvent event) {
    }


    


    
}
