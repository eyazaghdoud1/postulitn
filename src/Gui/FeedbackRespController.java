/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CommentaireServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class FeedbackRespController implements Initializable {

    @FXML
    private Label userConnecte;
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
    private ListView<HBox> CommentListView;
    static CommentaireServices cs = new CommentaireServices(); 
  static List<Commentaire> commentairesResp ;
    public static Commentaire selectedCommentResp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO ProjetFreelance pf : projets
               commentairesResp= cs.fetchCommentaire();
         for (Commentaire c : commentairesResp ) {

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./CommentaireRespItem.fxml"));
           try {
               HBox hb = loader.load();
               CommentaireRespItemController sc = loader.getController();
               sc.setData(c);
             
               CommentListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void GoBack(MouseEvent event) {
     try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("OffreprojetResponable.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void HandleCommentaire(MouseEvent event) {
    selectedCommentResp = commentairesResp.get(CommentListView.getSelectionModel().getSelectedIndex());
    }
    }
    

