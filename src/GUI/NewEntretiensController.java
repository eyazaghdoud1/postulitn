/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Entretien;
import services.AuthenticationService;
import services.EntretienService;
import utilities.TypeEntretien;

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
    private DatePicker dateDP;
    @FXML
    private Button allEntBtn;
    
    public static int entRecIndex;
    public static EntretienService es = new EntretienService();
    Date sqlDate;
    public static Date selectedDateFiltre;
    public static List<Entretien> data  = es.fetchEntretiens();
    public static String selectedOffreFiltre;
    public static boolean all=false;
    public static Entretien selectedEntretien;
    public static List<Entretien> dataPlanned;
    @FXML
    private HBox modifHB;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private TextField lieuTF;
    @FXML
    private Button enregistrerBtn;
    @FXML
    private DatePicker dateDP1;
    Date sqlDate1;
    
    MenuBarController mbc = new MenuBarController();

//public static Popup p = new Popup();

    /**
     * Initializes the controller class.
     */
@Override
    public void initialize(URL url, ResourceBundle rb) {
     //   mbc.setConnectedUser();
           /****************************************************************************************/
        URL u;
       if (AuthenticationService.compteconnecte.getPhoto() == null) {
             try {
                 u = new URL("http://localhost/postulitn/images/defaultuser.png");
                Image image = new Image(u.toString());
                userPhoto.setImage(image);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
             }
       } 
       else {
    try {
        u = new URL("http://localhost/postulitn/images/"+ AuthenticationService.compteconnecte.getPhoto());
         Image image = new Image(u.toString());
         userPhoto.setImage(image);
        
    } catch (MalformedURLException ex) {
        Logger.getLogger(NewCompteController.class.getName()).log(Level.SEVERE, null, ex);
    }

       }    
       
        userConnecte.setText(AuthenticationService.userconnecte.getNom());
        
        
        /****************************************************************************************************/
        modifHB.setVisible(false);
        //data = es.fetchEntretiens();
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
           
       
    } 

    @FXML
    private void goToOffres(MouseEvent event) {
        mbc.goToOffres(event);
    }

    @FXML
    private void goToCandidatures(MouseEvent event) {
        mbc.goToCandidatures(event);
    }

    @FXML
    private void goToEntretiens(MouseEvent event) {
        mbc.goToEntretiens(event);
    }

    @FXML
    private void goToGuides(MouseEvent event) {
        mbc.goToGuides(event);
    }

    @FXML
    private void goToQuiz(MouseEvent event) {
        mbc.goToQuiz(event);
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
            
            modifHB.setVisible(true);
            initilialiserModif();
            setDataModif(selectedEntretien);
            //dateDP.setValue(selectedEntretien.getDate().toLocalDate());
            
            
    }

    
    @FXML
    private void reset(ActionEvent event) {
        data = es.fetchEntretiens();
        selectedDateFiltre = null;
        reload();
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

    @FXML
    private void modifierEnt(ActionEvent event) {
       Entretien eupdate = new Entretien();
       eupdate.setDate(sqlDate1);
       eupdate.setId(NewEntretiensController.selectedEntretien.getId());
       int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       eupdate.setHeure(horaire);
       eupdate.setLieu(lieuTF.getText());
       eupdate.setType(NewEntretiensController.selectedEntretien.getType());
       eupdate.setCandidature(NewEntretiensController.selectedEntretien.getCandidature());
       System.out.println("test: "+ lieuTF.getText());
       
       es.updateEntretien(NewEntretiensController.selectedEntretien.getId(), eupdate);
       this.reload();
        
    }
    
    private void initilialiserModif() {
     SpinnerValueFactory<Integer> hourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
       hourSpinner.setValueFactory(hourFactory);
       hourSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
       // si la valeur est sup au max
       try {
        int newHourValue = Integer.parseInt(newValue);
        if (newHourValue < 0 || newHourValue > 23) {
            hourSpinner.getValueFactory().setValue(hourFactory.getValue());
        } else {
            hourFactory.setValue(newHourValue);
        }
       } catch (NumberFormatException e) {
        hourSpinner.getValueFactory().setValue(hourFactory.getValue());
    
      }
    });

      // minute spinner

      SpinnerValueFactory<Integer> minuteFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
      minuteSpinner.setValueFactory(minuteFactory);
      minuteSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
      try {
        int newMinuteValue = Integer.parseInt(newValue);
        if (newMinuteValue < 0 || newMinuteValue > 59) {
            minuteSpinner.getValueFactory().setValue(minuteFactory.getValue());
        } else {
            minuteFactory.setValue(newMinuteValue);
        }
      } catch (NumberFormatException e) {
        minuteSpinner.getValueFactory().setValue(minuteFactory.getValue());
      }
    });
      /* initialisation des valeurs */
        hourSpinner.getValueFactory().setValue(0);
        minuteSpinner.getValueFactory().setValue(0);
        
         dateDP1.setOnAction(e -> {
            LocalDate selectedDate = dateDP1.getValue();
            sqlDate1 = Date.valueOf(selectedDate); 
        });
    }
    private void setDataModif(Entretien ent) {
          dateDP1.setValue(ent.getDate().toLocalDate());
          String[] horaire = ent.getHeure().split(":");
          String heure = horaire[0];
          String minutes = horaire[1];
          hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
          minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
        if(ent.getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                        
           lieuTF.setDisable(true);
                        
        }
        else if(ent.getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
           lieuTF.setText(ent.getLieu());
         }
    }

    @FXML
    private void deleteEntr(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir supprimer cet entretien?");
                //alert.setContentText(("L'état de la candidature va changer."));

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                  

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                 es.deleteEntretien(NewEntretiensController.selectedEntretien.getId());
                 this.reload();
 
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
    }

    @FXML
    private void closeModifBox(ActionEvent event) {
        modifHB.setVisible(false);
    }
}