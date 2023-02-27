package Models;

import Gui.ServeurController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Users
 */
public class Server {
    private ServerSocket serverSocket; 
    private Socket socket; 
    private BufferedReader bufferReader; 
    private BufferedWriter bufferWriter; 

    public Server(ServerSocket serverSocket) {
       try {   
           this.serverSocket = serverSocket;
           this.socket = serverSocket.accept(); 
           this.bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           this.bufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
       } catch (IOException e) {
           System.out.println("Error creating server");
           e.printStackTrace();
           closeEverything(socket,bufferReader,bufferWriter);
       }
    }
    
    
public void sendMessageToClient(String messageToClient){
        try {
            bufferWriter.write(messageToClient);
            bufferWriter.newLine();
            bufferWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error sending message to the client");
            closeEverything(socket,bufferReader,bufferWriter);
        }
}    
  

    public void receiveMessageFromClient(VBox vbox_messages) {
        new Thread(new Runnable(){
            @Override
            public void run() {
              while (socket.isConnected()){
                  try {
                      String messageFromClient = bufferReader.readLine();
                      ServeurController.addLabel(messageFromClient, vbox_messages);
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
