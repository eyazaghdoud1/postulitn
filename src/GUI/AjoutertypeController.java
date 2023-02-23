/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.TypeoffreInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Typeoffre;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class AjoutertypeController implements Initializable {

    @FXML
    private TextField descriptiontf;
    @FXML
    private Label erreurdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addtype(ActionEvent event) {
 TypeoffreService ts = new TypeoffreService();
 Typeoffre t = new Typeoffre();
 
// if(controleTextFieldNomEtPrenom(descriptiontf)  )     {         
//    if (descriptiontf.getText().isEmpty())
//         {
//                        erreurdescription.setText("description non valide !");
//                        erreurdescription.setVisible(true);
//                        
//                        return;
//                    }

   Typeoffre to = new Typeoffre();
      t.setDescription(descriptiontf.getText());
      TypeoffreInterface pt = new TypeoffreService();
      pt.addType2(t);
   
       
    
    
   }
}
//    public boolean controleTextFieldNomEtPrenom(TextField textField1) {
//        if (textField1.getText().matches(".*[0-9].*")) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setContentText("c'est interdit d'inserer un numero dans description");
//            alert.showAndWait();
//            return true;
//        }
//             return false;}
   // }
   
    

