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
import services.SecteurServices;


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
         SecteurServices ss = new SecteurServices();
         ProjetServices ps = new ProjetServices(); 
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
            List<Secteur> ls = ss.fetchSecteur();
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
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
                
        }
        
       
//        if(validateDatePicker(datedebutDP) || validateDatePicker(datefinDP) || controleTextFieldNumerique(dureeTF) )     {
//        if (NomTF.getText().isEmpty())
//        {
//        erreurNom.setText("Veuillez saisir un nom !");
//        erreurNom.setVisible(true);
//        return;
//        }
//            
//            if (themeTF.getText().isEmpty())
//        {
//        erreurTheme.setText("theme non valide !");
//        erreurTheme.setVisible(true);
//        return;
//        }
//        
//        if (descriptionTF.getText().isEmpty())
//        {
//        erreurDescription.setText("Description non valide !");
//        erreurDescription.setVisible(true);
//        return;
//        }
//        
//        return;
//        }
//        if (dureeTF.getText().isEmpty())
//        {
//        erreurDuree.setText("duree non valide !");
//        erreurDuree.setVisible(true);
//        
//        return;
//        }
//        
//         if (datedebutDP.getValue()== null)
//        {
//        erreurDateDebut.setText("Date non valide !");
//        erreurDateDebut.setVisible(true);
//        return;
//        }
//        
//         if (datefinDP.getValue()== null)
//        {
//        erreurDateFin.setText("Date non valide !");
//        erreurDateFin.setVisible(true);
//        
//        
//        return;
//        }
        
//     LocalDate selectedDate = datedebutDP.getValue();
//        LocalDate selectedDate1 = datefinDP.getValue();
//        String dateString = selectedDate.toString();
//      //  ProjetFreelance p = new ProjetFreelance();
//        SecteurServices ss = new SecteurServices();
//        Secteur s = ss.getsecteurbydescription(secteurCB.getValue());
//        p.setDuree(Integer.parseInt(dureeTF.getText()));
//        p.setTheme        p.setTheme(themeTF.getText());
//(themeTF.getText());
//        p.setNom(NomTF.getText()); 
//        p.setDescription(descriptionTF.getText());     
//        p.setDateDebut(Date.valueOf(datedebutDP.getValue()));
//        p.setDateFin(Date.valueOf(datedebutDP.getValue()));
//        p.setS(ss.getsecteurbydescription(SecteurSelectionne));
//        p.setIdResponsable(0);
//        ps.addProjet(p);

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir la date ");
            alert.showAndWait();
            return true;
         }
           return false;
        }

 public boolean controleTextFieldNumerique(TextField textField) {
        if (textField.getText().matches(".*[a-zA-Z].*") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("veuillez saisir que des entiers!");
            alert.showAndWait();
            return true;
        }
             return false;}
    
    public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez n'insérer que des caractères !");
            alert.showAndWait();
            return true;
        }
             return false;}

    }
  
