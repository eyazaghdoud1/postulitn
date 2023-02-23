/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import java.sql.Date;
import models.Candidature;
import models.Entretien;
import services.CandidatureService;
import services.EntretienService;
import utilities.EtatCandidature;
import utilities.TypeEntretien;

/**
 *
 * @author HP I5
 */
public class PostulitnApp {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
       /************************************* CANDIDATURES *******************************************/
        /* instance de Candidature */
        /*Candidature c1 = new Candidature(1, 1, "urlcv", "urllettre");
        Candidature c2 = new Candidature(2, 1, "urlcv", "urllettre");
        Candidature c3 = new Candidature(1, 2, "urlcv", "urllettre");
        Candidature c4 = new Candidature(2, 2, "cv", "lettre", Date.valueOf("2023-02-14"));*/
        //Candidature c = new Candidature(9, 3, "cv", "lettre");
        /* instance de CandidatureService */
        CandidatureService cs = new CandidatureService();
        //Candidature c = cs.getCandidatureById(1);
        cs.valider(1, true);
        //Candidature cupdate = new Candidature(3, 2, "newurlcv", "newurlurllettre");
       
        
        /************************************* TEST DE L'AJOUT ****************************************/
        //System.out.println("/*** test de l'ajout d'une candidature ***/");
        //cs.addCandidature(c);
       
        /************************ TEST DE L'AFFICHAGE DES CANDIDATURES *******************************/
         //System.out.println("/*** test de l'affichage des candidatures ***/");
         System.out.println(cs.fetchCandidatures());
        
        /************************ TEST DE LA MODIFICATION DE CANDIDATURE *****************************/
         //System.out.println("/*** test de la modification des candidatures ***/");
         //Candidature cupdate = new Candidature(3, 2, "NEWURLCV", "NEWLETTRE");
        /* Candidature cup = new Candidature();
         cup.setIdCandidat(1);
         cup.setIdOffre(1);
         cup.setEtat(EtatCandidature.EtatsCandidature.Enregistrée);
         cs.updateCandidature(1, cup);*/
        
        
        /************************ TEST DE LA SUPPRESSION DE CANDIDATURE ******************************/
        //System.out.println("/*** test de la suppression de candidature ***/");
       //cs.deleteCandidature(8);
        
        
        /****************************** TEST DE getCandidatureById ***********************************/
        //Candidature newc = cs.getCandidatureById(2);
        
        //System.out.println(cs.getCandidatureById(2));
        
        /******************************** TEST DES FILTRES ******************************************/
        /* test de filtrer candidatures by candidat */ 
        //System.out.println(cs.filterByCandidat(1));
        
        
        
        
        /****************************************** ENTRETIENS ***************************************/
        EntretienService es = new EntretienService();
        //es.addEntretien(e1);
        //es.getEntretienById(3);
        //System.out.println(es.getEntretienById(3).getType().equalsIgnoreCase("telephone"));
        /* instance d'entretien */ 
       // Entretien e1 = new Entretien(cs.getCandidatureById(2), "presentiel", Date.valueOf("2023-02-14"), "9:00", "");
        //Entretien e = new Entretien(cs.getCandidatureById(5), TypeEntretien.TypeE.Présentiel.toString(), "9:00", "menzah", 1);
        /* ajout d'entretien */
        //System.out.println("/*** test de l'ajout d'un entretien ***/");
        //es.addEntretien(e);
        
        /* liste des entretiens */
        //System.out.println("/*** test de l'affichage des entretiens ***/");
        // System.out.println(es.fetchEntretiens());
         
        /* filtrer par offre */ 
        //System.out.println("/*** test de la recherche des entretiens  par offre ***/");
//        System.out.println(es.filterByOffre(1) );
//        System.out.println("/*** test de la recherche des entretiens  par candidature ***/");
//        System.out.println(es.filterByCandidature(2) );
//        System.out.println("/*** test de la recherche des entretiens  par candidat ***/");
//        System.out.println(es.filterByCandidat(1) );
         // System.out.println(es.filterByDate(Date.valueOf("2023-02-14") ));
         //System.out.println(es.filterByType("presentiel"));
        
      /* cs.addCandidature(c);
       cs.valider(cs.getCandidatureById(10).getId(), true); */
       //cs.valider(cs.getCandidatureById(1).getId(), false);
        
    }
    
}
