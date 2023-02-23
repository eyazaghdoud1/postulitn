/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import interfaces.OffreInterface;
import models.Offre;
import services.OffreService;
import interfaces.TypeoffreInterface;
import java.sql.Date;
import java.time.LocalDate;
import models.Typeoffre;
import services.TypeoffreService;

/**
 *
 * @author Aziz Ben Guirat
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OffreService ps = new OffreService();
        TypeoffreService ts = new TypeoffreService();
        
      //  Player init;
         Offre o = new Offre();
        Typeoffre to = ts.getelementbyid(4);
//        ***********************ADD***********************************************************************************
//         o.setPoste("freelancer2");
//         o.setDescription("twil");
//         o.setLieu("sfax");
//         o.setEntreprise("focus");
//         o.setSpecialite("twin");
//        o.setDateExpiration(Date.valueOf("2024-11-19"));
//        o.setIdRecruteur(5);
//        o.setType(to);
          
//add action

// ps.addOffre(o);
//        System.out.println("Offre Added Successfully!");
        
        
   
//*******************************SELECT OFFRE****************************************************************************
        System.out.println("les offres");
       System.out.println(ps.fetchOffres());
//*****************************DELETE*************************************************************************************
       //ps.deleteOffre(37);
//               // System.out.println("apres delete");
//*****************OFFRE PAR ID*******************************************************************************************
             //  System.out.println("l'offre par son id");
             //  System.out.println(ps.getelementbyid(24));

        
//        
//**************************SELECT TYPE***********************************************************************************
System.out.println("les types");
      TypeoffreInterface pt = new TypeoffreService();
         Typeoffre t = new Typeoffre();
         t.setDescription("mitemps");
         // pt.addType2(t);
         System.out.println(pt.fetchOffres());
      // t.setDescription("stage2");
     // pt.updatetypeoffre(t,1);
         //***************DELETE TYPE*************************************************************************************
   //       pt.deletetypeoffre(11);
        
//        ************************GET TYPE ID******************************************************************************
//        System.out.println("le type d'offre par son id");
//        System.out.println(ts.getelementbyid(4));
//        
//        *************************FILTRE PAR ENTREPRISE et Date********************************************************************
      //  System.out.println("le filtre par entreprise");
//        System.out.println(ps.filterByEntreprise("aziza"));
//        System.out.println("le filtre par date");
//        System.out.println(ps.filterByDate(Date.valueOf("2028-01-06")));
        
        

//*********************UPDATE OFFRE************************************************************************************************
//       o.setPoste("aaaaa");
//         o.setDescription("twil");
//         o.setLieu("marsa");
//        o.setEntreprise("aziza");
//         o.setSpecialite("najjar");
       //  o.setDateExpiration(Date.valueOf("2022-02-09"));
        // o.setType(ts.getelementbyid(4));
////         
      // ps.updateOffre(o, 24);



  //*******************************UPDATE TYPE OFFRE *************************
      //  to.setDescription("embauche");
      //  pt.updatetypeoffre(to, 4);
      
  //*************************getelementbydescription*************    
        System.out.println("le type d'offre par son description");
        System.out.println(ts.getelementbydescription("embauche"));
        
    }
    
}
