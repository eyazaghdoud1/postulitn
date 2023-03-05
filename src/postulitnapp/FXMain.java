/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author HP I5
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
           try {
            // d'ou on va creer la scene
            
            //interfaces candidat
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/Candidatures.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/AddCandidature.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/ModificationCandidature.fxml"));
            
            //interface recruteur 
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/CandidaturesRecruteur.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/NewCandidaturesRecruteur.fxml"));
           
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/NewQuizList.fxml"));
           
             //Parent root = FXMLLoader.load(getClass().getResource("../GUI/ajoutercompte2.fxml"));
            System.out.println("FXML loaded successfully");
            
            Scene scene = new Scene(root);

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setWidth(primaryScreenBounds.getWidth());
            primaryStage.setHeight(primaryScreenBounds.getHeight());
               System.out.println(primaryScreenBounds.getWidth());
               System.out.println(primaryScreenBounds.getHeight());

            primaryStage.setTitle("Postuli.tn");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       

    }
       
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
