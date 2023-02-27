/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import models.Utilisateur;
import utilities.Maconnexion;

/**
 * FXML Controller class
 *
 * @author ezine
 */
public class MdpoublieController implements Initializable {

    @FXML
    private Button btnmodifmdp;
    @FXML
    private PasswordField nouveaumdp;
    @FXML
    private PasswordField nouveaumdpc;

    /**
     * Initializes the controller class.
     */
    Connection cnx = Maconnexion.getInstance().getCnx();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChangerMdp(ActionEvent event) {
        
}
    
}
