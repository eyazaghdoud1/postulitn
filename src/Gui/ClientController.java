/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Client;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class ClientController implements Initializable {

    @FXML
    private Button button_send;
    @FXML
    private TextField tf_message;
    @FXML
    private ScrollPane sp_main;
    @FXML
    private VBox vbox_messages;
    
    private Client client; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
        client = new Client(new Socket("localhost",1234)); 
            System.out.println("Connected to server");
        } catch (IOException e){
            e.printStackTrace(); 
        }
        
       vbox_messages.heightProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sp_main.setVvalue((Double) newValue);
            }
       });
     client.receiveMessageFromServer(vbox_messages);  
     
     button_send.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
             String messageToSend = tf_message.getText();
             if (!messageToSend.isEmpty()){
             HBox hbox = new HBox(); 
              hbox.setAlignment(Pos.CENTER_RIGHT);
      hbox.setPadding(new Insets(5,5,5,10));
       Text text = new Text(messageToSend);
       TextFlow textflow = new TextFlow(text); 
       textflow.setStyle("-fx-color: rgb(239,242,255)"+
               "-fx-background-color: rgb(15,125,242)"  +
                           "-fx-background-radius: 20px" );    
       textflow.setPadding(new Insets(5,10,5,10));
       text.setFill(Color.color(0.934,0.945,0.996));
       hbox.getChildren().add(hbox); 
       
       client.sendMessageToServer(messageToSend);
       tf_message.clear();
             }
            }
     });
    }    
   
     public static void addLabel(String messageFromServer, VBox vbox){
    HBox hbox = new HBox(); 
      hbox.setAlignment(Pos.CENTER_LEFT);
      hbox.setPadding(new Insets(5,5,5,10));
    
       Text text = new Text(messageFromServer);
       TextFlow textflow = new TextFlow(text); 
       textflow.setStyle("-fx-background-color: rgb(233,233,235)"  +
                           "-fx-background-radius: 20px" );    
       textflow.setPadding(new Insets(5,10,5,10));
        hbox.getChildren().add(textflow);
         Platform.runLater(new Runnable() {
        @Override
        public void run() {
            vbox.getChildren().add(hbox);
        }
    });
    }
    
    
}
