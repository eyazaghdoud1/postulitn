/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewGestionQuizController implements Initializable {

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
    private ListView<HBox> quizListView;
    public static QuizService qsg = new QuizService();
    public static List<Quiz> quizListG ;
    @FXML
    private Label nbreQuiz;
    @FXML
    private VBox gestionVB;
    public static Quiz gestionSelectedQuiz;
    public static QuizQuestion gestionSelectedQuizQuestion;
    @FXML
    private ListView<HBox> questionsListView;
    @FXML
    private Button deleteQuizBtn;
    @FXML
    private Label secteur;
    @FXML
    private Label specialite;
    @FXML
    private Button newQuizBtn;
    @FXML
    private TextField nomQuiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        System.out.println("inital:" + gestionSelectedQuiz);
        quizListG =qsg.fetchQuiz();
        // prob: when reload; selected is setted correctly but the page is not loaded with the updated list of questions
        if (gestionSelectedQuiz == null) {
            gestionSelectedQuiz = quizListG.get(0);
            }
            setQuestions();
            secteur.setText(gestionSelectedQuiz.getSecteur());
            specialite.setText(gestionSelectedQuiz.getSpecialite());
            nomQuiz.setText(gestionSelectedQuiz.getNom());
            System.out.println("selected not null");
            //deleteQuizBtn.setVisible(true);
            gestionVB.setVisible(true);
            
        
        nbreQuiz.setText(nbreQuiz.getText() + quizListG.size());
         for (Quiz q : quizListG) {
            
                 try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewGestionQuizItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                NewGestionQuizItemController qic = fxmlLoader.getController();
                qic.setData(q);
                quizListView.getItems().add(hbox);
                quizListView.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");

                 } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
         
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
    private void handleMouseClick(MouseEvent event) {
        questionsListView.getItems().clear();
        gestionSelectedQuiz = quizListG.get(quizListView.getSelectionModel().getSelectedIndex());
        secteur.setText(gestionSelectedQuiz.getSecteur());
        specialite.setText( gestionSelectedQuiz.getSpecialite());
        nomQuiz.setText(gestionSelectedQuiz.getNom());
        setQuestions();
        //deleteQuizBtn.setVisible(true);
        gestionVB.setVisible(true);

    }
    
    public void setQuestions() {
         for (QuizQuestion qq: gestionSelectedQuiz.getQuestions()) {
          try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewGestionQuizQuestionItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                NewGestionQuizQuestionItemController qqic = fxmlLoader.getController();
                qqic.setData(qq);
                questionsListView.getItems().add(hbox);
                quizListView.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");

                 } catch (IOException ex) {
               ex.printStackTrace();
            }
         }   
     
    if (gestionSelectedQuiz.getQuestions().size() < 5) {    
            for (int i=0; i<5-gestionSelectedQuiz.getQuestions().size(); i++) {
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewGestionQuizQuestionItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10"); 
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                quizListView.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                //NewGestionQuizQuestionItemController qqic = fxmlLoader.getController();
                
                questionsListView.getItems().add(hbox);
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
            }
     }
     
    }

    @FXML
    private void handleQuestions(MouseEvent event) {
        if (questionsListView.getSelectionModel().getSelectedIndex() < gestionSelectedQuiz.getQuestions().size() ) {
        gestionSelectedQuizQuestion = gestionSelectedQuiz.getQuestions().get(questionsListView.getSelectionModel().getSelectedIndex());
        gestionSelectedQuizQuestion.setQuiz(gestionSelectedQuiz.getId());
        } else {
        gestionSelectedQuizQuestion = null;
        }
        System.out.println(questionsListView.getSelectionModel().getSelectedIndex());
        System.out.println(gestionSelectedQuizQuestion);
    }

    @FXML
    private void deleteQuiz(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer ce quiz?");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 qsg.deleteQuiz(gestionSelectedQuiz.getId());
                 System.out.println("quiz supprimé " );
                 this.reload();
                } else {
                 // clic sur le bouton non
                 alert.close();
                }

    }
    
    private void reload() {
        gestionSelectedQuiz = null ;
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

    @FXML
    private void addNewQuiz(ActionEvent event) {
        try {
               
                  Parent root = FXMLLoader.load(getClass().getResource("./NewAjouterQuiz.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) quizVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    @FXML
    private void modfierNomQuiz(ActionEvent event) {
        Quiz q = qsg.getQuizById(gestionSelectedQuiz.getId());
        q.setNom(nomQuiz.getText());
        qsg.updateQuiz(q.getId(), q);
        reload();
    }

}
