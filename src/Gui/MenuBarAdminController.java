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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Users
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
    @FXML
    private VBox secteurVB;
    @FXML
    private ListView<?> secteurListView;
    @FXML
    private TextField secteurTF;
    @FXML
    private Label erreurSecteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void handleSecteur(MouseEvent event) {
    }

    @FXML
    private void addSecteur(ActionEvent event) {
    }
    
}
