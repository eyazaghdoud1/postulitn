/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.GuideEntretien;
import static org.joda.time.format.ISODateTimeFormat.date;
import services.AuthenticationService;
import services.GuideEntretienService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class Modifierguide2Controller implements Initializable {
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
    private TextField supporttf;
    @FXML
    private TextField specialitetf;
    @FXML
    private TextField domainetf;
    @FXML
    private Button backBtn;
    
    
    TestmenubarController mbc = new TestmenubarController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           /****************************************************************************************/
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
        
        
        /****************************************************************************************************/
        supporttf.setText(ListeguideController.selectedGuide.getSupport());
        domainetf.setText(ListeguideController.selectedGuide.getDomaine());
        specialitetf.setText(ListeguideController.selectedGuide.getSpecialite());
//         URL u;
//        try {
//            u = new URL("http://localhost/postulitn/images/"+NewCompteController.compteUser.getPhoto());
//             Image image = new Image(u.toString());
//              userPhoto.setImage(image);
//             
//          
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // mbc.setConnectedUser();
        
        // TODO
//        domainetf.setText(Guideentretien2Controller.getDomaine());
//        cvtf.setText(Compte2Controller.compteUser.getCv());
//        entreprisetf.setText(Compte2Controller.compteUser.getEntreprise());
    }    

    @FXML
    private void goToCompte(MouseEvent event) {
         mbc.goToCompte(event);
    }

    @FXML
    private void goToOffres(MouseEvent event) {
        mbc.goToOffres(event);
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
        mbc.goToCandidatures(event);
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
        mbc.goToEntretiens(event);
    }

    @FXML
    private void goToGuides(MouseEvent event) {
           mbc.goToGuides(event);
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
    }

    @FXML
    private void boutnmodifierguide(ActionEvent event) {
        
        String domaine = domainetf.getText().trim();
String specialite = specialitetf.getText().trim();
String support = supporttf.getText().trim();

if (domaine.isEmpty() || specialite.isEmpty() || support.isEmpty()) {
    // afficher un message d'erreur ou faire une action appropriée
     Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs manquants");
                alert.setContentText("Vous devez remplir tous les champs avant d'enregistrer.");
                ButtonType buttonTypeNo = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
                alert.getButtonTypes().setAll( buttonTypeNo);
                alert.showAndWait();
    
    
    
    
    
    return;
} else {
        
        
        GuideEntretienService ges = new GuideEntretienService();
        GuideEntretien ge = Guideentretien2Controller.thisGuide;
        ge.setDomaine(domainetf.getText());
        ge.setSpecialite(specialitetf.getText());
        ge.setSupport(supporttf.getText());
        ges.updateGuideEntretien(Guideentretien2Controller.thisGuide.getIdguide(), ge);
        
       
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/guideentretien2.fxml"));
        Parent root = loader.load();
       
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
}

    @FXML
    private void goBack(ActionEvent event) {
        
           try {
        Parent root = FXMLLoader.load(getClass().getResource("guideentretien2.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }
    File supportFile;
    @FXML
    private void browse(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Select support");

        supportFile = fileChooser.showOpenDialog(supporttf.getScene().getWindow());
        System.out.println("done");
        supporttf.setText(supportFile.getAbsolutePath());
    }
}