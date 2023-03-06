/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Models.Commentaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.controlsfx.control.Rating;
import org.controlsfx.control.Rating;
import services.CommentaireServices;
import services.ProjetServices;
import utilities.MaConnexion;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class OffreprojetController implements Initializable {

    
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
    private Label Lduree;
    @FXML
    private Label Ltheme;
    @FXML
    private Label Ldescription;
    @FXML
    private Label LDateDebut;
    @FXML
    private Label LDateFin;
    @FXML
    private Label Lsecteur;
    private ListView<HBox> CommentsListView;
    @FXML
    private Label Lnom;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Ltheme.setText(ListeProjetsFreelanceController.selectedProjet.getTheme());
        LDateDebut.setText(ListeProjetsFreelanceController.selectedProjet.getDateDebut() + "");
        LDateFin.setText(ListeProjetsFreelanceController.selectedProjet.getDateFin() + "");
        Lduree.setText(ListeProjetsFreelanceController.selectedProjet.getDuree()+ "");
        Ldescription.setText(ListeProjetsFreelanceController.selectedProjet.getDescription());
        Lsecteur.setText(ListeProjetsFreelanceController.selectedProjet.getS().getDescription()+"");
        Lnom.setText(ListeProjetsFreelanceController.selectedProjet.getNom());
       // tf_note.setRating(ListeProjetsFreelanceController.selectedProjet.getNote());
       
        
      
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
    private void GoToPostuler(ActionEvent event) {
    }



    @FXML
    private void GoToComments(ActionEvent event) {
      try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("Feedback.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
  

   /* @FXML
        private void Submit(ActionEvent event) throws SQLException {
        ProjetServices projetservice = new ProjetServices(); 
        projetservice.ajouterRating(tf_note, ListeProjetsFreelanceController.selectedProjet.getIdProjet());
       //tf_note.setRating(ListeProjetsFreelanceController.selectedProjet.getNote());
        //System.out.println("Rating enregistré");
        */
 
//    int rating = ListeProjetsFreelanceController.selectedProjet.getNote();
//    tf_note.setRating(rating);
//    
//    // Update the rating value in the database
//    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/postulidb/projets")) {
//        PreparedStatement stmt = MaConnexion.prepareStatement("UPDATE projects SET note = ? WHERE idProjet = ?");
//        stmt.setInt(1, rating);
//        stmt.setInt(2, ListeProjetsFreelanceController.selectedProjet.getIdProjet());
//        int rowsUpdated = stmt.executeUpdate();
//        System.out.println(rowsUpdated + " row(s) updated.");
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//    }
//        
    

    @FXML
    private void GoBack(ActionEvent event) {
          try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjetsFreelance.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
