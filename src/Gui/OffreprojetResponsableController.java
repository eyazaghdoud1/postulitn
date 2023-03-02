/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class OffreprojetResponsableController implements Initializable {

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
    private Label Lsecteur;
    @FXML
    private Label LDateDebut;
    @FXML
    private Label LDateFin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Ltheme.setText(ListeProjetsResponsableController.selectedProjetResp.getTheme());
        LDateDebut.setText(ListeProjetsResponsableController.selectedProjetResp.getDateDebut() + "");
        LDateFin.setText(ListeProjetsResponsableController.selectedProjetResp.getDateFin() + "");
        Lduree.setText(ListeProjetsResponsableController.selectedProjetResp.getDuree()+ "");
        Ldescription.setText(ListeProjetsResponsableController.selectedProjetResp.getDescription());
        Lsecteur.setText(ListeProjetsResponsableController.selectedProjetResp.getS().getDescription()+"");
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
    private void GoToListeProjets(MouseEvent event) {
        try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("ListeProjetsResponsable.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteProjet(ActionEvent event) {
    }

    @FXML
    private void GoToModifier(ActionEvent event) {
         try {
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("ModifierProjets.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(OffreprojetResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
