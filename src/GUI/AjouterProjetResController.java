/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.util.Duration;
import services.ProjetServices;
import services.SecteurServices;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
         SecteurServices secteurservice = new SecteurServices();
         ProjetServices projetservice = new ProjetServices(); 
         ProjetFreelance p = new ProjetFreelance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          List<Secteur> ls = secteurservice.fetchSecteur();
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
    SecteurServices secteurservice = new SecteurServices();
    Secteur s = secteurservice.getsecteurbydescription(secteurCB.getValue());

    ProjetFreelance p = new ProjetFreelance();
    p.setDuree(Integer.parseInt(dureeTF.getText()));
    p.setTheme(themeTF.getText());
    p.setNom(NomTF.getText()); 
    p.setDescription(descriptionTF.getText());     
    p.setDateDebut(Date.valueOf(datedebutDP.getValue()));
    p.setDateFin(Date.valueOf(datefinDP.getValue()));
    if (SecteurSelectionne != null) {
        p.setS(secteurservice.getsecteurbydescription(SecteurSelectionne));
    }
    // TODO: Set idResponsable to a valid value
    p.setIdResponsable(1);
    projetservice.addProjet(p);
     String tilte = "Offre Ajoutée";
            String message = NomTF.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
        
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
    }

    @FXML
    private void GoBack(ActionEvent event) {  
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
    

