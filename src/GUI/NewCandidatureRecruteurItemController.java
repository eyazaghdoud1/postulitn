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
import models.Candidature;
import models.Offre;
import models.Utilisateur;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCandidatureRecruteurItemController implements Initializable {

    @FXML
    private Label offre;
    @FXML
    private Label type;
    @FXML
    private Label etat;
    @FXML
    private Label candidat;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Candidature c, Offre o, Utilisateur u) {
     offre.setText(o.getPoste() );
     type.setText(o.getType().getDescription());
     etat.setText(c.getEtat().toString());
     candidat.setText(u.getNom() + u.getPrenom());
}

}