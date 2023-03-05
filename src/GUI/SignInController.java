/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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
    
    private Date datenaissance;
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
        if (nom.getText().isEmpty() || prenom.getText().isEmpty() ||mail.getText().isEmpty() || dateN.getValue()==null   || mdp.getText().isEmpty()
           || adresse.getText().isEmpty() || tel.getText().isEmpty() || statut.getValue()==null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
                
        } else if (controleTextFieldMAIL(mail)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mail invalide");
                alert.setContentText("Votre adresse mail est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
            }
        else if (controleTextFieldNonNumerique(tel)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Numéro de téléphone invalide");
                alert.setContentText("Votre numéro de téléphone est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
        }

        else{
            if (s == "Recruteur" ){
        try{
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/SignInRecruteur.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (s == "Candidat"){
            try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/SignInCandidat.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        }catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }}
    
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
        if (textField.getText().matches(".*[a-zA-Z].*") || textField.getText().length()!= 8) {
            return true;
        }
             return false;}
    
    public boolean controleTextFieldNomEtPrenom(TextField textField1,TextField textField) {
        if (textField1.getText().matches(".*[0-9].*")||textField.getText().matches(".*[0-9].*")) {

            return true;
        }
             return false;}
    
    public boolean controleTextFieldMAIL(TextField textField) {
        if (!textField.getText().contains("@") || !textField.getText().contains(".")) {

            return true;
        }
             return false;}
 


    @FXML
    private void previous(ActionEvent event) throws IOException {
        Parent Login = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
    }

    
}
