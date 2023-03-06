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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Compte;
import models.Utilisateur;
import services.AuthenticationService;
import services.CompteServices;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCompteController implements Initializable {
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
    public static CompteServices comptes = new CompteServices();;
    public static Compte compteUser = AuthenticationService.compteconnecte;
    //Compte visitedCompte;
    private ImageView taswira;
    @FXML
    private Label domainetf;
    @FXML
    private Label postetf;
    @FXML
    private ImageView eeltaswira;
    @FXML
    private Button modifBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView backbtn;
    @FXML
    private Text nomPrenom;
    @FXML
    private Label email;
    @FXML
    private Label tel;
    @FXML
    private Label datenaissance;
    @FXML
    private HBox expHB;
    @FXML
    private HBox dipHB;
    @FXML
    private HBox datdipHB;
    @FXML
    private HBox entHB;
    @FXML
    private HBox domHB;
    @FXML
    private HBox posteHB;
 Compte c;
    /**
     * Initializes the controller class.
     */
    CompteServices cservices = new CompteServices();
    UtilisateurService us = new UtilisateurService();
      MenuBarController mbc= new MenuBarController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        //compteUser 
        // mbc.setConnectedUser();
         System.out.println(AuthenticationService.compteconnecte);
                   System.out.println(AuthenticationService.userconnecte);
           
         
            
            backBtn.setVisible(false);
            c = AuthenticationService.compteconnecte;
               modifBtn.setVisible(true); 
       if (NewCandidatureEntretienInterfaceController.compteToVisit != null) {
          c=NewCandidatureEntretienInterfaceController.compteToVisit;
            modifBtn.setVisible(false);   
           // backBtn.setVisible(true);
                  ;}
         //compteUser= c; } 
        /* else {
               c = AuthenticationService.compteconnecte;
               modifBtn.setVisible(true); 
              // backBtn.setVisible(false);
                 }*/
       
        /**********getting the user from compte *******************/
       Utilisateur user = us.GetByIdUser(c.getIdUser());
       
//        URL u;
//       if (compteUser.getPhoto() == null) {
//             try {
//                 u = new URL("http://localhost/postulitn/images/"+ "defaultuser.png");
//                Image image = new Image(u.toString());
//                userPhoto.setImage(image);
//             } catch (MalformedURLException ex) {
//                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//             }
//       } 
//       else {
//    try {
//        u = new URL("http://localhost/postulitn/images/"+ compteUser.getPhoto());
//         Image image = new Image(u.toString());
//        userPhoto.setImage(image);
//        
//    } catch (MalformedURLException ex) {
//        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//       }    

        
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
        //System.out.println(AuthenticationService.userconnecte.getNom());
         
         
          URL u2;
          if (c.getPhoto() == null) {
             try {
                 u2 = new URL("http://localhost/postulitn/images/"+ "defaultuser.png");
                Image image = new Image(u2.toString());
                 eeltaswira.setImage(image);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } else {
    try {
        u2 = new URL("http://localhost/postulitn/images/"+ c.getPhoto());
         Image image2 = new Image(u2.toString());
        //userPhoto.setImage(image2);
         eeltaswira.setImage(image2);
        
    } catch (MalformedURLException ex) {
        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
    }
          }
         nomPrenom.setText(user.getNom() + " " + user.getPrenom());
         email.setText( user.getEmail());
         tel.setText(user.getTel());
         
        
       //  cvpers.setText(c.getCv());
         //************HOOOOOOO      NAHI ENTREPRISE COMM *******
         
         domainetf.setText(c.getDomaine());
         
         
         if (user.getRole().getDescription().equals("Candidat")){
         exppers.setText(c.getExperience()); 
         diplomepers.setText(c.getDiplome());
         ddippers.setText("" + c.getDateDiplome());
         entHB.setVisible(false);
         posteHB.setVisible(false);
         }
         else if (user.getRole().getDescription().equals("Recruteur")){
             entrpers.setText(c.getEntreprise());
              postetf.setText(c.getPoste());
              expHB.setVisible(false);
              dipHB.setVisible(false);
              datdipHB.setVisible(false);
         }
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
    
    
   /* public void setVisitedUser(Compte visited) {
       visitedCompte= visited;
    }*/

  

    @FXML
    private void goBack(MouseEvent event) {
          
        try {
        Parent ajoutCompteParent = FXMLLoader.load(getClass().getResource("NewCandidatureEntretienInterface.fxml"));
        Scene ajoutCompteScene = new Scene(ajoutCompteParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(ajoutCompteScene);
        window.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void goBack(ActionEvent event) {
    }
    

    
}
