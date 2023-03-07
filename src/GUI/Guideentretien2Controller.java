/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import static GUI.GuideentretienController.guideUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.GuideEntretien;
import services.AuthenticationService;
import services.GuideEntretienService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class Guideentretien2Controller implements Initializable {
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
    private Text noteguide;
    @FXML
    private Text specguide;
    @FXML
    private Text domguide;
    
    public static GuideEntretien guideUser;
    

     private Pane pane;
 
    private AnchorPane mainAnchorPane;


javafx.scene.media.MediaPlayer mediaPlayer;

 GuideEntretienService ges = new GuideEntretienService();
    @FXML
    private Button noteBtn;
    @FXML
    private Button modifierBtn;
    @FXML
    private VBox supprimerBox;
    @FXML
    private VBox container;
    @FXML
    private MediaView mediaView;
    
    public static GuideEntretien thisGuide;
    @FXML
    private Button backBtn;
    
    TestmenubarController mbc = new TestmenubarController();
    /**
     * 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        //mbc.setConnectedUser();
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
        
        
        
//        URL u;
//        try {
//            u = new URL("http://localhost/postulitn/images/"+"check-icon.png");
//             Image image = new Image(u.toString());
//              userPhoto.setImage(image);
//             
//        
//           
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            // TODO
// String videoPath = "C:\\Users\\dell\\Downloads\\guide1.mp4";
//videoPath = videoPath.replaceAll("\\\\", "/");
//Media media = new Media(new File(videoPath).toURI().toString());
//MediaPlayer mediaPlayer = new MediaPlayer(media);
//MediaView mediaView = new MediaView(mediaPlayer);


            
//            GuideEntretienService ges = new GuideEntretienService();
//            GuideEntretien ge =ges.GetByIdGuideEntretiens(13);
//            guideUser= ge;
            
            thisGuide = ges.GetByIdGuideEntretiens(ListeguideController.selectedGuide.getIdguide());
            domguide.setText(thisGuide.getDomaine());
            specguide.setText(thisGuide.getSpecialite());
            noteguide.setText((int) thisGuide.getNote() + "");

            /*Media media = new Media(new File("C:\\Users\\dell\\Downloads\\guide1.mp4").toURI().toString());  
            
          
            mediaPlayer = new MediaPlayer(media);  
            mediaView.setMediaPlayer(mediaPlayer);
            //container.getChildren().add(mediaView);
            //mediaPlayer.setAutoPlay(true);  
            System.out.println(media);*/
            
            /********************** role controle *************************/
            if (AuthenticationService.roleconnecte.getDescription().equals("Recruteur")) {
              noteBtn.setVisible(false);
               supprimerBox.setVisible(true);
            modifierBtn.setVisible(true);
            } else if (AuthenticationService.roleconnecte.getDescription().equals("Candidat")) {
              supprimerBox.setVisible(false);
            modifierBtn.setVisible(false);
            noteBtn.setVisible(true);
            }
            
            
        
        
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
    private void donnernote(ActionEvent event) throws IOException {
        
        /*  Parent root = FXMLLoader.load(getClass().getResource("notationguide.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();*/
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i=0; i<=10; i++) {
         comboBox.getItems().add(i);
        }
        //Button confirmButton = new Button("Confirm");
        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(comboBox);
        vbox.setAlignment(Pos.CENTER);
        
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Noter guide d'entretien");
                //alert.setHeaderText("Etes-vous sures de vouloir supprimer cet entretien?");
                alert.getDialogPane().setContent(vbox);

                ButtonType buttonTypeYes = new ButtonType("Confimer");
                ButtonType buttonTypeNo = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                   

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 // int idGuide = Integer.parseInt(idguidepn.getText()); // récupérer l'identifiant du guide entretien à partir d'un champ de saisie
       double note = (double) comboBox.getValue();
                
        GuideEntretien ge = ges.GetByIdGuideEntretiens(ListeguideController.selectedGuide.getIdguide()); 
        if (ge != null) { 
            ges.ajouterNote(note, ge);
            System.out.println(note);
            
             Parent root = FXMLLoader.load(getClass().getResource("guideentretien2.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Le guide entretien avec l'identifiant " + ListeguideController.selectedGuide.getIdguide() + " n'a pas été trouvé dans la base de données.");
        }
                
 
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
        
    }

    @FXML
    private void btnmodguide(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("modifierguide2.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Guideentretien2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void iconesupp(MouseEvent event) throws IOException {
        
    GuideEntretienService ges = new GuideEntretienService();
    
    
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Suppression de guide");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer ce guide?");
                

                ButtonType buttonTypeYes = new ButtonType("Confimer");
                ButtonType buttonTypeNo = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
             ges.deleteGuideEntretien(Guideentretien2Controller.thisGuide);
            
            Parent root = FXMLLoader.load(getClass().getResource("listeguide.fxml"));
           Scene scene = new Scene(root);
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(scene);
            stage.show();
        } else {
             alert.close();
        }

    }
    
    
/*private void loadVideo(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("C:\\\\Users\\\\dell\\\\Downloads\\\\guide1.mp4");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.m4v", "*.flv", "*.avi", "*.mkv"));
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null) {
        Media media = new Media(selectedFile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }
}*/

    @FXML
    private void play(MouseEvent event) {
      if (mediaPlayer != null) {
if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
mediaPlayer.pause();
} else {
mediaPlayer.play();
}
}
    }

    @FXML
    private void goBack(ActionEvent event) {
        
          
           try {
        Parent root = FXMLLoader.load(getClass().getResource("listeguide.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }


    
    
    
    
}
