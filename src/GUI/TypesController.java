/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.Offre;
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class TypesController implements Initializable {

    @FXML
    private VBox typeoffresvb;
    @FXML
    private TextField txtsupprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         TypeoffreService ts = new TypeoffreService();
             List<Typeoffre> ls=  ts.fetchOffres();
          for (int i=0; i<ls.size(); i++){
              Label Secteur = new Label(ls.get(i).toString());
              typeoffresvb.getChildren().add(Secteur);
    }    
    
    }

    @FXML
    private void Deletetype(ActionEvent event) {
        int id_event = Integer.parseInt(txtsupprimer.getText());


TypeoffreService ts = new TypeoffreService();

    ts.deletetypeoffre(id_event);
         
    }
}
