/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Offre;
import models.Typeoffre;
import services.OffreService;
import services.TypeoffreService;
import java.lang.Integer;

/**
 * FXML Controller class
 *
 * @author Aziz Ben Guirat
 */
public class ModifieroffreController implements Initializable {

    @FXML
    private TextField postem;
    @FXML
    private TextField descriptionm;
    @FXML
    private TextField lieum;
    @FXML
    private TextField entreprisem;
    @FXML
    private TextField specialitem;
    @FXML
    private TextField idm;
    @FXML
    private DatePicker dateD;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   

    
    TypeoffreService tos = new TypeoffreService();
      OffreService os = new OffreService();
      String typeSelectionne;
    @FXML
    private ComboBox typetf;
     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        List<Typeoffre> to = tos.fetchOffres();
        for(Typeoffre t :to)  {
        typetf.getItems().add(t.getDescription());
        }
        typetf.setOnAction(e -> {typeSelectionne=typetf.getValue().toString();});
        
        OffreService os = new OffreService();
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
         LocalDate selectedDate = dateD.getValue();       
        Offre o = new Offre();
                OffreService ps = new OffreService();
                TypeoffreService ts = new TypeoffreService();

               
        


         o.setPoste(postem.getText());
         o.setDescription(descriptionm.getText());
         o.setLieu(lieum.getText());
        o.setEntreprise(entreprisem.getText());
         o.setSpecialite(specialitem.getText());
          o.setDateExpiration(Date.valueOf(dateD.getValue()));
        o.setType(tos.getelementbydescription(typeSelectionne));
         
        // o.setType(ts.getelementbyid(4));
//         
       ps.updateOffre(o,NewoffresController.selectedoffre.getId());
    }
    
}
