/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postulitnapp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Candidature;
import models.Entretien;
import models.Quiz;
import models.QuizQuestion;
import models.QuizScore;
import services.CandidatureService;
import services.EntretienService;
import services.QuizQuestionService;
import services.QuizScoreService;
import services.QuizService;
import utilities.EtatCandidature;
import utilities.QuizReponse;
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
        //cs.valider(1, true);
        //Candidature cupdate = new Candidature(3, 2, "newurlcv", "newurlurllettre");
       
        
        /************************************* TEST DE L'AJOUT ****************************************/
        //System.out.println("/*** test de l'ajout d'une candidature ***/");
        //cs.addCandidature(c);
       
        /************************ TEST DE L'AFFICHAGE DES CANDIDATURES *******************************/
         //System.out.println("/*** test de l'affichage des candidatures ***/");
         //System.out.println(cs.fetchCandidatures());
        
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
        //System.out.println(cs.filterByEtat(EtatCandidature.EtatsCandidature.Enregistrée));
        // System.out.println(cs.filterByOffre(1));
        
        
        
        
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
        // System.out.println(es.filterByType(TypeEntretien.TypeE.Présentiel.toString()));
        
      /* cs.addCandidature(c);
       cs.valider(cs.getCandidatureById(10).getId(), true); */
       //cs.valider(cs.getCandidatureById(1).getId(), false);
       
       /******************************************** QUIZ *******************************************************/
       QuizService qs = new QuizService();
       QuizQuestionService qqs = new QuizQuestionService();
       Quiz quiz = new Quiz();
       quiz.setSecteur("Informatique");
       quiz.setSpecialite("Java");
       //qs.addQuiz(quiz);
      // System.out.println(qs.getQuizBySpecialite("Web"));
      
       quiz.setQuestions(qqs.fetchByQuiz(1));
       QuizQuestion q1 = new QuizQuestion("Quel concept de Java est un moyen de convertir des objets du monde réel en termes de classe?",
               "Encapsulation", "Abstraction", "Polymorphisme", "B", 1);
       QuizQuestion q2 = new QuizQuestion("Comment ça s’appelle si un objet a son propre cycle de vie?",
               "Agrégation", "Composition", "Association", " C", 1);
       QuizQuestion q3 = new QuizQuestion("Les expressions lambda dans java 8 sont basées sur?",
               "Programmation procédurale", "Programmation fonctionnelle", "Programmation des données", "B", 1);
       
       QuizQuestion q4 = new QuizQuestion("Par quoi se caractérise PreparedStatement en Java?",
               "Ralentissement des performances", "Utilise plus de mémoire", "Empêche l’injection SQL", "C", 1);
       
       qqs.addQuizQuestion(q4);
       
       QuizQuestion q5 = new QuizQuestion("Quand les exceptions surviennent-elles dans un code Java?",
               "Au moment de l’exécution", "Le moment de compilation", "Peut survenir à tout moment", "A", 1);
       
       qqs.addQuizQuestion(q5);
       //System.out.println(qs.getQuizById(1).getQuestions().size());
       /*qqs.addQuizQuestion(q2);
       qqs.addQuizQuestion(q3);*/
      /* QuizReponse rep = new QuizReponse();
       Scanner sc = new Scanner(System.in);
       List<String> resps = new ArrayList<>();
       for (QuizQuestion qq: quiz.getQuestions()) {
       System.out.println( qq.getQuestion());
       System.out.println("A: "  + qq.getOption1());
       System.out.println("B: " + qq.getOption2());
       System.out.println("C: " + qq.getOption3());
       String r = sc.nextLine();
       resps.add(r);
       }
       rep.setReponses(resps);
       QuizScore score = new QuizScore();
       score.setIdCandidat(1);
       score.setQuiz(quiz);
       QuizScoreService qss = new QuizScoreService();
       qss.calculerScore(score, rep);
       System.out.println(score.getScore());*/
       
       
       
        
    }
    
}
