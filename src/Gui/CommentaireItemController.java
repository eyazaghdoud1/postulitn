/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Models.Commentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Users
 */
public class CommentaireItemController implements Initializable {

    @FXML
    private ImageView UserPic;
    @FXML
    private Label Luser;
    @FXML
    private Label LContenu;

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
    
}
