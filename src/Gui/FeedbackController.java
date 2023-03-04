/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.ListeProjetsFreelanceController.selectedProjet;
import Models.Commentaire;
import Models.ProjetFreelance;
import Models.Secteur;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.CommentaireServices;
import services.SecteurServices;
/**
 * FXML Controller class
 *
 * @author Users
 */
public class FeedbackController implements Initializable {

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
    CommentaireServices cs = new CommentaireServices();
    List<Commentaire> commentaires = cs.fetchCommentaire();
   // public static ProjetFreelance selectedProjet;
    
    @FXML
    private Button AjouterCommentaire;
    @FXML
    private TextField ContenuTF;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
       for (Commentaire c : commentaires) {
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("./CommentaireItem.fxml"));
           try {
               HBox hb = loader.load();
               CommentaireItemController cc = loader.getController();
               cc.setData(c);
               //cc.setData(c);
               CommentListView.getItems().add(hb);
           } catch (IOException ex) {
               Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void addComment(ActionEvent event) {
        
        CommentaireServices cs = new CommentaireServices();
        Commentaire c = new Commentaire(); 
        c.setContenu(ContenuTF.getText());
        c.setIdProjet(selectedProjet.getIdProjet());
        c.setIdUser(0);
        String contenu = c.getContenu().toLowerCase();
 if (contenu.contains("fuck") || contenu.contains("shit") || contenu.contains("test")) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez respecter les éthiques de notre communauté");
        alert.showAndWait();
    } else {
        cs.addCommentaire(c);
     try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/Feedback.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    }

    @FXML
    private void GoBack(MouseEvent event) {
             try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("OffreProjet.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }

    
    

