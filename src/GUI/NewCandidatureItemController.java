/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Candidature;
import models.Offre;
import utilities.EtatCandidature;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCandidatureItemController implements Initializable {

    @FXML
    private Label offre;
    @FXML
    private Label typeOffre;
    @FXML
    private Label etat;
    @FXML
    private HBox parentHB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setData(Candidature c, Offre o) {
     offre.setText(o.getPoste() );
     typeOffre.setText(o.getType().getDescription());
     etat.setText(c.getEtat().toString());
     
     

    }
}
