/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Users
 */
public class NewFXMain extends Application {
    
      
    @Override
    public void start(Stage primaryStage) {
      
        try {
            //Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeSecteurFXML.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeProjets.fxml"));
            
            //Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeSecteurFXML.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/Offreprojet.fxml"));
          //  Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeProjetResponsables.fxml"));
          
          
          
           //Parent root = FXMLLoader.load(getClass().getResource("/Gui/AjouterSecteurs.fxml")); 
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/AjouterProjets.fxml"));
             Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeProjetsFreelance.fxml"));
           // Parent root = FXMLLoader.load(getClass().getResource("../Gui/ListeProjetsResponsable.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/ModifierProjets.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/Feedback.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/SuppressionCommentaire.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("../Gui/Commentaire.fxml"));
           
           
           javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setWidth(primaryScreenBounds.getWidth());
            primaryStage.setHeight(primaryScreenBounds.getHeight());
            Scene scene = new Scene(root);    
                    
            
            primaryStage.setTitle("");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
