/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.CommentaireServices;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class CommentaireRespItemController implements Initializable {

    @FXML
    private ImageView UserPic;
    @FXML
    private Label Luser;
    @FXML
    private Label LContenu;

    CommentaireServices commentservice = new CommentaireServices();
    List<Commentaire> commentaires = commentservice.fetchCommentaire();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(Commentaire c){
            LContenu.setText(c.getContenu()); 
    }
    
// A corriger 
    @FXML
    private void DeleteComment(MouseEvent event) {
        //Commentaire c = commentaires.get(FeedbackRespController.selectedComment);
        System.out.println(FeedbackRespController.selectedCommentResp);
          commentservice.deleteCommentaireById(FeedbackRespController.selectedCommentResp);
       try {Parent Login = FXMLLoader.load(getClass().getResource("../gui/FeedbackResp.fxml"));
            Scene si = new Scene(Login);
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow(); 
            st.setScene(si);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(RController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
