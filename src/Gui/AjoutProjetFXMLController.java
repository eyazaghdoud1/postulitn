/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import Models.Secteur;
import interfaces.ProjetInterface;
import interfaces.SecteurInterface;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ProjetServices;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.Alert;
import services.SecteurServices;


/**
 * FXML Controller class
 *
 * @author Users
 */
public class AjoutProjetFXMLController implements Initializable {

    @FXML
    private TextField themeTF;
    @FXML
    private TextField dureeTF;
    @FXML
    private ComboBox<String> secteurCB;
    @FXML
    private DatePicker datedebutDP;
    @FXML
    private DatePicker datefinDP;
    @FXML
    private TextField descriptionTF;
    private Label erreurtheme;
    private Label erreurdescription;
    private Label erreurduree;
    private Label erreurdate;
    
    private String SecteurSelectionne; 
  

    
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    /**
     * Initializes the controller class.
     */
    ProjetInterface ps = new ProjetServices();
    
  SecteurServices ss = new SecteurServices();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Secteur> ls = ss.fetchSecteur();
        for(int i=0; i<ls.size(); i++ )  {
        secteurCB.getItems().addAll(ls.get(i).getDescription());
        }
        secteurCB.setOnAction(e -> {SecteurSelectionne=secteurCB.getValue();});
      
        // TODO
    }    

    @FXML
    private void addProjet(ActionEvent event) {
       
        
          ProjetFreelance p = new ProjetFreelance(); 
   if(validateDatePicker(datedebutDP) && validateDatePicker(datefinDP) && controleTextField(themeTF) && controleTextField(descriptionTF) && controleTextFieldDuree(dureeTF) )     {
    if (themeTF.getText().isEmpty())
         {
                        erreurtheme.setText("theme non valide !");
                        erreurtheme.setVisible(true);
                        
                        return;
                    }
    if (descriptionTF.getText().isEmpty())
         {
                        erreurdescription.setText("Description non valide !");
                        erreurdescription.setVisible(true);
                        
                        return;
                    }
     if (dureeTF.getText().isEmpty())
         {
                        erreurduree.setText("duree non valide !");
                        erreurduree.setVisible(true);
                        
                        return;
                    }
   
         LocalDate selectedDate = datedebutDP.getValue();
        LocalDate selectedDate1 = datefinDP.getValue();
        String dateString = selectedDate.toString();
      //  ProjetFreelance p = new ProjetFreelance();
        SecteurServices ss = new SecteurServices();
        Secteur s = ss.getById(18);
        p.setDuree(Integer.parseInt(dureeTF.getText()));
        p.setTheme(themeTF.getText());
        p.setDescription(descriptionTF.getText());     
        p.setDateDebut(Date.valueOf(datedebutDP.getValue()));
        p.setDateFin(Date.valueOf(datedebutDP.getValue()));
        p.setS(ss.getsecteurbydescription(SecteurSelectionne));
        ps.addProjet(p);
        

    }
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
      public boolean controleTextField(TextField textField1) {
        if (textField1.getText().matches(".*[a-z] || [A-Z].*")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("la case ne peut contenir que des lettres");
            alert.showAndWait();
            return true;
        }
             return false;
}
        
        public boolean controleTextFieldDuree(TextField textField1) {
        if (textField1.getText().matches(".*[0-9].*")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("vous ne pouvez inserer que des chiffres");
            alert.showAndWait();
            return true;
        }
             return false;}
}

































































































































































    

    /*  
     */
     

//**********************************************************************************************************************************************
//package GUI;
//
//
//
///**
// * FXML Controller class
// *
// * @author Aziz Ben Guirat
// */
//public class AjouteroffreController implements Initializable {
//
//    @FXML
//    private TextField postetf;
//    @FXML
//    private TextField descriptiontf;
//    @FXML
//    private TextField lieutf;
//    @FXML
//    private TextField entreprisetf;
//        @FXML
//    private TextField specialitetf;
//    @FXML
//    private DatePicker dateD;
//    @FXML
//    private ComboBox typetf;
//    
//    @FXML
//    private Label f;
//    
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    @FXML
//    private Label erreurposte;
//    @FXML
//    private Label erreurdescription;
//    @FXML
//    private Label erreurlieu;
//    @FXML
//    private Label erreurentreprise;
//    @FXML
//    private Label erreurspecialite;
//    @FXML
//    private Label erreurdate;
//    private Label labell;
//
//     TypeoffreService tos = new TypeoffreService();
//      OffreService os = new OffreService();
//      String typeSelectionne;
//     
//    /**
//     * Initializes the controller class.
//     * @param url
//     */
//    
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//       
//       // TODO
//          //ObservableList<String> list = FXCollections.observableArrayList("JavaFX","SceneBuilder","Laravel","Python");
//            //     typetf.setItems(list);
//          //  typeEntretienCB.getItems().addAll(TypeEntretien.TypeE.Téléphone.toString(),
//          
//               //typetf.getItems().addAll(listeIds);
//
//       
//       List<Typeoffre> to = tos.fetchOffres();
//        for(Typeoffre t :to)  {
//        typetf.getItems().add(t.getDescription());
//        }
//        typetf.setOnAction(e -> {typeSelectionne=typetf.getValue().toString();});
//        
//        OffreService os = new OffreService();
//
//    }    
//
//    @FXML
//    private void ajouteroffre(ActionEvent event) throws SQLException {
////        
//        TypeoffreService ts = new TypeoffreService();
////        
////      //  Player init;
////         Offre o = new Offre();
////        Typeoffre to = ts.getelementbyid(4);
////        OffreService os = new OffreService();
////        o.setPoste(postetf.getText());
////        o.setDescription(descriptiontf.getText());
////        o.setLieu(lieutf.getText());
////        o.setEntreprise(entreprisetf.getText());
////        o.setSpecialite(specialitetf.getText());
////        o.setDateExpiration(Date.valueOf("2024-11-19"));
////        o.setType(to);
////        o.setIdRecruteur(5);
////
////
////        os.addOffre(o);
//
//
//
//
////   if(validateDatePicker(dateD) && controleTextFieldNomEtPrenom(postetf,descriptiontf)  )     {           //|| controleTextFieldMAIL(specialitetf)
////    if (postetf.getText().isEmpty())
////         {
////                        erreurposte.setText("poste non valide !");
////                        erreurposte.setVisible(true);
////                        
////                        return;
////                    }
////    if (descriptiontf.getText().isEmpty())
////         {
////                        erreurdescription.setText("Description non valide !");
////                        erreurdescription.setVisible(true);
////                        
////                        return;
////                    }
////     if (lieutf.getText().isEmpty())
////         {
////                        erreurlieu.setText("lieu non valide !");
////                        erreurlieu.setVisible(true);
////                        
////                        return;
////                    }
////      if (entreprisetf.getText().isEmpty())
////         {
////                        entreprisetf.setText("entreprise non valide !");
////                        entreprisetf.setVisible(true);
////                        
////                        return;
////                    }
////      if (specialitetf.getText().isEmpty())
////         {
////                        specialitetf.setText("specialite non valide !");
////                        specialitetf.setVisible(true);
////                        
////                        return;
////                    }
//    LocalDate selectedDate = dateD.getValue();
////
////// Check if a date has been selected
////if (selectedDate == null) {
////    erreurdate.setText("Date non valide !");
////    erreurdate.setVisible(true);
////    return;
////}
//
//// Convert the selected date to a string if needed
//String dateString = selectedDate.toString();
//
//
//
//
//   //TypeoffreService ts = new TypeoffreService();
//    Offre o = new Offre();
//   
//    //Typeoffre to = ts.getelementbyid(4);
//    
//    
//    
//    o.setPoste(postetf.getText());
//        o.setDescription(descriptiontf.getText());
//        o.setLieu(lieutf.getText());
//        o.setEntreprise(entreprisetf.getText());
//        o.setSpecialite(specialitetf.getText());
//        o.setDateExpiration(Date.valueOf(dateD.getValue()));
//        o.setType(tos.getelementbydescription(typeSelectionne));
//        // selectedValue = (String) typetf.getValue();
//         //   o.setType(ts.getelementbydescription(selectedValue));
//        
//       
//    
//    //o.setDateExpiration(Date.valueOf("2024-11-19"));
//       // o.setType((Typeoffre) to);
//        o.setIdRecruteur(5);
//        System.out.println(o);
//        os.addOffre(o);
//    
//    
//   }
//    
//    
//    
////    showAll();
//    
//    
//    
//    }
////        public boolean validateDatePicker(DatePicker date)
////    {
////          if(date.getEditor().getText().isEmpty())
////         {
////            Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setHeaderText(null);
////            alert.setContentText("Veuillez saisir votre date de naissance ");
////            alert.showAndWait();
////            return true;
////         }
////           return false;
////        }
////    /* public boolean controleTextFieldNonNumerique(TextField textField) {
////        if (textField.getText().matches(".*[a-zA-Z].*")) {
////            Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setHeaderText(null);
////            alert.setContentText("veuillez saisir que des entiers!");
////            alert.showAndWait();
////            return true;
////        }
////             return false;}
////   */ 
////    public boolean controleTextFieldNomEtPrenom(TextField textField1,TextField textField) {
////        if (textField1.getText().matches(".*[0-9].*")||textField.getText().matches(".*[0-9].*")) {
////            Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setHeaderText(null);
////            alert.setContentText("c'est interdit d'inserer un numero dans poste nom ou description");
////            alert.showAndWait();
////            return true;
////        }
////             return false;}
////        
////       /*public boolean controleTextFieldMAIL(TextField textField) {
////        if (!textField.getText().contains("@")) {
////            Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setHeaderText(null);
////            alert.setContentText("Votre adresse mail est invalide");
////            alert.showAndWait();
////            return true;
////        }
////             return false;}
////*/
//////    private void checkinput(javafx.scene.input.KeyEvent event) {
//////      if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
//////            event.consume();
//////            
//////            lieutf.setStyle("-fx-border-color: red");
//////        }else{
//////            lieutf.setStyle("-fx-border-color: green");
//////        }
//////    }
////}