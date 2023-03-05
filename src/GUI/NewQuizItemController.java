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
public class NewQuizItemController implements Initializable {

    private Label nbQuestions;
    private Label quizSpecialite;
    @FXML
    private Label nom;
    @FXML
    private Label specialite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Quiz q) {
       specialite.setText(q.getSpecialite());
       nom.setText(q.getNom() + " quiz");
    }
    
}
