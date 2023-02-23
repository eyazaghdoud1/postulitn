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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class ModificationEntretienController implements Initializable {

    @FXML
    private HBox modifVB;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Spinner<?> hourSpinner;
    @FXML
    private Spinner<?> minuteSpinner;
    @FXML
    private TextField lieuTF;
    @FXML
    private Button enregistrerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierEnt(ActionEvent event) {
    }
    
}
