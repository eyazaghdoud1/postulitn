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
import models.Entretien;
import services.EntretienService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class EntretienItemController implements Initializable {

    @FXML
    private Label dateLabel;
    @FXML
    private Label horaireLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label lieuLabel;

    //Entretien selectedE= EntretiensRecruteurController.selectedEnt;
    
    EntretienService es = new EntretienService();
    List<Entretien> ents = es.fetchEntretiens();
    Entretien selectedE = ents.get(EntretiensRecruteurController.entRecIndex);
    /**
     * Initializes the controller class.
     * @param e
     */
    
    public void setData(Entretien e) {
     dateLabel.setText(e.getDate().toString());
     horaireLabel.setText(e.getHeure());
     typeLabel.setText(e.getType());
     lieuLabel.setText(e.getLieu());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierEntretien(ActionEvent event) {
        
        EntretiensRecruteurController.modifOn = false;
       /* try {
                
               FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./ModificationEntretien.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-border-color:white;");
                ModificationEntretienController eic = fxmlLoader.getController();
                
               
                /*Scene scene = new Scene(hbox);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
               // eic.setData(e);
                //entretiensVB.getChildren().add(hbox);
               // listViewEnt.getItems().add(hbox);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         /*try {
                  Parent root = FXMLLoader.load(getClass().getResource("./AjoutEntretien.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }*/
    }

    @FXML
    private void annulerEntretien(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir annuler cet entretien?");
                //alert.setContentText("Action irréversible.");

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 es.deleteEntretien(selectedE.getId());
                 try {
                  Parent root = FXMLLoader.load(getClass().getResource("./EntretiensRecruteur.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
    }
    
}
