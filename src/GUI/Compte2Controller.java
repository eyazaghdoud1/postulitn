/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Compte2Controller.compteUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Compte;
import services.CompteServices;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class Compte2Controller implements Initializable {
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
    private Label entrpers;
    private Label cvpers;
    @FXML
    private Label ddippers;
    @FXML
    private Label diplomepers;
    @FXML
    private Label exppers;
    public static CompteServices comptes = new CompteServices();
    public static Compte compteUser = comptes.GetByIdCompte(7);
    private ImageView taswira;
    @FXML
    private Label domainetf;
    @FXML
    private Label postetf;
    @FXML
    private ImageView eeltaswira;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        URL u;
        try {
            u = new URL("http://localhost/postulitn/images/"+Compte2Controller.compteUser.getPhoto());
             Image image = new Image(u.toString());
              userPhoto.setImage(image);
             
           eeltaswira.setImage(image);
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(Compte2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
         
         Compte c =compteUser;
         //compteUser= c; 

         exppers.setText(c.getExperience()); 
         diplomepers.setText(c.getDiplome());
         ddippers.setText("" + c.getDateDiplome());
       //  cvpers.setText(c.getCv());
         //************HOOOOOOO      NAHI ENTREPRISE COMM *******
         entrpers.setText(c.getEntreprise());
         domainetf.setText(c.getDomaine());
         postetf.setText(c.getPoste());
         
//         if(c.getTypeCompte().equals("Candidat")) {
//        // Si l'utilisateur est un candidat, masquer le champ entreprise
//        entrpers.setVisible(false);
//    } else {
//        // Si l'utilisateur n'est pas un candidat, afficher le champ entreprise
//        entrpers.setText(c.getEntreprise());
//    }
         
         
         
//         File file = new File("C:\\Users\\dell\\Pictures");
//        try {
//            URL url1 = file.toURI().toURL();
//////                     String imageUrl = "‪C:\\Users\\dell\\Pictures\\20180703190744-rollsafe-meme.jpeg";
//         Image img = new Image(url1.toString());
//         taswira.setImage(img);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(Compte2Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    

    @FXML
    private void goToCompte(MouseEvent event) {
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
    private void bouutnmodifiercompte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("modifiercompte2.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
    
    
    
    
     public void setImage(String imageUrl) {
    Image image = new Image(imageUrl);
    taswira.setImage(image);
}

    private void zidtaswira(ActionEvent event) {
        
          // Create a FileChooser dialog
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        // Set the file filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "."));

        // Show the dialog and wait for the user to select a file
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home"), "Images"));
        File file = fileChooser.showOpenDialog(eeltaswira.getScene().getWindow());

        // If a file was selected, load it into the ImageView
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            eeltaswira.setImage(image);
        }
        
    }

    private void bouutnajoutcompte(ActionEvent event) {
        
        try {
        Parent ajoutCompteParent = FXMLLoader.load(getClass().getResource("ajoutercompte2.fxml"));
        Scene ajoutCompteScene = new Scene(ajoutCompteParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ajoutCompteScene);
        window.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
        
    }
    
    
    
    
}

