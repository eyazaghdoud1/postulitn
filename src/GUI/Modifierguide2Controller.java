/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.GuideEntretien;
import static org.joda.time.format.ISODateTimeFormat.date;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         URL u;
        try {
            u = new URL("http://localhost/postulitn/images/"+Compte2Controller.compteUser.getPhoto());
             Image image = new Image(u.toString());
              userPhoto.setImage(image);
             
          
        } catch (MalformedURLException ex) {
            Logger.getLogger(Compte2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
//        domainetf.setText(Guideentretien2Controller.getDomaine());
//        cvtf.setText(Compte2Controller.compteUser.getCv());
//        entreprisetf.setText(Compte2Controller.compteUser.getEntreprise());
    }    

    @FXML
    private void goToCompte(MouseEvent event) {
         try {
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
        GuideEntretien ge = new GuideEntretien();
        ge.setDomaine(domainetf.getText());
        ge.setSpecialite(specialitetf.getText());
        ge.setSupport(supporttf.getText());
        ges.updateGuideEntretien(ListeguideController.selectedGuide.getIdguide(), ge);
        
       
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/listeguide.fxml"));
        Parent root = loader.load();
        ListeguideController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
}
}