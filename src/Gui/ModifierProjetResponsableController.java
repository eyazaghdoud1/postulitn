/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ModifierProjetResponsableController implements Initializable {

    @FXML
    private TextField themeTF;
    @FXML
    private TextField dureeTF;
    @FXML
    private DatePicker datedebutDP;
    @FXML
    private DatePicker datefinDP;
    @FXML
    private TextField descriptionTF;
    @FXML
    private ComboBox<?> secteurCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierProjet(ActionEvent event) {
    
//        int Duree = Integer.parseInt(dureeTF.getText());
//        String Theme = themeTF.getText(); 
//        String Description = descriptionTF.getText(); 
//        UpdateProjet();
    }
    
}
