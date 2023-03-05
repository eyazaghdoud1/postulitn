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
    
//    Media media = new Media("file:///path/to/video.mp4");
//    MediaPlayer mediaPlayer = new MediaPlayer(media);
//    MediaView mediaView = new MediaView(mediaPlayer);
//    Pane pane = new Pane();
//    pane.getChildren().add(mediaView);
     private Pane pane;
    /* private MediaView mediaView;
    private MediaPlayer mediaPlayer;*/
    private AnchorPane mainAnchorPane;
    @FXML
    private VBox supprimerBox;
    @FXML
    private Button noteBtn;
    @FXML
    private Button modifierBtn;
    @FXML
    private VBox container;
    @FXML
    private MediaView mediaView;


javafx.scene.media.MediaPlayer mediaPlayer;
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
// String videoPath = "C:\\Users\\dell\\Downloads\\guide1.mp4";
//videoPath = videoPath.replaceAll("\\\\", "/");
//Media media = new Media(new File(videoPath).toURI().toString());
//MediaPlayer mediaPlayer = new MediaPlayer(media);
//MediaView mediaView = new MediaView(mediaPlayer);


            
//            GuideEntretienService ges = new GuideEntretienService();
//            GuideEntretien ge =ges.GetByIdGuideEntretiens(13);
//            guideUser= ge;
            
            domguide.setText(ListeguideController.selectedGuide.getDomaine());
            specguide.setText(ListeguideController.selectedGuide.getSpecialite());
            noteguide.setText((int) ListeguideController.selectedGuide.getNote() + "");

            Media media = new Media(new File("C:\\Users\\dell\\Downloads\\guide1.mp4").toURI().toString());  
            mediaPlayer = new MediaPlayer(media);  
            mediaView.setMediaPlayer(mediaPlayer);
            //container.getChildren().add(mediaView);
            //mediaPlayer.setAutoPlay(true);  
            System.out.println(media);
            
            
        
        
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
    private void donnernote(ActionEvent event) throws IOException {
        
          Parent root = FXMLLoader.load(getClass().getResource("notationguide.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
        
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
    ges.deleteGuideEntretien(ListeguideController.selectedGuide);
    
    Parent root = FXMLLoader.load(getClass().getResource("listeguide.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
        
        
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
    
    
    
    
}
