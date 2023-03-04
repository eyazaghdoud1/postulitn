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
import models.GuideEntretien;
import services.GuideEntretienService;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class GuideitemController implements Initializable {
    @FXML
    private Label lidguide;
    @FXML
    private Label ldomaine;
    @FXML
    private Label lspecialite;
    @FXML
    private Label lsupport;
    @FXML
    private Label lnote;

    /**
     * Initializes the controller class.
     */
    GuideEntretienService ges = new GuideEntretienService();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData (GuideEntretien ge){
        lidguide.setText((int) ge.getIdguide()+"");
        ldomaine.setText(ge.getDomaine());
        lspecialite.setText(ge.getSpecialite());
        lsupport.setText(ge.getSupport());
        lnote.setText((int) ge.getNote() +"");
        
    }
            
}
