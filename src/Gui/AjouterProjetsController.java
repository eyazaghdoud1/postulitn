/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import Models.Secteur;
import interfaces.ProjetInterface;
import interfaces.SecteurInterface;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ProjetServices;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import services.SecteurServices;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Users
 */
public class AjouterProjetsController implements Initializable {

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
        private String SecteurSelectionne;
         SecteurServices secteurservice = new SecteurServices();
         ProjetServices projetservice = new ProjetServices(); 
         ProjetFreelance p = new ProjetFreelance();
    @FXML
    private TextField NomTF;
    @FXML
    private Label erreurNom;
    @FXML
    private Label erreurDuree;
    @FXML
    private Label erreurTheme;
    @FXML
    private Label erreurDateDebut;
    @FXML
    private Label erreurDateFin;
    @FXML
    private Label erreurSecteur;
    @FXML
    private Label erreurDescription;
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
    }    
/*
    @FXML
    private void goToCompte(MouseEvent event) {
    }*/
    @FXML
    private void addProjet(ActionEvent event) {
        
        if (NomTF.getText().isEmpty() || dureeTF.getText().isEmpty() || themeTF.getText().isEmpty()  ||  descriptionTF.getText().isEmpty() || datedebutDP.getValue()== null || datefinDP.getValue()== null || secteurCB.getValue() == null)
                {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'ajouter le projet.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();         
        } else if (controleTextFieldNumerique(dureeTF)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duree invalide");
                alert.setContentText("Votre durée est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
            }else if (controleTextFieldNonNumerique(themeTF)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duree invalide");
                alert.setContentText("Votre théme est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
            }else if (controleTextFieldNonNumerique(descriptionTF)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duree invalide");
                alert.setContentText("Votre description est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
         }else if (validateDatePicker(datedebutDP)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duree invalide");
                alert.setContentText("Votre date est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
          }else if(validateDatePicker(datefinDP)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Duree invalide");
                alert.setContentText("Votre date est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();}
          else{

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
      String tilte = "Projet Ajouté avec succes";
            String message = NomTF.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
        
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
    }}
        

    @FXML
    private void goToCompte(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void goToOffres(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void goToCandidatures(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void goToEntretiens(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void goToGuides(javafx.scene.input.MouseEvent event) {
    }
    
    
public boolean validateDatePicker(DatePicker dateD)
    {
          if(dateD.getEditor().getText().isEmpty())
         {
          
            return true;
         }
           return false;
        }

 public boolean controleTextFieldNumerique(TextField textField) {
        if (textField.getText().matches(".*[a-zA-Z].*") ) { 
            return true;
        }
             return false;}
    
    public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[0-9].*")) { 
            return true;
        }
             return false;}

    } 

