/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
//import java.time.Duration;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Compte;
import services.CompteServices;
import org.joda.time.DateTime;
import org.joda.time.Years;
import javafx.util.Duration;




/**
 * FXML Controller class
 *
 * @author dell
 */
public class Ajoutercompte2Controller implements Initializable {
    @FXML
    private Label userConnecte;
    @FXML
    private ImageView userPhoto;
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
    private DatePicker datediplomedp;
    @FXML
    private TextField entreprisetf;
    @FXML
    private TextField diplometf;
    @FXML
    private TextField phototf;
    @FXML
    private TextField experiencetf;
    @FXML
    private Label outputLabel;
    @FXML
    private TextField domainetf;
    @FXML
    private TextField postetf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        URL u;
        try {
            u = new URL("http://localhost/postulitn/images/"+NewCompteController.compteUser.getPhoto());
             Image image = new Image(u.toString());
              userPhoto.setImage(image);
             
          //  eeltaswira.setImage(image);
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void goToCompte(MouseEvent event) { try {
        Parent compteParent = FXMLLoader.load(getClass().getResource("compte2.fxml"));
        Scene compteScene = new Scene(compteParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
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
           try {
        Parent root = FXMLLoader.load(getClass().getResource("Listeguide.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
    }

    @FXML
    private void boutnajoutcompte(ActionEvent event) {
        
         CompteServices cservice = new CompteServices();
    LocalDate selectedDate = datediplomedp.getValue();
    DateTime dateTime = new DateTime(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth(), 0, 0);
    int yearsSinceDiploma = Years.yearsBetween(dateTime, DateTime.now()).getYears();
    if (experiencetf.getText().equals("0 ans") && yearsSinceDiploma >= 5) {
        // Diplôme expiré
        //System.out.println("Diplôme expiré");
        outputLabel.setText("Le diplôme est expiré !");
        
        
        
       PauseTransition delay = new PauseTransition(Duration.millis(3000));
        delay.setOnFinished(e -> {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            // Afficher la fenêtre Compte2.fxml
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Compte2.fxml"));
                Parent root = loader.load();
                Stage compte2Stage = new Stage();
                compte2Stage.setScene(new Scene(root));
                compte2Stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        delay.play();
        
        
    } else {
        Compte c = new Compte();
        c.setExperience(experiencetf.getText());
        c.setPhoto(phototf.getText());
        c.setDiplome(diplometf.getText());
        c.setPhoto(phototf.getText());
        //c.setCv(cvtf.getText());
        c.setEntreprise(entreprisetf.getText());
        c.setDomaine(domainetf.getText());
        c.setPoste(postetf.getText());
        c.setDateDiplome(Date.valueOf(datediplomedp.getValue()));
        cservice.addCompte(c);
        
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        
        // Afficher la fenêtre Compte2.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Compte2.fxml"));
            Parent root = loader.load();
            Stage compte2Stage = new Stage();
            compte2Stage.setScene(new Scene(root));
            compte2Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    }
        
    }
    

