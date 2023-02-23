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
public class ModificationCandidatureController implements Initializable {

    @FXML
    private VBox parentVB;
    @FXML
    private Label dateLabel;
    @FXML
    private TextField cvTF;
    @FXML
    private Button browseButton1;
    @FXML
    private TextField lettreTF;
    @FXML
    private Button browseButton2;
    private Button retourBtn;
    @FXML
    private Button modifierBtn;
    
    private CandidatureService cs = new CandidatureService();

    //private Candidature selected = CandidatureItemController.selectedCandidature;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateLabel.setText(dateLabel.getText() + CandidatureItemController.selectedCandidature.getDate());
        cvTF.setText(CandidatureItemController.selectedCandidature.getCv());
        lettreTF.setText(CandidatureItemController.selectedCandidature.getLettre());
        
        cvTF.textProperty().addListener((observable, oldValue, newValue) -> {
           modifierBtn.setDisable(newValue.trim().isEmpty() );
        });

        lettreTF.textProperty().addListener((observable, oldValue, newValue) -> {
          retourBtn.setDisable(newValue.trim().isEmpty() );
        });
        modifierBtn.setDisable(true);
    }   

   @FXML
    private void browse1(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseButton1.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        cvTF.setText(file.getAbsolutePath());
    }
    
    @FXML
    private void browse2(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Stage stage = (Stage) browseButton2.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        lettreTF.setText(file.getAbsolutePath());
    }

    @FXML
    private void modifier(ActionEvent event) {
        Candidature cupdate = CandidatureItemController.selectedCandidature;
        cupdate.setCv(cvTF.getText());
        cupdate.setLettre(lettreTF.getText());
        cs.updateCandidature(cupdate.getId(), cupdate);
        this.retourner(event);
    }
    
    @FXML
    private void retourner(ActionEvent event) {
        try {
                  Parent root = FXMLLoader.load(getClass().getResource("./Candidatures.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) parentVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }
    
}
