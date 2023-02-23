/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Candidature;
import models.Entretien;
import services.CandidatureService;
import services.EntretienService;
import utilities.TypeEntretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class AjoutEntretienController implements Initializable {

    @FXML
    private VBox sideVB;
    @FXML
    private VBox entretienVB;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private ComboBox<String> typeEntretienCB;
    @FXML
    private TextField lieuTF;
    
    private Date sqlDate;
    private String selectedType;
    @FXML
    private Label dateEntTel;
    @FXML
    private Label heureEntTel;
    @FXML
    private Label dateEntPres;
    @FXML
    private Label heureEntPres;
    @FXML
    private Label lieuEntPres;
    
    //Candidature c = CandidaturesRecruteurController.recCandvalidee; 
    EntretienService es = new EntretienService();
    //CandidatureService cs = new CandidatureService();
    @FXML
    private VBox entTelVB;
    @FXML
    private VBox entPresVb;
    @FXML
    private HBox entTelVideHB;
    @FXML
    private HBox entPresVideHB;
    @FXML
    private Button modifierBtn1;
    @FXML
    private Button modifierBtn2;

    Entretien eTel;
    Entretien ePres;
    Entretien eModif;
    @FXML
    private Button modiferBtn;
    @FXML
    private Button enregistrerBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // hour spinner
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
        
        typeEntretienCB.getItems().addAll(TypeEntretien.TypeE.Téléphone.toString(),
                TypeEntretien.TypeE.Présentiel.toString());
        // Ajouter un événement de sélection d'élément
        typeEntretienCB.setOnAction(e -> {
            selectedType = typeEntretienCB.getValue();
           
        });
        
        dateDP.setOnAction(e -> {
            LocalDate selectedDate = dateDP.getValue();
            sqlDate = Date.valueOf(selectedDate);
            
        });
        
        // initialisation des valeurs des entretiens de la candidature concernée
        //List<Entretien> e = es.filterByCandidature(CandidaturesRecruteurController.recCandvalidee.getId());
       // List<Entretien> e = es.filterByCandidature(2);
       List<Entretien> e = CandEntValideeItemController.e;
        switch (e.size()) {
            case 2:
                entretienVB.setVisible(false);
                //modiferBtn.setVisible(false);
                for (Entretien ent: e) {
                    if(ent.getType().equals("Téléphone")) {
                        
                        dateEntTel.setText(dateEntTel.getText() + " " + ent.getDate()  );
                        heureEntTel.setText(heureEntTel.getText() + " " + ent.getHeure());
                        eTel = ent;
                    }
                    else if(ent.getType().equals("Présentiel")) {
                        
                        dateEntPres.setText(dateEntPres.getText() + " " + ent.getDate() );
                        heureEntPres.setText(heureEntPres.getText() + " " + ent.getHeure() );
                        lieuEntPres.setText(lieuEntPres.getText() + " " + ent.getLieu());
                        ePres = ent;
                    }
                }    break;
            case 1:
                modiferBtn.setVisible(false);
                if (e.get(0).getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
                    dateEntTel.setVisible(false);
                    heureEntTel.setVisible(false);
                    modifierBtn1.setVisible(false);
                    Label l1 = new Label("Aucun entretien par téléphone n'est programmé.");
                    entTelVideHB.getChildren().add(l1);
                    ePres= e.get(0);
                    lieuTF.setDisable(true);
                    //typeEntretienCB.setValue(typeEntretienCB.getItems().get(0));
                    
                }  if (e.get(0).getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                    dateEntPres.setVisible(false);
                    heureEntPres.setVisible(false);
                    lieuEntPres.setVisible(false);
                    modifierBtn2.setVisible(false);
                    Label l2 = new Label("Aucun entretien en présentiel n'est programmé.");
                    entPresVideHB.getChildren().add(l2);
                    eTel=e.get(0);
                    //typeEntretienCB.setValue(typeEntretienCB.getItems().get(1));
                    
                }  break;
            default:
                System.out.println("pas d'entretiens");
                break;
        }
        System.out.println(e);
        //candId.setText(candId.getText() + " : " + CandidaturesRecruteurController.recCandvalidee.getId());
    }    


    @FXML
    private void enregistrerEntretien(ActionEvent event) {

       int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       System.out.println("Date sélectionnée : " + sqlDate);
       System.out.println("Selected time: " + hour + ":" + minute);
       System.out.println("Element sélectionné : " + selectedType);
       System.out.println("Lieu : " + lieuTF.getText());
     
       Entretien e = new Entretien(CandEntValideeItemController.c,
                 selectedType, sqlDate, horaire, lieuTF.getText(), 1);
       es.addEntretien(e);
    }

    @FXML
    private void modifierEntretienTel(ActionEvent event) {
        //System.out.println(eTel.getCandidature());
      entretienVB.setVisible(true);
      
      dateDP.setValue(eTel.getDate().toLocalDate());
     
     String[] horaire = eTel.getHeure().split(":");
     String heure = horaire[0];
     String minutes = horaire[1];
     hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
     minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
     typeEntretienCB.setValue(typeEntretienCB.getItems().get(0));
     eModif = eTel;
     lieuTF.setDisable(true);
     modiferBtn.setVisible(true);
     enregistrerBtn.setDisable(true);
     
    
    }
    
    @FXML
    private void modifierEntretienPres(ActionEvent event) {
     entretienVB.setVisible(true);
     lieuTF.setDisable(false);
     dateDP.setValue(ePres.getDate().toLocalDate());
     
     String[] horaire = ePres.getHeure().split(":");
     String heure = horaire[0];
     String minutes = horaire[1];
     hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
     minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
     typeEntretienCB.setValue(typeEntretienCB.getItems().get(1));
     lieuTF.setText(ePres.getLieu());
     eModif= ePres;
     modiferBtn.setVisible(true);
     enregistrerBtn.setDisable(true);
     
    }

    @FXML
    private void modifierEntretien(ActionEvent event) {
       Entretien eupdate = new Entretien();
       eupdate.setDate(sqlDate);
       eupdate.setId(eModif.getId());
       int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       eupdate.setHeure(horaire);
       eupdate.setLieu(lieuTF.getText());
       eupdate.setType(eModif.getType());
       eupdate.setCandidature(CandEntValideeItemController.c);
       System.out.println("test: "+ lieuTF.getText());
       
       es.updateEntretien(eModif.getId(), eupdate);
       System.out.println("local: " + eupdate);
       System.out.println("db: " + es.getEntretienById(eModif.getId()) );
       
          try {
              
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
        
    }

    @FXML
    private void back(ActionEvent event) {
          try {
              
                  Parent root = FXMLLoader.load(getClass().getResource("./CandidaturesRecruteur.fxml"));
                  
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException ex) {
                      ex.printStackTrace();
                 }
    }
    
    
    
}
