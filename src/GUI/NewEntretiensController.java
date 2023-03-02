/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Entretien;
import services.EntretienService;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewEntretiensController implements Initializable {

    @FXML
    private Label userConnecte;
    @FXML
    private ImageView userPhoto;
    @FXML
    private VBox offresVB;
    @FXML
    private VBox candidaturesVB;
    @FXML
    private VBox entretiensVB;
    @FXML
    private VBox guidesVB;
    @FXML
    private VBox quizVB;
    @FXML
    private HBox headerHB;
    @FXML
    private VBox mainVB;

    @FXML
    private ListView<HBox> listViewEnt;
    
    @FXML
    private Button resetBtn;
    @FXML
    private SplitMenuButton filtreOffres;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Button allEntBtn;
    
    public static int entRecIndex;
    public static EntretienService es = new EntretienService();
    Date sqlDate;
    public static Date selectedDateFiltre;
    public static List<Entretien> data = es.fetchEntretiens();
    public static String selectedOffreFiltre;
    public static boolean all=false;
    public static Entretien selectedEntretien;
    List<Entretien> dataPlanned;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //fetchEntretienByIdRecruteur : ent.candidature.offre.idrecruteur 
        Collections.sort(data);
//                List<Entretien> sortedData = new ArrayList<>(data);
//       Collections.sort(sortedData);
//// now the sortedData List is sorted, and data remains unsorted
//
//// To replace the unsorted data List with the sorted List:
//     data = sortedData;

        Date today = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.setTime(cal.getTime());
        long millis = cal.getTimeInMillis();
        Date yesterday = new Date(millis);
 
        Comparator<Entretien> comparator = (e1, e2) -> e1.getDate().compareTo(yesterday);

        // par défaut: affichage des entretiens à venir triés à partir de la date d'auhourd'hui
        dataPlanned = data.stream()
           .filter(e -> comparator.compare(e, null) > 0)
           .sorted((e1,e2) -> e2.compareTo(e1))
           .collect(Collectors.toList());
    
        if (selectedDateFiltre != null) {
           dateDP.setValue(selectedDateFiltre.toLocalDate());
        } else {
           dateDP.setPromptText("Choisir une date");
        }
        this.showEntretien(dataPlanned);
        System.out.println(all);
        
        /*for (Entretien e : data1) {
           
          if (e.getDate() != null) {
            try {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewEntretienItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;");
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                listViewEnt.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewEntretienItemController eic = fxmlLoader.getController();
                //System.out.println(e);
                eic.setData(e);
                listViewEnt.getItems().add(hbox);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
          }
        }*/

        
        // filtres
        //1 - date picker for filter
           dateDP.setOnAction(e -> {
            LocalDate selectedDate = dateDP.getValue();
            sqlDate = Date.valueOf(selectedDate);
            selectedDateFiltre = sqlDate;
            System.out.println("test on action; " + selectedDate);
            this.filterDate();
            reload();

        });
           
        // 2- menu button for filter by offre
        filtreOffres.getItems().clear();
        if (selectedOffreFiltre == null) {
          filtreOffres.setText("Offres");
        } else {
          filtreOffres.setText(selectedOffreFiltre);
        }
        MenuItem type1 = new MenuItem("Offre1");
        MenuItem type2 = new MenuItem("Offre2");
        MenuItem type3 = new MenuItem("Offre3");
        
        filtreOffres.getItems().addAll(type1, type2, type3);
    } 

    @FXML
    private void goToOffres(MouseEvent event) {
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
    }

    @FXML
    private void goToGuides(MouseEvent event) {
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
            entRecIndex = listViewEnt.getSelectionModel().getSelectedIndex();
            //System.out.println(entRecIndex);
            if (all==false) {
              selectedEntretien = dataPlanned.get(entRecIndex);
                System.out.println("all = false "+selectedEntretien);
            }else {
             selectedEntretien = data.get(entRecIndex);
             System.out.println("all = true "+selectedEntretien);
            }
    }

    
    @FXML
    private void reset(ActionEvent event) {
         data = es.fetchEntretiens();
        selectedDateFiltre = null;
        reload();
    }

    
    @FXML
    private void filterByOffre(ActionEvent event) {
    }
    
     private void filterDate() {
       data = es.filterListeByDate(data, selectedDateFiltre);
       //System.out.println("test filter method " + data);
    }
     
     private void reload() {
     try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewEntretiens.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) mainVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    @FXML
    private void allEntretiens(ActionEvent event) {
        listViewEnt.getItems().clear();
        this.showEntretien(data);
        all=true;
        System.out.println(all);
        
    }
    
    private void showEntretien(List<Entretien> data ) {
         for (Entretien e : data) {
          if (e.getDate() != null) {
            try {
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./NewEntretienItem.fxml"));
              
                HBox hbox = fxmlLoader.load();
                hbox.setStyle("-fx-background-color: #939AB0; -fx-border-radius: 10;");
                hbox.setEffect(new DropShadow(2d, 0d, +2d, Color.WHITE));
                listViewEnt.setStyle("-fx-control-inner-background:  #0E1947; -fx-box-border:#0E1947; -fx-border-radius: 10;");
                NewEntretienItemController eic = fxmlLoader.getController();
                //System.out.println(e);
                eic.setData(e);
                listViewEnt.getItems().add(hbox);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
          }
         }
}
    
    
}