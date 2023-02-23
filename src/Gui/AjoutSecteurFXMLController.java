/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Secteur;
import interfaces.SecteurInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.SecteurServices;
import javafx.scene.control.Button; 





/**
 * FXML Controller class
 *
 * @author Users
 */
public class AjoutSecteurFXMLController implements Initializable {


    @FXML
    private TextField DescriptionSecteurTF;
    private Label erreurdescriptionSecteur;
    
     SecteurServices ss = new SecteurServices();
    /**
     * Initializes the controller class.
     */
    @Override
  
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addSecteur(ActionEvent event) {
        //date to a string if needed
        Secteur s= new Secteur(); 
        s.setDescription(DescriptionSecteurTF.getText());
        ss.addSecteur(s);
    
    
   Secteur s1 = new Secteur(); 
   if(controleTextField(DescriptionSecteurTF)){
      if (DescriptionSecteurTF.getText().isEmpty())
         {
                        erreurdescriptionSecteur.setText("Description non valide !");
                        erreurdescriptionSecteur.setVisible(true);
                        
                        return;
                    }
}
    }
      public boolean controleTextField(TextField textField1) {
        if (textField1.getText().matches(".*[A-Z] || [a-z].*")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("vous ne pouvez inserer que des lettres");
            alert.showAndWait();
            return true;
        }
             return false;
      }
}
 
   
