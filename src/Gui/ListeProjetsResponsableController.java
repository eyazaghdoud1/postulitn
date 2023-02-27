/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.ProjetFreelance;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.ProjetServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeProjetsResponsableController implements Initializable {
    @FXML
    private VBox ListeProjetsResponsableVB;
    ProjetServices ps = new ProjetServices();
    @FXML
    private ComboBox<?> choixsecteuCB;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // les projets doivent apparternir a un seul responsable => fitrés par id responsable
        // TODO
        List<ProjetFreelance> lp=  ps.filterByIdResponsable(0);

          for (int i=0; i<lp.size(); i++){
              
             FXMLLoader fxmlloader = new FXMLLoader();
             fxmlloader.setLocation(getClass().getResource("../Gui/R1.fxml"));
              try { 
              HBox hbox = fxmlloader.load();
              RController rc = fxmlloader.getController();
              rc.setData(lp.get(i));
               ListeProjetsResponsableVB.getChildren().add(hbox); 
          } catch (IOException ex) {
              Logger.getLogger(ListeProjetsController.class.getName()).log(Level.SEVERE, null, ex);
          }  
          }
        
    }    
    }    

/* List<ProjetFreelance> lp=  ps.fetchProjet();
         for (int i=0; i<lp.size(); i++){
             
             FXMLLoader fxmlloader = new FXMLLoader();
             fxmlloader.setLocation(getClass().getResource("../Gui/R.fxml"));
          try { 
              VBox vbox = fxmlloader.load();
              PController pc = fxmlloader.getController();
              pc.setData(lp.get(i));
              ListeProjetsResponsableVB.getChildren().add(vbox); 
          } catch (IOException ex) {
              Logger.getLogger(ListeProjetsController.class.getName()).log(Level.SEVERE, null, ex);
          }  
             
         }*/
    
 
