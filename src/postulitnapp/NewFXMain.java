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
import services.AuthenticationService;

/**
 *
 * @author ezine
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               try {
            
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/SignIn.fxml"));
           // Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
                  
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/SignInRecruteur.fxml"));
         
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/Mdpoublie.fxml"));
            
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/RolesList.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/NewGestionQuiz.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/Modifmdp.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutAdmin.fxml"));
           
            System.out.println("FXML loaded successfully");
            
            Scene scene = new Scene(root);
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setWidth(primaryScreenBounds.getWidth());
            primaryStage.setHeight(primaryScreenBounds.getHeight());
              System.out.println(primaryScreenBounds.getWidth());
               System.out.println(primaryScreenBounds.getHeight());
            primaryStage.setTitle("test");
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
        launch (args);
      
    }
    
}
