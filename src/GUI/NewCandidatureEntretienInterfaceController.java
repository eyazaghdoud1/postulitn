/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Candidature;
import models.Compte;
import models.Entretien;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import services.CandidatureService;
import services.CompteServices;
import services.EntretienService;
import utilities.EtatCandidature;
import utilities.TypeEntretien;

/**
 * FXML Controller class
 *
 * @author HP I5
 */
public class NewCandidatureEntretienInterfaceController implements Initializable {

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
    private Button backBtn;
    @FXML
    private VBox offreVB;
    @FXML
    private Label psteOffre;
    @FXML
    private Label descriptionOffre;
    @FXML
    private Label dateExpOffre;
    @FXML
    private Label experienceOffre;
    @FXML
    private HBox entTelVideHB;
    @FXML
    private VBox entTelVB;
    @FXML
    private Label dateEntTel;
    @FXML
    private Label heureEntTel;
    @FXML
    private Button modifierBtn1;
    @FXML
    private HBox entPresVideHB;
    @FXML
    private VBox entPresVb;
    @FXML
    private Label dateEntPres;
    @FXML
    private Label heureEntPres;
    @FXML
    private Label lieuEntPres;
    @FXML
    private Button modifierBtn2;
    @FXML
    private VBox candVB1;
    @FXML
    private VBox entretienVB;
    @FXML
    private DatePicker dateDP;
    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private Spinner<Integer> hourSpinner;
    @FXML
    private ComboBox<String> typeEntretienCB;
    @FXML
    private TextField lieuTF;
    @FXML
    private Button enregistrerBtn;
    @FXML
    private Button modiferBtn;
    
    private String selectedType;
    private Date sqlDate;
    @FXML
    private Button validerBtn;
    @FXML
    private Label candidat;
    @FXML
    private Label dateCand;
    @FXML
    private Label etatCand;
    @FXML
    private ImageView cvImageView;
    @FXML
    private ImageView lettreImageView;
    @FXML
    private Button consulterBtn;
    
    private Entretien entTel, entPres, entModif;
    @FXML
    private Button planifierTelBtn;
    @FXML
    private Button planifierPresBtn;
    
    EntretienService es = new EntretienService();
    public static CandidatureService csr = new CandidatureService();
    
      byte[] pdfDataCV;
    byte[] pdfDataLettre;
    @FXML
    private VBox entretiensContainer;
    @FXML
    private Button refuserBtn;
    public static Compte compteToVisit;
   // public static Candidature thisCandidature ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       // hour spinner
       //thisCandidature = csr.getCandidatureById(NewCandidaturesRecruteurController.recSelectedCand.getId());
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
        
     // initialisation du combo box des types d'entretiens   
     typeEntretienCB.getItems().addAll(TypeEntretien.TypeE.Téléphone.toString(),
                TypeEntretien.TypeE.Présentiel.toString());
     
     // récupération de l'élément sélectionné
        typeEntretienCB.setOnAction(e -> {
            selectedType = typeEntretienCB.getValue();
           
        });
        
     // initialisation du date picker
        dateDP.setOnAction(e -> {
            LocalDate selectedDate = dateDP.getValue();
            sqlDate = Date.valueOf(selectedDate); 
        });
        
        
      entretienVB.setVisible(false);
     // setting the page info 
     this.setDataCand();
     this.setDataEntretiens();
     
     validerBtn.setStyle("-fx-background-color: green;");

    }    

    @FXML
    private void goToCompte(MouseEvent event) {
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
    private void goBack(ActionEvent event) {
        try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }

    @FXML
    private void valider(ActionEvent event) {
       /* if( validerBtn.getText().equals("Valider")) {
           csr.valider(NewCandidaturesRecruteurController.recSelectedCand.getId(), true);
           validerBtn.setText("Invalider");
        }
        else {
           csr.valider(NewCandidaturesRecruteurController.recSelectedCand.getId(), false);
           validerBtn.setText("Valider");
           validerBtn.setStyle("-fx-background-color: red;");
        } } */
       csr.valider(NewCandidaturesRecruteurController.recSelectedCand.getId(), true);
       this.reload();
      
        
         
    }

    @FXML
    private void modifierEntretienTel(ActionEvent event) {
        
     entretienVB.setVisible(true);
     dateDP.setValue(entTel.getDate().toLocalDate());
     
     String[] horaire = entTel.getHeure().split(":");
     String heure = horaire[0];
     String minutes = horaire[1];
     hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
     minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
     typeEntretienCB.setValue(typeEntretienCB.getItems().get(0));
     entModif = entTel;
     lieuTF.setDisable(true);
     modiferBtn.setVisible(true);
     enregistrerBtn.setVisible(false);
    }

    @FXML
    private void modifierEntretienPres(ActionEvent event) {
     entretienVB.setVisible(true);
     lieuTF.setDisable(false);
     dateDP.setValue(entPres.getDate().toLocalDate());
     
     String[] horaire = entPres.getHeure().split(":");
     String heure = horaire[0];
     String minutes = horaire[1];
     hourSpinner.getValueFactory().setValue(Integer.parseInt(heure));
     minuteSpinner.getValueFactory().setValue(Integer.parseInt(minutes));
     typeEntretienCB.setValue(typeEntretienCB.getItems().get(1));
     lieuTF.setText(entPres.getLieu());
     entModif= entPres;
     modiferBtn.setVisible(true);
     enregistrerBtn.setVisible(false);
     //this.reload();
    }

    @FXML
    private void enregistrerEntretien(ActionEvent event) {
      int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       System.out.println("Date sélectionnée : " + sqlDate);
       System.out.println("Selected time: " + hour + ":" + minute);
       System.out.println("Element sélectionné : " + selectedType);
       System.out.println("Lieu : " + lieuTF.getText());
       String lieu = "";
       if (entModif == entPres) {
        lieu = lieuTF.getText();
       }
       Entretien e = new Entretien(NewCandidaturesRecruteurController.recSelectedCand,
                 selectedType, sqlDate, horaire, lieu, 1);
       es.addEntretien(e);
       //NewCandidaturesRecruteurController.recSelectedCand = e.getCandidature();
       this.reload();
    }

    @FXML
    private void modifierEntretien(ActionEvent event) {
       Entretien eupdate = new Entretien();
       eupdate.setDate(sqlDate);
       eupdate.setId(entModif.getId());
       int hour = hourSpinner.getValue();
       int minute = minuteSpinner.getValue();
       String horaire = hour + ":" + minute;
       eupdate.setHeure(horaire);
       eupdate.setLieu(lieuTF.getText());
       eupdate.setType(entModif.getType());
       eupdate.setCandidature(NewCandidaturesRecruteurController.recSelectedCand);
       System.out.println("test: "+ lieuTF.getText());
       
       es.updateEntretien(entModif.getId(), eupdate);
       System.out.println("local: " + eupdate);
       System.out.println("db: " + es.getEntretienById(entModif.getId()) );
       this.reload();
    }

    @FXML
    private void consulterProfil(ActionEvent event) {
        CompteServices comptesService = new CompteServices();
        compteToVisit = comptesService.GetByIdCompte(10);
        try {
                  Parent root = FXMLLoader.load(getClass().getResource("./newCompte.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
        
    }
    
    private void setDataCand() {
       
       
      candidat.setText(candidat.getText() + NewCandidaturesRecruteurController.recSelectedCand.getIdCandidat());
      dateCand.setText(dateCand.getText() + NewCandidaturesRecruteurController.recSelectedCand.getDate());
      etatCand.setText(etatCand.getText() + NewCandidaturesRecruteurController.recSelectedCand.getEtat());
      
      /**********************************************************************************/
              try {
            // TODO
           // System.out.println("Initializing");
            //Path filePath = Paths.get("D:\\pfe\\projet\\cv\\CV_ZAGHDOUD_Eya.pdf");
           // Path filePath = Paths.get(NewCandidaturesController.selectedCandidature.getCv());
            URL u = new URL("http://localhost/postulitn/cv/"+ NewCandidaturesRecruteurController.recSelectedCand.getCv());
            try (InputStream inputStream = u.openStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int length;
                while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                }
                pdfDataCV = outputStream.toByteArray();



// Load the PDF document from the byte array using PDFBox
try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataCV))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 96;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);

    cvImageView.setImage(fxImage);

    cvImageView.prefWidth(50);
    cvImageView.prefHeight(70);

              
}
catch (IOException ex) {
    // Handle any errors that occur while reading or rendering the PDF
}

            }
                
                catch (IOException ex) {
                         ex.getStackTrace();
            }           
    // Process the PDF data here...

        } catch (MalformedURLException e) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, e);
        }

                try {
            // TODO
            System.out.println("Initializing");
            //Path filePath2 = Paths.get("D:\\pfe\\projet\\lettre de motivation.pdf");
            //Path filePath2 = Paths.get(NewCandidaturesController.selectedCandidature.getLettre());
            URL u2 = new URL("http://localhost/postulitn/lettres/"+ NewCandidaturesRecruteurController.recSelectedCand.getLettre());
            try (InputStream inputStream = u2.openStream()) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer2 = new byte[4096];
                int length;
                while ((length = inputStream.read(buffer2)) != -1) {
                outputStream.write(buffer2, 0, length);
                }
                pdfDataLettre = outputStream.toByteArray();



// Load the PDF document from the byte array using PDFBox
try (PDDocument document2 = Loader.loadPDF(new ByteArrayInputStream(pdfDataLettre))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer2 = new PDFRenderer(document2);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 96;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image2 = renderer2.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage2 = SwingFXUtils.toFXImage(image2, null);

    lettreImageView.setImage(fxImage2);

    lettreImageView.prefWidth(50);
    lettreImageView.prefHeight(70);

              
}
catch (IOException ex) {
    // Handle any errors that occur while reading or rendering the PDF
}
            }
                
                catch (IOException ex) {
                         ex.getStackTrace();
            }           

        } catch (MalformedURLException e) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, e);
        }
  /******************************************************************************************/
   if  (! NewCandidaturesRecruteurController.recSelectedCand.getEtat().equals(EtatCandidature.EtatsCandidature.Enregistrée)) {

         validerBtn.setDisable(true);
         validerBtn.setText("Validée");
       } else {
         validerBtn.setDisable(false);
       }
    
    }
    
    private void setDataEntretiens() {
      
      List<Entretien> le = es.filterByCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId());
      System.out.println(le);
      
      switch (le.size()) {
            case 2:
                entretienVB.setVisible(false);
                planifierPresBtn.setVisible(false);
                planifierTelBtn.setVisible(false);
                //modiferBtn.setVisible(false);
                for (Entretien ent: le) {
                    if(ent.getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                        
                        dateEntTel.setText(dateEntTel.getText() + " " + ent.getDate()  );
                        heureEntTel.setText(heureEntTel.getText() + " " + ent.getHeure());
                        dateEntPres.setVisible(false);
                        heureEntPres.setVisible(false);
                        lieuEntPres.setVisible(false);
                        modifierBtn2.setVisible(false);
                        entTel = ent;
                    }
                    else if(ent.getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
                        
                        dateEntPres.setText(dateEntPres.getText() + " " + ent.getDate() );
                        heureEntPres.setText(heureEntPres.getText() + " " + ent.getHeure() );
                        lieuEntPres.setText(lieuEntPres.getText() + " " + ent.getLieu());
                        entPres = ent;
                        dateEntTel.setVisible(false);
                        heureEntTel.setVisible(false);
                        modifierBtn1.setVisible(false);
                    }
                }    break;
            case 1:
                modiferBtn.setVisible(false);
                if (le.get(0).getType().equals(TypeEntretien.TypeE.Présentiel.toString())) {
                    dateEntTel.setVisible(false);
                    heureEntTel.setVisible(false);
                    modifierBtn1.setVisible(false);
                    
                    entPres= le.get(0);
//                    typeEntretienCB.setValue(typeEntretienCB.getItems().get(0));
                    
                    dateEntPres.setText(dateEntPres.getText() + " " + entPres.getDate() );
                    heureEntPres.setText(heureEntPres.getText() + " " + entPres.getHeure() );
                    lieuEntPres.setText(lieuEntPres.getText() + " " + entPres.getLieu());
                    
                   planifierPresBtn.setVisible(false);
                  
                    
                }  if (le.get(0).getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
                    dateEntPres.setVisible(false);
                    heureEntPres.setVisible(false);
                    lieuEntPres.setVisible(false);
                    modifierBtn2.setVisible(false);
                    entTel=le.get(0);
                    typeEntretienCB.setValue(typeEntretienCB.getItems().get(1));
                    dateEntTel.setText(dateEntTel.getText() + " " + entTel.getDate()  );
                    heureEntTel.setText(heureEntTel.getText() + " " + entTel.getHeure());
                    planifierTelBtn.setVisible(false);

                    
                }  break;
            default:
                System.out.println("pas d'entretiens");
                break;
        }
    }

    @FXML
    private void planifierTel(ActionEvent event) {
          entretienVB.setVisible(true);
          lieuTF.setDisable(true);
          modiferBtn.setVisible(false);
          enregistrerBtn.setVisible(true);
        
    }

    @FXML
    private void planifierPres(ActionEvent event) {
           entretienVB.setVisible(true);
           modiferBtn.setVisible(false);
           enregistrerBtn.setVisible(true);
    }
    
    private void reload() {
     try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidatureEntretienInterface.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) entretiensVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
    }
     
       @FXML
    private void getBiggerCv(MouseEvent event) {
        //vbox.getParent().setDisable(true);
      try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataCV))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 100;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);
     ImageView imageView1 = new ImageView(fxImage);
            VBox vbox1 = new VBox();
            Popup p = new Popup();
           
           
            
            //btn.setStyle("-fx-margin:10;");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> {
                p.hide();
           // vbox.getParent().setDisable(false);
            }
            );
            
            // Create a HBox to hold the Label and the Close Button
            HBox hbox = new HBox(closeButton);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            vbox1.setAlignment(Pos.CENTER);
            
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            imageView1.setFitWidth(500);
            imageView1.setFitHeight(650);
            
            vbox1.getChildren().addAll(imageView1, hbox);
            double initialScale = 1.0;
imageView1.setScaleX(initialScale);
imageView1.setScaleY(initialScale);
            imageView1.setOnScroll(e -> {
    double delta = e.getDeltaY();
    double currentScale = cvImageView.getScaleX();
    double newScale = currentScale + delta / 100.0;
    imageView1.setScaleX(newScale);
    imageView1.setScaleY(newScale);
});
            p.getContent().add(vbox1);
            
            
            
            // p.getContent().add(imageView);
            Stage stage = (Stage) candVB1.getScene().getWindow();
            p.show(stage);
        } catch (IOException ex) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getBiggerLettre(MouseEvent event) {
          //vbox.getParent().setDisable(true);
      try (PDDocument document = Loader.loadPDF(new ByteArrayInputStream(pdfDataLettre))) {
    // Create a PDF renderer and set the rendering options
    PDFRenderer renderer = new PDFRenderer(document);
    // Set the resolution of the generated image (in dots per inch)
    final float dpi = 100;
    // Set the page index (0-based) to be rendered
    final int pageIndex = 0;
    // Render the PDF page as a BufferedImage
    BufferedImage image = renderer.renderImageWithDPI(pageIndex, dpi);
    // Convert the BufferedImage to a JavaFX Image
    Image fxImage = SwingFXUtils.toFXImage(image, null);
     ImageView imageView1 = new ImageView(fxImage);
            VBox vbox1 = new VBox();
            Popup p = new Popup();
           
           
            
            //btn.setStyle("-fx-margin:10;");
            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> {
                p.hide();
           // vbox.getParent().setDisable(false);
            }
            );
            
            // Create a HBox to hold the Label and the Close Button
            HBox hbox = new HBox(closeButton);
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(10);
            vbox1.setAlignment(Pos.CENTER);
            
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            imageView1.setFitWidth(500);
            imageView1.setFitHeight(650);
            
            vbox1.getChildren().addAll(imageView1, hbox);
            double initialScale = 1.0;
imageView1.setScaleX(initialScale);
imageView1.setScaleY(initialScale);
            imageView1.setOnScroll(e -> {
    double delta = e.getDeltaY();
    double currentScale = cvImageView.getScaleX();
    double newScale = currentScale + delta / 100.0;
    imageView1.setScaleX(newScale);
    imageView1.setScaleY(newScale);
});
            p.getContent().add(vbox1);
            
            
            
            // p.getContent().add(imageView);
            Stage stage = (Stage) candVB1.getScene().getWindow();
            p.show(stage);
        } catch (IOException ex) {
            Logger.getLogger(NewCandidatureInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteEntTel(ActionEvent event) {
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
                 es.deleteEntretien(entTel.getId());
                 System.out.println("entretien par téléphone supprimé " );
                 if (entPres != null ) {
                     NewCandidaturesRecruteurController.recSelectedCand.setEtat(EtatCandidature.EtatsCandidature.EntretienPres);
                     csr.updateCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId(), NewCandidaturesRecruteurController.recSelectedCand);
                 } else {
                     NewCandidaturesRecruteurController.recSelectedCand.setEtat(EtatCandidature.EtatsCandidature.Validée);
                     csr.updateCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId(), NewCandidaturesRecruteurController.recSelectedCand);
                }
                 this.reload();
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
    }

    @FXML
    private void deleteEntPres(ActionEvent event) {
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
                 es.deleteEntretien(entPres.getId());
                 System.out.println("entretien par téléphone supprimé " );
                 if (entTel != null ) {
                     NewCandidaturesRecruteurController.recSelectedCand.setEtat(EtatCandidature.EtatsCandidature.EntretienTel);
                     csr.updateCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId(), NewCandidaturesRecruteurController.recSelectedCand);
                 } else {
                     NewCandidaturesRecruteurController.recSelectedCand.setEtat(EtatCandidature.EtatsCandidature.Validée);
                     csr.updateCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId(), NewCandidaturesRecruteurController.recSelectedCand);
                }
                 this.reload();
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
    }

    @FXML
    private void refuser(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Etes-vous sures de vouloir refuser cette candidature?");
                alert.setContentText(("Suppression de la liste de candidatures de l'offre: " + 
                        NewCandidaturesRecruteurController.recSelectedCand.getIdOffre()));
                // manque le controle
                

                ButtonType buttonTypeYes = new ButtonType("Oui");
                ButtonType buttonTypeNo = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeYes){
                 // clic sur le bouton oui
                  NewCandidaturesRecruteurController.recSelectedCand.setEtat(EtatCandidature.EtatsCandidature.Refusée);
                     csr.updateCandidature(NewCandidaturesRecruteurController.recSelectedCand.getId(), NewCandidaturesRecruteurController.recSelectedCand);
                 System.out.println("candidature refusée " );
                 //redirection
                      try {
                  Parent root = FXMLLoader.load(getClass().getResource("./NewCandidaturesRecruteur.fxml"));
                  System.out.println("FXML loaded successfully");
                  Scene scene = new Scene(root);
                  Stage stage = (Stage) entretiensVB.getScene().getWindow();
                  stage.setScene(scene);
                  stage.show();
           
                 } catch (IOException e) {
                      e.printStackTrace();
                 }
                 
                } else {
                 // clic sur le bouton non
                 alert.close();
                }
        
    }

   
}

