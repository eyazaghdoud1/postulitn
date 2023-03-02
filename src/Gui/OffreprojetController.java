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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private void GoToListeProjets(MouseEvent event) throws IOException {
         Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjetsFreelance.fxml"));
       Scene  OffreprojetScene = new Scene(Offreprojet);
       Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       appStage.setScene(OffreprojetScene); 
       appStage.show();
    }
    
}
