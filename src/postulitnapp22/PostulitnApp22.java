/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package postulitnapp22;

import interfaces.GuideEntretienInterface;
import java.sql.Date;
import java.time.LocalDate;
import models.GuideEntretien;
import models.Compte;
import models.VisiteGuide;
import services.CompteServices;
import services.GuideEntretienService;
import services.VisiteGuideService;


/**
 *
 * @author dell
 */
public class PostulitnApp22 {

   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // service init
       GuideEntretienInterface ges = new GuideEntretienService();
       CompteServices cs = new CompteServices();
       VisiteGuideService vgs= new VisiteGuideService();
       
       
     //  Ajout d'un guides entretien
//       GuideEntretien ge = new GuideEntretien();
//       ge.setDomaine("sport");
//       ge.setSpecialite("joueurpro");
//       ge.setSupport("css");
//       ges.addGuideEntretien(ge);
//  
     
     //ajout compte 
  /*      Compte c = new Compte();
          c.setPhoto("tof");
          c.setCv("ti cv ");
          c.setDiplome("ganiouur");
          c.setDateDiplome(Date.valueOf("2000-09-08"));
          c.setEntreprise("Esprit");
          c.setExperience("kbira");         
          cs.addCompte(c);
    */      
    
    
    
    
//**************************Get by id compte******************************* 
      //System.out.println(cs.GetByIdCompte(2));
      
      
//**************************get by id guide******************************
  //  System.out.println(ges.GetByIdGuideEntretiens(10));
     
      
//***************************afficher la liste des comptes*********************  
   //  System.out.println(cs.fetchComptes());
     
 
 //**************************afficher la liste des guides***********************
   //   System.out.println(ges.fetchGuideEntretien());
        
    
     
     
//*************************supprimer guide entretien************************ 
   //   ges.deleteGuideEntretien(ges.GetByIdGuideEntretiens(10));
       
//*************************supprimer compte************************************
      // cs.deleteCompte(cs.GetByIdCompte(2));

       
        
//*****************************Modifier compte********************************** 
        // cs.updateCompte(6, c);
 
//*************************Modifier guide entretien*****************************
    //     ges.updateGuideEntretien(4, ge);
 
 

//       c.setIdCompte(3);
//       c.setIdCompte(4);
//       c.setIdCompte(5);


//***********************les filtres guides entretien***************************
  //  System.out.println(ges.filterBydomaine("infoo"));
   //   System.out.println(ges.filterByspecialite("BI"));



        
        
//*****************************ajouter une visite*******************************
       // visite guide entretien init
//        VisiteGuide v = new VisiteGuide();
//          v.setDate_consultation(Date.valueOf("2027-02-05"));
//          v.setGuideentretien(ges.GetByIdGuideEntretiens(10));
//          v.setCompte (cs.GetByIdCompte(9));
//          
//         vgs.addVisiteGuide(v);
         
//*************************afficher la liste des visites***************************
         //System.out.println(vgs.fetchVisites());
       
         
//****************************filter by compte*************************************
      //   vgs.filterByCompte(9);
        
         
         
         
         
         
         
         
        
        
        
        
        
        
        
        
        
        
               // GuideEntretien ge = new GuideEntretien();      
              // ge.setIdguide(4);
         //init compte      
        // Compte c = new Compte();
        // c.setIdCompte(2);
        // ge.setIdguide(3);
    }
    
}