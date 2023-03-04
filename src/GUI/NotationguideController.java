/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.GuideEntretien;
import services.GuideEntretienService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class NotationguideController implements Initializable {
    @FXML
    private TextField notedonnetf;
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
    private TextField idguidepn;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void boutndonnernote(ActionEvent event) throws IOException {
        
         try {
        double note = Double.parseDouble(notedonnetf.getText());
        if (note < 0 || note > 10) { // Vérifier que la note est bien entre 0 et 10
           errorLabel.setText("La note doit être entre 0 et 10.");
            return;
        }
        int idGuide = Integer.parseInt(idguidepn.getText()); // récupérer l'identifiant du guide entretien à partir d'un champ de saisie
        GuideEntretienService ges = new GuideEntretienService();
        GuideEntretien ge = ges.GetByIdGuideEntretiens(idGuide); 
        if (ge != null) { 
            ges.ajouterNote(note, ge);
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("listeguide.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Le guide entretien avec l'identifiant " + idGuide + " n'a pas été trouvé dans la base de données.");
        }
    } catch (NumberFormatException e) {
    }
        
        
        
        
        
//    try {
//        double note = Double.parseDouble(notedonnetf.getText());
//        int idGuide = Integer.parseInt(idguidepn.getText()); 
//        GuideEntretienService ges = new GuideEntretienService();
//        GuideEntretien ge = ges.GetByIdGuideEntretiens(idGuide);
//        if (ge != null) { 
//            ges.ajouterNote(note, ge); 
//
//            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("listeguide.fxml"));
//            Parent root = loader.load();
//
//           
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } else {
//            System.out.println("Le guide entretien avec l'identifiant " + idGuide + " n'a pas été trouvé dans la base de données.");
//        }
//    } catch (NumberFormatException e) {
//       
//    }
}

    
//    private void boutndonnernote(ActionEvent event) {
//  
//        
//        
//          try {
//        double note = Double.parseDouble(notedonnetf.getText());
//        int idGuide = Integer.parseInt(idguidepn.getText()); // récupérer l'identifiant du guide entretien à partir d'un champ de saisie
//        GuideEntretienService ges = new GuideEntretienService();
//        GuideEntretien ge = ges. GetByIdGuideEntretiens(idGuide); // récupérer l'objet GuideEntretien correspondant à l'identifiant
//        if (ge != null) { // vérifier si l'objet a été trouvé dans la base de données
//            ges.ajouterNote(note, ge); // ajouter la note à l'objet GuideEntretien et le mettre à jour dans la base de données
//            // Faites quelque chose avec l'objet ge mis à jour si nécessaire
//        } else {
//            System.out.println("Le guide entretien avec l'identifiant " + idGuide + " n'a pas été trouvé dans la base de données.");
//        }
//    } catch (NumberFormatException e) {
//        // Gérez l'exception si l'utilisateur a entré une valeur incorrecte dans le champ de texte notetf
//    }
        
        
        
        
//
//         try {
//        double note = Double.parseDouble(notedonnetf.getText());
//        GuideEntretien ge = new GuideEntretien();// Créez un nouvel objet GuideEntretien si nécessaire
//        GuideEntretienService ges = new GuideEntretienService();
//        ges.ajouterNote(note, ge);
//        // Faites quelque chose avec l'objet ge mis à jour si nécessaire
//    } catch (NumberFormatException e) {
//        // Gérez l'exception si l'utilisateur a entré une valeur incorrecte dans le champ de texte notetf
//    }
//         
         
         
        
//         TextField notedonnetf = note; // récupérez le champ de texte de la note
//    double note = Double.parseDouble(notedonnetf.getText()); // convertissez la valeur saisie en un double
//    GuideEntretien guideEntretien = ...; // récupérez l'instance de GuideEntretien appropriée
//    ajouterNote(note, guideEntretien);
//        
        
        
    

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
    
}
