/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.UtilisateurInterface;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */


public class SignInController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker dateN;
    @FXML
    private ChoiceBox<String> statut;
    @FXML
    private TextField mail;
    @FXML
    private Button btns;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;

    private String s;
    @FXML
    private Button previousbtn;
    @FXML
    private Label erreurnom;
    @FXML
    private Label erreurmail;
    @FXML
    private Label erreurdate;
    @FXML
    private Label erreurmdp;
    @FXML
    private Label erreurprenom;
    @FXML
    private Label erreurprenom1;
    @FXML
    private Label erreurtel;
    @FXML
    private Label erreuradresse;
    /**
     * Initializes the controller class.
     */
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statut.getItems().addAll("Candidat", "Recruteur");
        statut.setOnAction(e -> { s = statut.getValue();});
    }    

    @FXML
    private void goToNextPage(ActionEvent event) {
        
        if (validateDatePicker(dateN) || controleTextFieldNomEtPrenom(nom,prenom) || controleTextFieldMAIL(mail)){
            
              if (nom.getText().isEmpty())
         {
                        erreurnom.setText("nom non valide !");
                        erreurnom.setVisible(true);
                        
                        return;
                    }
    if (prenom.getText().isEmpty())
         {
                        erreurprenom.setText("prénom non valide !");
                        erreurprenom.setVisible(true);
                        
                        return;
                    }
     if (mail.getText().isEmpty())
         {
                        erreurmail.setText("mail non valide !");
                        erreurmail.setVisible(true);
                        
                        return;
                    }
      if (adresse.getText().isEmpty())
         {
                        erreuradresse.setText("adresse non valide !");
                        erreuradresse.setVisible(true);
                        
                        return;
                    }
      if (tel.getText().isEmpty())
         {
                        erreurtel.setText("Tel non valide !");
                        erreurtel.setVisible(true);
                        
                        return;
                    }
      if (mdp.getText().isEmpty())
         {
                        erreurmdp.setText("Mot de passe non valide !");
                        erreurmdp.setVisible(true);
                        return;
                    }
        }

            if (s == "Recruteur"){
        try{
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/SignInRecruteur.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (s == "Candidat"){
            try {
            Parent Login = FXMLLoader.load(getClass().getResource("../gui/SignInCandidat.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        }catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
    public boolean validateDatePicker(DatePicker dateD)
    {
          if(dateD.getEditor().getText().isEmpty())
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre date de naissance ");
            alert.showAndWait();
            return true;
         }
           return false;
        }
    
    public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[a-zA-Z].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("veuillez saisir que des entiers!");
            alert.showAndWait();
            return true;
        }
             return false;}
    
    public boolean controleTextFieldNomEtPrenom(TextField textField1,TextField textField) {
        if (textField1.getText().matches(".*[0-9].*")||textField.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("c'est interdit d'inserer un numero dans poste nom ou description");
            alert.showAndWait();
            return true;
        }
             return false;}
    
    public boolean controleTextFieldMAIL(TextField textField) {
        if (!textField.getText().contains("@")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Votre adresse mail est invalide");
            alert.showAndWait();
            return true;
        }
             return false;}
 
    /*
    // validateDatePicker(dateN) || controleTextFieldNomEtPrenom(nom,prenom))  {           //|| controleTextFieldMAIL(specialitetf)
   
    LocalDate selectedDate = dateN.getValue();

    // Convert the selected date to a string if needed
String dateString = selectedDate.toString();

// Check if a date has been selected
//  if (selectedDate == null) {
//    dateString.setText("Date non valide !");
//    dateString.setVisible(true);
//    return;
//}






//   TypeoffreService ts = new TypeoffreService();
//    Offre o = new Offre();
//    //Typeoffre to = ts.getelementbyid(typetf);
//    
//    
//    o.setPoste(postetf.getText());
//        o.setDescription(descriptiontf.getText());
//        o.setLieu(lieutf.getText());
//        o.setEntreprise(entreprisetf.getText());
//        o.setSpecialite(specialitetf.getText());
//        o.setDateExpiration(Date.valueOf(dateD.getValue()));
//       // o.setType(type);
//    
//    //o.setDateExpiration(Date.valueOf("2024-11-19"));
//       // o.setType(to);
//        o.setIdRecruteur(5);
//        os.addOffre(o);
    
    
   }
    
    
    
//    showAll();
    
    
    
   
        
    /* 
   */ 
    /*
    
        
       /*

    private void checkinput(javafx.scene.input.KeyEvent event) {
      if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
            
            lieutf.setStyle("-fx-border-color: red");
        }else{
            lieutf.setStyle("-fx-border-color: green");
        }
    }
    
    
}*/


    @FXML
    private void previous(ActionEvent event) throws IOException {
        Parent Login = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
    }

    
}
