/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
public class LesoffresController implements Initializable {

    @FXML
    private VBox offresvb;
    @FXML
    private TextField txtsupprimer;
    @FXML
    private ComboBox supp;
    
     TypeoffreService tos = new TypeoffreService();
      OffreService os = new OffreService();
      String typeSelectionne;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//         List<Typeoffre> to = tos.fetchOffres();
//        for(Typeoffre t :to)  {
//        typetf.getItems().add(t.getDescription());
//        }
//        typetf.setOnAction(e -> {typeSelectionne=typetf.getValue().toString();});

 List<Offre> lo = os.fetchOffres();
        for(Offre o :lo)  {
        supp.getItems().add(o.getDescription());
        }
        supp.setOnAction(e -> {typeSelectionne=supp.getValue().toString();});
        OffreService os = new OffreService();
        
       List<Offre> offres = os.fetchOffres();
        for(int i=0; i<offres.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../GUI/OFFREITEM.fxml"));
            
            try{
                HBox hBox = fxmlLoader.load();
                OFFREITEMController cic = fxmlLoader.getController();
                cic.setData(offres.get(i));
                offresvb.getChildren().add(hBox);
                 
            } catch (IOException ex)
            {
                Logger.getLogger(LesoffresController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void Delete(ActionEvent event) {
        //int id_event = Integer.parseInt(txtsupprimer.getText());
      //  int id=setType(os.getelementbyid(typeSelectionne));
        Offre o = new Offre() ;
       // a =os.getelementbyDescription(typeSelectionne);
          OffreService os = new OffreService();
     o.setType(tos.getelementbydescription(typeSelectionne));
  //  os.deleteOffre(id_event);
    os.deletebydes(typeSelectionne);
    }
    
}
