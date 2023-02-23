/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.OffreService;
import models.Offre;
import models.Typeoffre;
import services.TypeoffreService;
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
       
       // TODO
          //ObservableList<String> list = FXCollections.observableArrayList("JavaFX","SceneBuilder","Laravel","Python");
            //     typetf.setItems(list);
          //  typeEntretienCB.getItems().addAll(TypeEntretien.TypeE.Téléphone.toString(),
          
               //typetf.getItems().addAll(listeIds);

       
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
//        
//      //  Player init;
//         Offre o = new Offre();
//        Typeoffre to = ts.getelementbyid(4);
//        OffreService os = new OffreService();
//        o.setPoste(postetf.getText());
//        o.setDescription(descriptiontf.getText());
//        o.setLieu(lieutf.getText());
//        o.setEntreprise(entreprisetf.getText());
//        o.setSpecialite(specialitetf.getText());
//        o.setDateExpiration(Date.valueOf("2024-11-19"));
//        o.setType(to);
//        o.setIdRecruteur(5);
//
//
//        os.addOffre(o);




   if(!validateDatePicker(dateD)  && !controleTextFieldNomEtPrenom(postetf,descriptiontf) )   {           //|| controleTextFieldMAIL(specialitetf)
//    if (postetf.getText().isEmpty())
//         {
//                        erreurposte.setText("poste non valide !");
//                        erreurposte.setVisible(true);
//                        
//                        return;
//                    }
//    if (descriptiontf.getText().isEmpty())
//         {
//                        erreurdescription.setText("Description non valide !");
//                        erreurdescription.setVisible(true);
//                        
//                        return;
//                    }
//     if (lieutf.getText().isEmpty())
//         {
//                        erreurlieu.setText("lieu non valide !");
//                        erreurlieu.setVisible(true);
//                        
//                        return;
//                    }
//      if (entreprisetf.getText().isEmpty())
//         {
//                        entreprisetf.setText("entreprise non valide !");
//                        entreprisetf.setVisible(true);
//                        
//                        return;
//                    }
//      if (specialitetf.getText().isEmpty())
//         {
//                        specialitetf.setText("specialite non valide !");
//                        specialitetf.setVisible(true);
//                        
//                        return;
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
    /* public boolean controleTextFieldNonNumerique(TextField textField) {
        if (textField.getText().matches(".*[a-zA-Z].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("veuillez saisir que des entiers!");
            alert.showAndWait();
            return true;
        }
             return false;}
   */ 
    public boolean controleTextFieldNomEtPrenom(TextField textField1,TextField textField) {
        if (textField1.getText().matches(".*[0-9].*")||textField.getText().matches(".*[0-9].*")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("c'est interdit d'inserer un numero dans poste nom ou description");
            alert.showAndWait();
            return true;
        }
             return false;}

}
 
//       /*public boolean controleTextFieldMAIL(TextField textField) {
//        if (!textField.getText().contains("@")) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("Votre adresse mail est invalide");
//            alert.showAndWait();
//            return true;
//        }
//             return false;}
//*/
////    private void checkinput(javafx.scene.input.KeyEvent event) {
////      if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
////            event.consume();
////            
////            lieutf.setStyle("-fx-border-color: red");
////        }else{
////            lieutf.setStyle("-fx-border-color: green");
////        }
////    }
//}

   
    

