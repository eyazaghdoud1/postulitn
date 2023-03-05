/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Quiz;
import models.QuizQuestion;
import services.QuizQuestionService;
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewAjouterQuizController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private ImageView userPhoto;
    @FXML
    private VBox offresVB;
    @FXML
    private VBox candidaturesVB;
    @FXML
    private VBox entretiensVB;
    @FXML
    private VBox guidesVB;
    @FXML
    private VBox quizVB;
    @FXML
    private VBox gestionVB;
    @FXML
    private Label actionLabel;
    @FXML
    private TextField nomQuiz;
    @FXML
    private Button addQuizBtn;
    @FXML
    private TextArea secteur;
    @FXML
    private TextArea specialite;
    @FXML
    private ListView<HBox> questionsListView;
    @FXML
    private Button backBtn;

    public static int selectedNewQuestionIndex;
    public static List<QuizQuestion> newQuestionsList = new ArrayList<>(5);
    QuizService qs = new QuizService();
    QuizQuestionService qqs = new QuizQuestionService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        setNewQuizQuestions();
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
    private void goToQuiz(MouseEvent event) {
    }

    @FXML
    private void addQuiz(ActionEvent event) {
        
        if (nomQuiz.getText().isEmpty() || secteur.getText().isEmpty() || specialite.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
                
        } else {
                Quiz quiz = new Quiz( secteur.getText(), specialite.getText(),nomQuiz.getText());
                qs.addQuiz(quiz);
                quiz = qs.getQuizByNom(nomQuiz.getText());
                //System.out.println(quiz);
                for (QuizQuestion qq: newQuestionsList) {
                  //System.out.println(qq);
                  qq.setQuiz(quiz.getId());
                  qqs.addQuizQuestion(qq);
                }
                
        }    //
                
                
    }

    @FXML
    private void handleQuestions(MouseEvent event) {
        selectedNewQuestionIndex = questionsListView.getSelectionModel().getSelectedIndex();
        System.out.println(selectedNewQuestionIndex);
    }
    
    private void setNewQuizQuestions() {
      
      for (int i=0; i<5; i++) {
          try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewEmptyQuizQuestion.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: white; -fx-border-radius: 10"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                questionsListView.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                //NewGestionQuizQuestionItemController qqic = fxmlLoader.getController();
                
                questionsListView.getItems().add(hbox);
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
         }   

    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
               
                  Parent root = FXMLLoader.load(getClass().getResource("./NewGestionQuiz.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) quizVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }
    
}
