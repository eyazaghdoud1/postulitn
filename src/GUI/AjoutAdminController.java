/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import static gui.RolesController.r;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Role;
import models.Utilisateur;
import services.RoleService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class AjoutAdminController implements Initializable {

    @FXML
    private Button btnajadmin;
    @FXML
    private TextField nomadmin;
    @FXML
    private TextField prenomadmin;
    @FXML
    private TextField emailadmin;

     UtilisateurService us = new UtilisateurService();
     public static Utilisateur u;
     RoleService rs = new RoleService();
    @FXML
    private Button previousbtn;
    @FXML
    private TextField adresseadmin;
    @FXML
    private TextField teladmin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Utilisateur> users = us.fetchUsers();
         for (int i=0; i<users.size();i++){
            u=users.get(i);
         }}    

  
   
    
    @FXML
    private void AjoutAdmin(ActionEvent event) {     
        if (nomadmin.getText().isEmpty() || prenomadmin.getText().isEmpty() ||emailadmin.getText().isEmpty() 
           || adresseadmin.getText().isEmpty() || teladmin.getText().isEmpty() ){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
                
        } else if (controleTextFieldMAIL(emailadmin)){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mail invalide");
                alert.setContentText("Votre adresse mail est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
            }
        else if (controleTextFieldNonNumerique(teladmin)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Numéro de téléphone invalide");
                alert.setContentText("Votre numéro de téléphone est invalide");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
        }
        else{       u.setNom(nomadmin.getText());
                u.setPrenom(prenomadmin.getText());
                u.setEmail(emailadmin.getText());
                u.setTel(teladmin.getText());
                u.setAdresse(adresseadmin.getText());
                u.setRole(rs.GetByDescription("Administrateur"));
                us.addUser(u);      
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Administrateur ajouté !");
                alert.showAndWait();
                try { 
                Parent Login = FXMLLoader.load(getClass().getResource("../GUI/UsersList.fxml"));
                Scene si = new Scene(Login);
                Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
                st.setScene(si);
                st.show();
            } catch (IOException ex) {
                Logger.getLogger(AjoutAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[a-zA-Z].*") || textField.getText().length()!= 8) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("veuillez saisir que des entiers!");
//            alert.showAndWait();
            return true;
        }
             return false;}
     public boolean controleTextFieldMAIL(TextField textField) {
        if (!textField.getText().contains("@") || !textField.getText().contains(".")) {

            return true;
        }
             return false;}
     

   

  @FXML
    private void previous(ActionEvent event) {
    Parent Login;
        try {
            Login = FXMLLoader.load(getClass().getResource("../GUI/UsersList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(SignInCandidatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


 }