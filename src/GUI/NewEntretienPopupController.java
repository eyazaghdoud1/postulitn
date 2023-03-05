/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.NewEntretiensController.es;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.Entretien;
import utilities.EtatCandidature;
import utilities.TypeEntretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewEntretienPopupController implements Initializable {

    @FXML
    private VBox entretienVB;
    @FXML
    private Label typeEntretien;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private TextField lieuTF;
    @FXML
    private Button modiferBtn;
    
    Date sqlDate;
    @FXML
    private Button deleteBtn;
    
    public static boolean isPresent=true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       SpinnerValueFactory<Integer> hourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
       hourSpinner.setValueFactory(hourFactory);
       hourSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
       // si la valeur est sup au max
       try {
        int newHourValue = Integer.parseInt(newValue);
        if (newHourValue < 0 || newHourValue > 23) {
            hourSpinner.getValueFactory().setValue(hourFactory.getValue());
        } else {
            hourFactory.setValue(newHourValue);
        }
       } catch (NumberFormatException e) {
        hourSpinner.getValueFactory().setValue(hourFactory.getValue());
    
      }
    });

      // minute spinner

      SpinnerValueFactory<Integer> minuteFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
      minuteSpinner.setValueFactory(minuteFactory);
      minuteSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      try {
        int newMinuteValue = Integer.parseInt(newValue);
        if (newMinuteValue < 0 || newMinuteValue > 59) {
            minuteSpinner.getValueFactory().setValue(minuteFactory.getValue());
        } else {
            minuteFactory.setValue(newMinuteValue);
        }
      } catch (NumberFormatException e) {
        minuteSpinner.getValueFactory().setValue(minuteFactory.getValue());
      }
    });
      /* initialisation des valeurs */
        hourSpinner.getValueFactory().setValue(0);
        minuteSpinner.getValueFactory().setValue(0);
        
         dateDP.setOnAction(e -> {
            LocalDate selectedDate = dateDP.getValue();
            sqlDate = Date.valueOf(selectedDate); 
        });
    }    

    @FXML
    private void modifierEntretien(ActionEvent event) {
       Entretien eupdate = new Entretien();
       eupdate.setDate(sqlDate);
       eupdate.setId(NewEntretiensController.selectedEntretien.getId());
       int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       eupdate.setHeure(horaire);
       eupdate.setLieu(lieuTF.getText());
       eupdate.setType(NewEntretiensController.selectedEntretien.getType());
       eupdate.setCandidature(NewEntretiensController.selectedEntretien.getCandidature());
       System.out.println("test: "+ lieuTF.getText());
       
       es.updateEntretien(NewEntretiensController.selectedEntretien.getId(), eupdate);
       /*System.out.println("local: " + eupdate);
       System.out.println("db: " + es.getEntretienById(NewEntretiensController.selectedEntretien.getId()) );*/
       
        /*try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewEntretiens.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage =  NewEntretiensController.popupWindow;
                  stage.setScene(scene);
                  
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
       
       NewEntretiensController.popupWindow.hide();*/
       //NewEntretiensController cont = new NewEntretiensController();
     
       isPresent=false;
       
    }
    
    public void setData(Entretien ent) {
         typeEntretien.setText(typeEntretien.getText() + ent.getType());
                             
          dateDP.setValue(ent.getDate().toLocalDate());
          String[] horaire = ent.getHeure().split(":");
          String heure = horaire[0];
          String minutes = horaire[1];
          hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
          minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
        if(ent.getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                        
           lieuTF.setDisable(true);
                        
        }
        else if(ent.getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
           lieuTF.setText(ent.getLieu());
         }
    }
   

    Alert alert;
    @FXML
    private void delete(ActionEvent event) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer cet entretien?");
                //alert.setContentText(("L'état de la candidature va changer."));

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                  alert.initOwner(entretienVB.getScene().getWindow());

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 //NewEntretiensController.es.deleteEntretien(NewEntretiensController.selectedEntretien.getId());
                 isPresent = false;
                 
                 
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
    }

    
}
