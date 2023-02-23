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
import javafx.scene.control.TextField;
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
public class AddCandidatureController implements Initializable {

    @FXML
    private TextField cvText;
    @FXML
    private TextField lettreText;
    
    CandidatureService cs = new CandidatureService();
    private Candidature c;
    

    @FXML
    private Button browseButton1;
    
    @FXML
    private Button browseButton2;
    @FXML
    private VBox parentVB;
    @FXML
    private Button postulerBtn;
    @FXML
    private Button change;

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
    private void postuler(ActionEvent event) {
        c = new Candidature();
        c.setCv(cvText.getText());
        c.setLettre(lettreText.getText());
        //c.setIdCandidat(user.getId());
        c.setIdCandidat(4);
        //c.setIdOffre(offre.getId());
        c.setIdOffre(3);
        cs.addCandidature(c);
        
        /* redirection */
        try {
           Parent root = FXMLLoader.load(getClass().getResource("./Candidatures.fxml"));
           System.out.println("FXML loaded successfully");
            
            Scene scene = new Scene(root);
            // Get the current stage
            Stage stage = (Stage) postulerBtn.getScene().getWindow();

        // Set the new scene as the current scene for the stage
        
        stage.setScene(scene);
        stage.show();
           
        } catch (IOException e) {
        e.printStackTrace();
    }

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
    private void changeScene(ActionEvent event) {
         try {
           Parent root = FXMLLoader.load(getClass().getResource("./GUI/Candidatures.fxml"));
           System.out.println("FXML loaded successfully");
            
           Scene scene = new Scene(root);
           Stage stage = (Stage) change.getScene().getWindow();
            //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Set the new scene as the current scene for the stage
        
        stage.setScene(scene);
        stage.show();
           
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
