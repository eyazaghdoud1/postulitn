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
import models.Quiz;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewGestionQuizItemController implements Initializable {


    @FXML
    private Label nomQuiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Quiz q) {
 
       nomQuiz.setText(q.getSpecialite() + " quiz");
    }
    
}
