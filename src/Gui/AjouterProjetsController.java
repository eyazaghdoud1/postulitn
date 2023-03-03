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
    @FXML
    private TextField NomTF;
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
        
       ProjetFreelance p = new ProjetFreelance();
        /* if(validateDatePicker(datedebutDP) && validateDatePicker(datefinDP) && controleTextField(themeTF) && controleTextField(descriptionTF) && controleTextFieldDuree(dureeTF) )     {
        if (themeTF.getText().isEmpty())
        {
        erreurtheme.setText("theme non valide !");
        erreurtheme.setVisible(true);
        
        return;
        }
        if (descriptionTF.getText().isEmpty())
        {
        erreurdescription.setText("Description non valide !");
        erreurdescription.setVisible(true);
        
        return;
        }
        if (dureeTF.getText().isEmpty())
        {
        erreurduree.setText("duree non valide !");
        erreurduree.setVisible(true);
        
        return;
        }*/
        
     LocalDate selectedDate = datedebutDP.getValue();
        LocalDate selectedDate1 = datefinDP.getValue();
        String dateString = selectedDate.toString();
      //  ProjetFreelance p = new ProjetFreelance();
        SecteurServices ss = new SecteurServices();
        Secteur s = ss.getsecteurbydescription(secteurCB.getValue());
        p.setDuree(Integer.parseInt(dureeTF.getText()));
        p.setTheme(themeTF.getText());
        p.setNom(NomTF.getText()); 
        p.setDescription(descriptionTF.getText());     
        p.setDateDebut(Date.valueOf(datedebutDP.getValue()));
        p.setDateFin(Date.valueOf(datedebutDP.getValue()));
        p.setS(ss.getsecteurbydescription(SecteurSelectionne));
        p.setIdResponsable(0);
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

 

    }
  
