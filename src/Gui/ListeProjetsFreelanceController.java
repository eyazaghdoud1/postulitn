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
import services.ProjetServices; 
import services.SecteurServices;


/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeProjetsFreelanceController implements Initializable {
    
    ProjetServices ps = new ProjetServices(); 
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
    private ListView<HBox> ProjetsFreelanceListView;
    public static ProjetFreelance selectedProjet;
    List<ProjetFreelance> projets = ps.fetchProjet();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
    
       for (ProjetFreelance pf : projets) {
       
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("./Projet.fxml"));
           try {
               HBox hb = loader.load();
               ProjetController pc = loader.getController();
               pc.setData(pf);
             
               ProjetsFreelanceListView.getItems().add(hb);
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
    private void handleProjet(MouseEvent event) {
         selectedProjet = projets.get( ProjetsFreelanceListView.getSelectionModel().getSelectedIndex());
        try {
   
            Parent Offreprojet = FXMLLoader.load(getClass().getResource("Offreprojet.fxml"));
            Scene  OffreprojetScene = new Scene(Offreprojet);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
    }
}
