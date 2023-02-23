/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import Models.Secteur;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.SecteurServices;


/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeSecteurFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    SecteurServices sc = new SecteurServices();
    @FXML
    private VBox secteurVB;
    public static Secteur s;
    @FXML
    private TextField secteurTF;
   
    
    
     @FXML
    private void AjouterSecteur(ActionEvent event) {
        SecteurServices ss = new SecteurServices();
         Secteur s= new Secteur(); 
        s.setDescription(secteurTF.getText());
        ss.addSecteur(s);
    
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       // TODO
         List<Secteur> ls=  sc.fetchSecteur();
         secteurVB.getChildren().clear();
        
          for (int i=0; i<ls.size(); i++){
              s=ls.get(i);
         FXMLLoader fxmlloader = new FXMLLoader();
             fxmlloader.setLocation(getClass().getResource("../Gui/s.fxml"));
        try { 
              HBox hbox = fxmlloader.load();
              SController sc = fxmlloader.getController();
              sc.setData(ls.get(i));
         secteurVB.getChildren().add(hbox); 
          } catch (IOException ex) {
              Logger.getLogger(ListeProjetsController.class.getName()).log(Level.SEVERE, null, ex);
          }    
    }    
   }
    
    
    
    
   /*   public void deleteSecteurById(Secteur s) {
         try {
             String req ="DELETE FROM `secteurs` WHERE idSecteur = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, s.getIdSecteur());
             ps.executeUpdate();
             System.out.println("Secteur supprimé avec succes"); 
         } catch (SQLException ex) {
           ex.printStackTrace(); 
         }

      }
*/
   
}


   