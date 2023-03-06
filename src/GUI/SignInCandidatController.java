/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Compte;
import models.Utilisateur;
import org.joda.time.DateTime;
import org.joda.time.Years;
import services.CompteServices;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class SignInCandidatController implements Initializable {

    @FXML
    private Button btnsave;
    @FXML
    private TextField domaine;
    @FXML
    private TextField diplome;
    @FXML
    private TextField exp;
    @FXML
    private Button previousbtn;
    @FXML
    private DatePicker datediplome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    UtilisateurService us = new UtilisateurService();
    

    @FXML
    private void signin(ActionEvent event) {
          
         CompteServices cservice = new CompteServices();
    LocalDate selectedDate = datediplome.getValue();
    DateTime dateTime = new DateTime(selectedDate.getYear(), selectedDate.getMonthValue(), selectedDate.getDayOfMonth(), 0, 0);
    int yearsSinceDiploma = Years.yearsBetween(dateTime, DateTime.now()).getYears();
    if (exp.getText().equals("0 ans") && yearsSinceDiploma >= 5) {
        // Diplôme expiré
        //System.out.println("Diplôme expiré");
//        outputLabel.setText("Le diplôme est expiré !");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Diplome négligé!");
                alert.setContentText("Cherche des opportunités d'apprentissage et de développement de compétences, "
                        + "concentre-toi sur les compétences transférables, et persévère.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();

    }
        else {
        Utilisateur u = us.GetByEmail(SignInController.newUser.getEmail()); 
        Compte c = new Compte();
        c.setIdUser(u.getId());
        c.setExperience(exp.getText());
        c.setDiplome(diplome.getText());
        c.setDomaine(domaine.getText());
        c.setDateDiplome(Date.valueOf(datediplome.getValue()));
        cservice.addCompte(c);
        System.out.println(c);
             
        
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Stage compte2Stage = new Stage();
            compte2Stage.setScene(new Scene(root));
            compte2Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    }

    @FXML
    private void previous(ActionEvent event) {
        Parent Login;
        try {
            Login = FXMLLoader.load(getClass().getResource("../GUI/SignIn.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SignInCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
