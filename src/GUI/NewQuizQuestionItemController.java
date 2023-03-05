/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewQuizQuestionItemController implements Initializable {

    @FXML
    private Label questionNumber;
    @FXML
    private Text question;
    @FXML
    private RadioButton A;
    @FXML
    private RadioButton B;
    @FXML
    private RadioButton C;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
