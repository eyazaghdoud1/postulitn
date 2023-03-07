/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Quiz;
import postulitnapp.FXMain;
import services.AuthenticationService;
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewQuizListController implements Initializable {

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
    @FXML
    private SplitMenuButton specialiteFitre;
    QuizService qs = new QuizService();
    List<Quiz> quizList = qs.fetchQuiz();
    public static Quiz selectedQuiz;
    TestmenubarController mbc = new TestmenubarController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //MenuBarController mbc = new MenuBarController();
           /****************************************************************************************/
        URL u;
       if (AuthenticationService.compteconnecte.getPhoto() == null) {
             try {
                 u = new URL("http://localhost/postulitn/images/defaultuser.png");
                Image image = new Image(u.toString());
                userPhoto.setImage(image);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } 
       else {
    try {
        u = new URL("http://localhost/postulitn/images/"+ AuthenticationService.compteconnecte.getPhoto());
         Image image = new Image(u.toString());
         userPhoto.setImage(image);
        
    } catch (MalformedURLException ex) {
        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
    }

       }    
       
        userConnecte.setText(AuthenticationService.userconnecte.getNom());
        
        
        /****************************************************************************************************/
         for (Quiz q : quizList) {
            
                 try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewQuizItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;; -fx-border-color:white"); 
                
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                quizListView.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewQuizItemController qic = fxmlLoader.getController();
                qic.setData(q);
                quizListView.getItems().add(hbox);
                 } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        
        /* if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")) { 
// the above code 
         
         
         }
         else if (AuthenticationService.roleconnecte.equals("Recruteur")) {
           quizList = qs.filterQuizByRecruteur(userconnecte.getId());
         Button newQuiz = new Button ("Ajouter un quiz ");
         onclick=> redirection à la page d'ajout de quiz
         }*/
         
         
         
        
    }    

    @FXML
    private void goToCompte(MouseEvent event) {
        mbc.goToCompte(event);
    }

    @FXML
    private void goToOffres(MouseEvent event) {
        mbc.goToOffres(event);
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
        mbc.goToCandidatures(event);
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
        mbc.goToEntretiens(event);
    }

    @FXML
    private void goToGuides(MouseEvent event) {
        mbc.goToGuides(event);
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        selectedQuiz = quizList.get(quizListView.getSelectionModel().getSelectedIndex());
       try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewQuizInterface.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }
    
}
