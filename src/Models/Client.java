/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Gui.ClientController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

/**
 *
 * @author Users
 */
public class Client {
     
    private Socket socket; 
    private BufferedReader bufferReader; 
    private BufferedWriter bufferWriter; 

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Error creating client");
            e.printStackTrace();
            closeEverything(socket, bufferReader, bufferWriter);
        }
    }

   

    
    public void sendMessageToServer(String messageToServer){
    try {
            bufferWriter.write(messageToServer);
            bufferWriter.newLine();
            bufferWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending message to the server");
            closeEverything(socket,bufferReader,bufferWriter);
        }
    }
    
    
  public void receiveMessageFromServer(VBox vbox_messages){
    new Thread(new Runnable(){
            @Override
            public void run() {
              while (socket.isConnected()){
                  try {
                      String messageFromServer = bufferReader.readLine();
                      ClientController.addLabel(messageFromServer, vbox_messages);
                  } catch (IOException e) {
                    e.printStackTrace();
                      System.out.println("Error receiving message from the client ");
                      closeEverything(socket,bufferReader,bufferWriter);
                      break; 
                  }
              
              }
            }
            }).start();
   } 
   
  
    
    
       
public void closeEverything(Socket socket, BufferedReader bufferReader, BufferedWriter bufferWriter ){
try {
if (bufferReader != null){
bufferReader.close(); 
}
if (bufferWriter != null){
bufferWriter.close();
}
if (socket != null){
socket.close();}
} catch (IOException e){
e.printStackTrace();
}}
    
}
