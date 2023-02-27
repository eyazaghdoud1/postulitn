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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ProjetServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ListeProjetsController implements Initializable {

    private VBox ProjetFreelanceVB;
    ProjetServices ps = new ProjetServices();
    @FXML
    private VBox ProjetLayout;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      List<ProjetFreelance> lp=  ps.fetchProjet();
         for (int i=0; i<lp.size(); i++){
             
             FXMLLoader fxmlloader = new FXMLLoader();
             fxmlloader.setLocation(getClass().getResource("../Gui/p.fxml"));
          try { 
              VBox vbox = fxmlloader.load();
              PController pc = fxmlloader.getController();
              pc.setData(lp.get(i));
              ProjetLayout.getChildren().add(vbox); 
          } catch (IOException ex) {
              Logger.getLogger(ListeProjetsController.class.getName()).log(Level.SEVERE, null, ex);
          }  
          
          
             
         }
    }
    
   
}
    

