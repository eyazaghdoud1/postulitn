/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.QuizQuestion;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewEmptyQuizQuestionController implements Initializable {

    @FXML
    private TextArea question;
    @FXML
    private TextArea optionA;
    @FXML
    private TextArea optionB;
    @FXML
    private TextArea optionC;
    @FXML
    private ComboBox<String> reponse;
    private String reponseCorrecte;
    @FXML
    private Label validerQ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          reponse.getItems().addAll("A", "B", "C");
        // Ajouter un événement de sélection d'élément
        reponse.setOnAction(e -> {
            reponseCorrecte = reponse.getValue();
           
        });
        
        question.setWrapText(true);
        question.setStyle("-fx-background-colore: white");
        optionA.setStyle("-fx-background-colore: white");
        optionB.setStyle("-fx-background-colore: white");
        optionC.setStyle("-fx-background-colore: white");
        
    }    
   
    public QuizQuestion createQuestion() {
     QuizQuestion qq = new QuizQuestion();
     qq.setQuestion(question.getText());
     qq.setOption1(optionA.getText());
     qq.setOption2(optionB.getText());
     qq.setOption3(optionC.getText());
     qq.setReponse(reponseCorrecte);
     return qq;
    }

    @FXML
    private void validerQuestion(MouseEvent event) {
        QuizQuestion q = createQuestion();
        if (q.getQuestion().isEmpty() || q.getOption1().isEmpty() || q.getOption1().isEmpty() ||
                q.getOption2().isEmpty() || q.getOption3().isEmpty() || q.getReponse().isEmpty())
        {
               Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");

               
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);

                alert.getButtonTypes().setAll(buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                
        } else {
            System.out.println(NewAjouterQuizController.selectedNewQuestionIndex);   
        NewAjouterQuizController.newQuestionsList.add(NewAjouterQuizController.selectedNewQuestionIndex, q);
            System.out.println(q);
        validerQ.setDisable(true);
        validerQ.setStyle("-fx-background-color: grey");
        }
    }
    
    
    
}
