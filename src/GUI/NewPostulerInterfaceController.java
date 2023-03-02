/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Candidature;
import services.CandidatureService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewPostulerInterfaceController implements Initializable {

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
    private Label psteOffre;
    @FXML
    private Label descriptionOffre;
    @FXML
    private Label dateExpOffre;
    @FXML
    private Label experienceOffre;
    @FXML
    private VBox parentVB;
    @FXML
    private TextField cvText;
    @FXML
    private Button browseButton1;
    @FXML
    private TextField lettreText;
    @FXML
    private Button browseButton2;
    @FXML
    private Button postulerBtn;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cvText.textProperty().addListener((observable, oldValue, newValue) -> {
           postulerBtn.setDisable(newValue.trim().isEmpty() || lettreText.getText().trim().isEmpty());
        });

        lettreText.textProperty().addListener((observable, oldValue, newValue) -> {
          postulerBtn.setDisable(newValue.trim().isEmpty() || cvText.getText().trim().isEmpty());
        });
        postulerBtn.setDisable(true);
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
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
    }

    @FXML
    private void browse1(ActionEvent event) {
         FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseButton1.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        cvText.setText(file.getAbsolutePath());
    }

    @FXML
    private void browse2(ActionEvent event) {
         FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseButton2.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        lettreText.setText(file.getAbsolutePath());
    }

    @FXML
    private void postuler(ActionEvent event) {
        Candidature c = new Candidature();
        CandidatureService cs = new CandidatureService();
        c.setCv(cvText.getText());
        c.setLettre(lettreText.getText());
        //c.setIdCandidat(user.getId());
        c.setIdCandidat(4);
        //c.setIdOffre(offre.getId());
        c.setIdOffre(4);
        cs.addCandidature(c);
        
        /* redirection */
        try {
           Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatures.fxml"));
           System.out.println("FXML loaded successfully");
            
            Scene scene = new Scene(root);
            // Get the current stage
            Stage stage = (Stage) postulerBtn.getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
           
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void goBack(ActionEvent event) {
        //go back to offrespage
    }
    
}
