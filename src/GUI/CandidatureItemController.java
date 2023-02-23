/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Candidature;
import services.CandidatureService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class CandidatureItemController implements Initializable {

    @FXML
    private Label offreLabel;
    @FXML
    private Label typeOffreLabel;
    @FXML
    private Label etatLabel;

    public static Candidature selectedCandidature;
    private CandidatureService cs = new CandidatureService();
    List<Candidature> cands = cs.fetchCandidatures();
    /**
     * Initializes the controller class.
     */
     public void setData(Candidature c) {
     offreLabel.setText("Offre designation" );
     typeOffreLabel.setText("Type");
     etatLabel.setText(c.getEtat().toString());
     

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierCandidature(ActionEvent event) {
                selectedCandidature = cands.get(CandidaturesController.candIndex);
                try {
                  Parent root = FXMLLoader.load(getClass().getResource("./ModificationCandidature.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
            
                //System.out.println(e);
                
                
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
              
    }

    @FXML
    private void annulerCandidature(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir annuler cette candidature?");
                //alert.setContentText("This action cannot be undone.");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // User clicked "Yes"
                 cs.deleteCandidature(selectedCandidature.getId());
                 try {
                  Parent root = FXMLLoader.load(getClass().getResource("./Candidatures.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
                } else {
                 // User clicked "No" or closed the dialog
                 alert.close();
                }
    }
    
}
