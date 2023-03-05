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
import models.Entretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewEntretienItemController implements Initializable {

    @FXML
    private Label date;
    @FXML
    private Label horaire;
    @FXML
    private Label candidat;
    @FXML
    private Label type;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Entretien e) {
     date.setText(e.getDate().toString());
     horaire.setText(e.getHeure());
     type.setText(e.getType());
     candidat.setText("Candidat: " + e.getCandidature().getIdCandidat());
    }
    
}
