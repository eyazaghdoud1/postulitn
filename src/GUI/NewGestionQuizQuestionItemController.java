/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Quiz;
import models.QuizQuestion;
import services.QuizQuestionService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewGestionQuizQuestionItemController implements Initializable {

    @FXML
    private TextArea question;
    @FXML
    private TextField optionA;
    @FXML
    private TextField optionB;
    @FXML
    private ComboBox<String> reponse;
    @FXML
    private TextField optionC;

    String reponseCorrecte;
    @FXML
    private ImageView deleteBtn;
    @FXML
    private Label enregistrerBtn;
    
    QuizQuestionService qqs = new QuizQuestionService();
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
    }    
    public void setData(QuizQuestion qq) {
    if (qq != null ) {    
     question.setText(qq.getQuestion());
     optionA.setText(qq.getOption1());
     optionB.setText(qq.getOption2());
     optionC.setText(qq.getOption3());
     reponse.setValue(qq.getReponse());
    }
    }

    @FXML
    private void delete(MouseEvent event) {
               //QuizQuestion qq = NewGestionQuizController.selectedQuestion ;
               //to reset the page with the modified quiz
               Quiz q =  NewGestionQuizController.gestionSelectedQuiz ;
               
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer cette question?");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 qqs.deleteQuizQuestion(NewGestionQuizController.gestionSelectedQuizQuestion.getId());
                    System.out.println("Supprimée: " + NewGestionQuizController.gestionSelectedQuizQuestion);
                 try {
                      NewGestionQuizController.gestionSelectedQuiz = q; 
                  System.out.println("reload");
                  Parent root = FXMLLoader.load(getClass().getResource("./NewGestionQuiz.fxml"));
                  
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
        
    }

    @FXML
    private void saveUpdate(MouseEvent event) {
      Quiz q =  NewGestionQuizController.gestionSelectedQuiz ;
      if (NewGestionQuizController.gestionSelectedQuizQuestion != null ) {

        QuizQuestion newQ = NewGestionQuizController.gestionSelectedQuizQuestion;
        
        newQ.setQuestion(question.getText());
        newQ.setOption1(optionA.getText());
        newQ.setOption2(optionB.getText());
        System.out.println("B: " + optionB.getText() +"/ option 2 " + newQ.getOption2());
        newQ.setOption3(optionC.getText());
        newQ.setReponse(reponse.getValue());
        newQ.setQuiz(NewGestionQuizController.gestionSelectedQuiz.getId());
       
        System.out.println("saveupdate is working / " + NewGestionQuizController.gestionSelectedQuiz.getId());
        qqs.updateQuizQuestion(NewGestionQuizController.gestionSelectedQuizQuestion.getId(), newQ);
        }
         else {
        QuizQuestion newQuestion = new QuizQuestion();
        newQuestion.setQuestion(question.getText());
        newQuestion.setOption1(optionA.getText());
        newQuestion.setOption2(optionB.getText());
        newQuestion.setOption3(optionC.getText());
        newQuestion.setReponse(reponse.getValue());
        newQuestion.setQuiz(NewGestionQuizController.gestionSelectedQuiz.getId());
        System.out.println("add is working / " + NewGestionQuizController.gestionSelectedQuiz.getId());
        qqs.addQuizQuestion(newQuestion);
        }
        try {
                  NewGestionQuizController.gestionSelectedQuiz = q; 
                  System.out.println("reload");
                  Parent root = FXMLLoader.load(getClass().getResource("./NewGestionQuiz.fxml"));

                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
        
    }
}
