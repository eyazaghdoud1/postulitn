/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.AuthenticationService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class TestmenubarController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setConnectedUser (){
//        URL u;
//        try {
//            u = new URL("http://localhost/postulitn/images/"+AuthenticationService.compteconnecte.getPhoto());
//             Image image = new Image(u.toString());
//              userPhoto.setImage(image);
//             
//          //  eeltaswira.setImage(image);
//           
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//        }


        URL u;
       if (AuthenticationService.compteconnecte.getPhoto() == null) {
             try {
                 u = new URL("http://localhost/postulitn/images/defaultuser.png");
                Image image = new Image(u.toString());
                userPhoto.setImage(image);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } 
       else {
    try {
        u = new URL("http://localhost/postulitn/images/"+ AuthenticationService.compteconnecte.getPhoto());
         Image image = new Image(u.toString());
         userPhoto.setImage(image);
        
    } catch (MalformedURLException ex) {
        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
    }

       }    
       
        userConnecte.setText(AuthenticationService.userconnecte.getNom());
    }

    @FXML
    public void goToCompte(MouseEvent event) {
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/newCompte.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void goToOffres(MouseEvent event) {
        if (AuthenticationService.roleconnecte.getDescription().equals("Recruteur")) {
         try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/newoffres.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")){ 
             try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/condidatoffres.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
    }

    @FXML
    public void goToCandidatures(MouseEvent event) {
         if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")){ 
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewCandidatures.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (AuthenticationService.roleconnecte.getDescription().equals("Recruteur")){
              try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewCandidaturesRecruteur.fxml"));
            Scene si = new Scene(Login); 
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @FXML
    public void goToEntretiens(MouseEvent event) {
        if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")){ 
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewEntretiensCandidat.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (AuthenticationService.roleconnecte.getDescription().equals("Recruteur")){
              try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewEntretiens.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @FXML
    public void goToGuides(MouseEvent event) {
         try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/listeguide.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void goToQuiz(MouseEvent event) {
        if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")){ 
        try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewQuizList.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }} else if (AuthenticationService.roleconnecte.getDescription().equals("Recruteur")){
              try {
            Parent Login = FXMLLoader.load(getClass().getResource("../GUI/NewGestionQuiz.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
               
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
