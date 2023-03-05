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
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProjetServices;
import services.SecteurServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ModifierProjetsController implements Initializable {

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
    private TextField dureeTF;
    @FXML
    private TextField themeTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private DatePicker datedebutDP;
    @FXML
    private DatePicker datefinDP;
    @FXML
    private ComboBox<String> secteurCB;
   ProjetServices ps = new ProjetServices(); 
    SecteurServices ss = new SecteurServices();
     private String SecteurSelectionne;
    @FXML
    private TextField NomTF;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    NomTF.setText(ListeProjetsResponsableController.selectedProjetResp.getNom());
    datedebutDP.setValue(ListeProjetsResponsableController.selectedProjetResp.getDateDebut().toLocalDate());
    datefinDP.setValue(ListeProjetsResponsableController.selectedProjetResp.getDateFin().toLocalDate());  
    dureeTF.setText(ListeProjetsResponsableController.selectedProjetResp.getDuree() +"");
    descriptionTF.setText(ListeProjetsResponsableController.selectedProjetResp.getDescription());
    themeTF.setText(ListeProjetsResponsableController.selectedProjetResp.getTheme());
    secteurCB.setValue(ListeProjetsResponsableController.selectedProjetResp.getS().getDescription()+""); 
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
    private void UpdateProjet(ActionEvent event) {
        
       /* 
         ProjetFreelance p = ListeProjetsResponsableController.selectedProjetResp;
        p.setDuree(dureeTF.getText());
        p.setDescription(descriptionTF.getInt());
        p.setDateDebut(datedebutDP.getDate());
        ps.UpdateProjet(p.getIdProjet(), p);*/
      ProjetFreelance proUpdate =  ListeProjetsResponsableController.selectedProjetResp; 
   proUpdate.setNom(NomTF.getText());
    proUpdate.setDuree(Integer.parseInt(dureeTF.getText()));
    proUpdate.setTheme(themeTF.getText());
    proUpdate.setDescription(descriptionTF.getText());
    proUpdate.setDateDebut(Date.valueOf(datedebutDP.getValue()));
     proUpdate.setDateFin(Date.valueOf(datefinDP.getValue()));
     proUpdate.setS(ss.getsecteurbydescription(SecteurSelectionne));
     proUpdate.setIdResponsable(1);
    //ps.UpdateProjet(p.getIdProjet(), p);
    ps.UpdateProjet(proUpdate.getIdProjet(), proUpdate);
     try {
            Parent OffreprojetResponsable = FXMLLoader.load(getClass().getResource("OffreprojetResponsable.fxml"));
            Scene  OffreprojetResponsableScene = new Scene(OffreprojetResponsable);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetResponsableScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierProjetsController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }

    @FXML
    private void GoBack(MouseEvent event) {
        try {
            Parent OffreprojetResponsable = FXMLLoader.load(getClass().getResource("OffreprojetResponsable.fxml"));
            Scene  OffreprojetResponsableScene = new Scene(OffreprojetResponsable);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(OffreprojetResponsableScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierProjetsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
