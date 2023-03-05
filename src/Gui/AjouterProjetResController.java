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
import java.time.LocalDate;
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
public class AjouterProjetResController implements Initializable {

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
    @FXML
    private TextField NomTF;
    @FXML
    private Label erreurNom;
    @FXML
    private Label erreurDuree;
    @FXML
    private Label erreurTheme;
    @FXML
    private Label erreurDescription;
    @FXML
    private Label erreurDateDebut;
    @FXML
    private Label erreurDateFin;
    @FXML
    private Label erreurSecteur;

     private String SecteurSelectionne;
         SecteurServices ss = new SecteurServices();
         ProjetServices ps = new ProjetServices(); 
         ProjetFreelance p = new ProjetFreelance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          List<Secteur> ls = ss.fetchSecteur();
        for(int i=0; i<ls.size(); i++ )  {
        secteurCB.getItems().addAll(ls.get(i).getDescription());
        }
        secteurCB.setOnAction(e -> {SecteurSelectionne=secteurCB.getValue();});
        // TODO
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
    private void addProjet(ActionEvent event) {
        
          if (NomTF.getText().isEmpty() || dureeTF.getText().isEmpty() || themeTF.getText().isEmpty()  ||  descriptionTF.getText().isEmpty() || datedebutDP.getValue()== null || datefinDP.getValue()== null || secteurCB.getValue() == null)
                {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
                
        }
        
          LocalDate selectedDate = datedebutDP.getValue();
    LocalDate selectedDate1 = datefinDP.getValue();
    SecteurServices ss = new SecteurServices();
    Secteur s = ss.getsecteurbydescription(secteurCB.getValue());

    ProjetFreelance p = new ProjetFreelance();
    p.setDuree(Integer.parseInt(dureeTF.getText()));
    p.setTheme(themeTF.getText());
    p.setNom(NomTF.getText()); 
    p.setDescription(descriptionTF.getText());     
    p.setDateDebut(Date.valueOf(datedebutDP.getValue()));
    p.setDateFin(Date.valueOf(datefinDP.getValue()));
    if (SecteurSelectionne != null) {
        p.setS(ss.getsecteurbydescription(SecteurSelectionne));
    }
    // TODO: Set idResponsable to a valid value
    p.setIdResponsable(1);

    ps.addProjet(p);
    }

    @FXML
    private void GoBack(MouseEvent event) {  
         try {
   
            Parent ModifierProjets = FXMLLoader.load(getClass().getResource("ListeProjetsResponsable.fxml"));
            Scene  ModifierProjetsScene = new Scene(ModifierProjets);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(ModifierProjetsScene);
            appStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListeProjetsFreelanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

