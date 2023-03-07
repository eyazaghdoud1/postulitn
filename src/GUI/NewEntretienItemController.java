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
import models.Utilisateur;
import services.EntretienService;
import services.UtilisateurService;

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
    UtilisateurService us = new UtilisateurService();
    
    public void setData(Entretien e) {
     Utilisateur u = us.GetByIdUser(e.getCandidature().getIdCandidat());
     date.setText(e.getDate().toString());
     horaire.setText(e.getHeure());
     type.setText(e.getType());
     candidat.setText(u.getNom() + u.getPrenom());
    }
    
}
