/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.OffreService;
import models.Offre;
import models.Typeoffre;
import services.TypeoffreService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class AjouteroffreController implements Initializable {

    @FXML
    private TextField postetf;
    @FXML
    private TextField descriptiontf;
    @FXML
    private TextField lieutf;
    @FXML
    private TextField entreprisetf;
    @FXML
    private TextField specialitetf;
    @FXML
    private DatePicker dateD;
    @FXML
    private ComboBox typetf;
    
    @FXML
    private Label f;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @FXML
    private Label erreurposte;
    @FXML
    private Label erreurdescription;
    @FXML
    private Label erreurlieu;
    @FXML
    private Label erreurentreprise;
    @FXML
    private Label erreurspecialite;
    @FXML
    private Label erreurdate;
    private Label labell;

     TypeoffreService tos = new TypeoffreService();
      OffreService os = new OffreService();
      String typeSelectionne;
     
    /**
     * Initializes the controller class.
     * @param url
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        List<Typeoffre> to = tos.fetchOffres();
        for(Typeoffre t :to)  {
        typetf.getItems().add(t.getDescription());
        }
        typetf.setOnAction(e -> {typeSelectionne=typetf.getValue().toString();});
        
        OffreService os = new OffreService();

    }    

    @FXML
    private void ajouteroffre(ActionEvent event) throws SQLException {
//        
        TypeoffreService ts = new TypeoffreService();      
   if(!validateDatePicker(dateD)  && !controleTextFieldNomEtPrenom(postetf,descriptiontf) )   {           //|| controleTextFieldMAIL(specialitetf)

//                    }
    LocalDate selectedDate = dateD.getValue();
//
//// Check if a date has been selected
//if (selectedDate == null) {
//    erreurdate.setText("Date non valide !");
//    erreurdate.setVisible(true);
//    return;
//}

// Convert the selected date to a string if needed
String dateString = selectedDate.toString();




   //TypeoffreService ts = new TypeoffreService();
    Offre o = new Offre();
   
    //Typeoffre to = ts.getelementbyid(4);
    
    
    
    o.setPoste(postetf.getText());
        o.setDescription(descriptiontf.getText());
        o.setLieu(lieutf.getText());
        o.setEntreprise(entreprisetf.getText());
        o.setSpecialite(specialitetf.getText());
        o.setDateExpiration(Date.valueOf(dateD.getValue()));
        o.setType(tos.getelementbydescription(typeSelectionne));
        // selectedValue = (String) typetf.getValue();
         //   o.setType(ts.getelementbydescription(selectedValue));
        
       
    
    //o.setDateExpiration(Date.valueOf("2024-11-19"));
       // o.setType((Typeoffre) to);
        o.setIdRecruteur(5);
        System.out.println(o);
        os.addOffre(o);
       // System.out.println(os.fetchOffres().get(0));
        
    String tilte = "Offre Ajoute";
            String message = postetf.getText();
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
        
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
    
   }
   else if(validateDatePicker(dateD)) {
        String tilte = "offre n est pas ajoute";
            String message = "entrer la date d expiration";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
        
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
       
    }
   else if(controleTextFieldNomEtPrenom(postetf,descriptiontf)) {
        String tilte = "offre n est pas ajoute";
            String message = "il est interdit de meettre des numeros dans le champs poste et description ";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
        
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
       
    }
    
    
    
//    showAll();
    
    
    
    }
        public boolean validateDatePicker(DatePicker date)
    {
          if(date.getEditor().getText().isEmpty())
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir votre date de naissance ");
            alert.showAndWait();
            return true;
         }
           return false;
        }
    
    
    public boolean controleTextFieldNomEtPrenom(TextField textField1,TextField textField) {
        if (textField1.getText().matches(".*[0-9].*")||textField.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("c'est interdit d'inserer un numero dans poste nom ou description");
            alert.showAndWait();
            return true;
        }
             return false;}

    @FXML
    private void liste(ActionEvent event) {
        try {Parent Liste = FXMLLoader.load(getClass().getResource("../gui/lesoffres.fxml"));
            Scene si = new Scene(Liste);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    

}
 


   
    

