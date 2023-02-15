/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import Models.ProjetFreelance;
import Models.Secteur;
import interfaces.ProjetInterface;
import java.sql.Date;
import services.ProjetServices;
import services.SecteurServices;
        
/**
 *
 * @author Users
 */
public class PostulitnApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProjetInterface ps = new ProjetServices(); 
        SecteurServices ss = new SecteurServices();
        
        
//***************************************  AJOUT DES SECTEURS  *********************************************************************************
//         Secteur s = new Secteur("info");
//         Secteur s2 = new Secteur("finance");
//         Secteur s3 = new Secteur("marketing");
//         Secteur s4 =new Secteur("sécurité"); 
//         ss.addSecteur(s4);
          
//***************************************  AJOUT DES PROJETS ***********************************************************************************    
//          ProjetFreelance p = new ProjetFreelance(7,3, "info", "desc", Date.valueOf("2013-09-04"), Date.valueOf("2013-09-09"), ss.getById(1));
//          ProjetFreelance p2 = new ProjetFreelance(8,3, "info", "desc", Date.valueOf("2013-09-04"), Date.valueOf("2013-09-09"), ss.getById(1));
//          ProjetFreelance p3 = new ProjetFreelance(3,"archi", "desc", Date.valueOf("2013-09-06"), Date.valueOf("2013-12-09"), ss.getById(14));
//          ProjetFreelance p3 = new ProjetFreelance(7,"securite", "desc", Date.valueOf("2013-05-02"), Date.valueOf("2013-12-02"), ss.getById(15),);
//         ProjetFreelance p5 = new ProjetFreelance(7,"securite", "desc", Date.valueOf("2013-05-02"), Date.valueOf("2013-12-02"), ss.getById(15),7);
         
//         ps.addProjet(p5);
//          ps.addProjet(p2);
//          ps.addProjet(p3);
//          ps.addProjet(p3);



//OU BIEN 
//            ProjetFreelance p = new ProjetFreelance
//            p.setTheme("info");
//            p.setDescription("projet freelance en info");
//            p.setDuree(3);
//            p.setDateDebut(Date.valueOf("2013-09-04"));
//            p.setDateFin(Date.valueOf("2013-09-09")); 
//            ps.addProjet(p);

//********************************************  GET BY ID  *****************************************
//        System.out.println(ss.getById(15));
//          System.out.println(ps.getById(12));




           
//************************************ UPDATE DU PROJET  ****************************************** 
//             ProjetFreelance p = new ProjetFreelance();
//             p.setTheme("theme");
//             p.setDescription("test");
//             p.setDuree(23);
//             p.setDateDebut(Date.valueOf("2022-02-07"));
//             p.setDateFin(Date.valueOf("2022-02-09"));
//             p.setS(ss.getById(1));
//             ps.UpdateProjet(10,p);


//************************************ UPDATE DES SECTEURS  ****************************************** 
//              Secteur s4 = new Secteur();
//              s4.setDescription("test");
//              s4.setIdSecteur(20);
//              Secteur s = new Secteur();
//              s.setDescription("test");
//              ss.UpdateSecteur(9,s);



//***************************************   LES FILTRES: PROJETS  ***************************************
//        System.out.println(ps.filterBySecteur(14));
//        System.out.println(ps.filterByDuree(3));
//        System.out.println(ps.filterByTheme("sécurité"));



//***************************************   LES FILTRES: SECTEURS  ***************************************        
//        System.out.println(ss.filterByDescription("info"));


//***************************************   AFFICHAGE DES PROJETS ET DES SECTEURS  ***************************************
//        System.out.println(ss.fetchSecteur());
//        System.out.println(ps.fetchProjet());



//***************************************   SUPPRESSION DES PROJETS ET SECTEURS   ***************************************
//        ps.deleteProjetById(p3);
//        ss.deleteSecteurById(s4);
    }
   
    
}
