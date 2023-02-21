/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import utilities.EtatCandidature;



/**
 *
 * @author HP I5
 */
public class Candidature {
    
    private int id;
    // private Utilisateur candidat;
    private int idCandidat;
    // private Offre offre;
    private int idOffre;
    private String cv; 
    private String lettre;
    private Date date;
    private EtatCandidature.EtatsCandidature etat;


    /* constructeur non paramètré */
    public Candidature() {
    }

     
    /* constructeur pour l'ajout en bdd */
    public Candidature(int idCandidat, int idOffre, String cv, String lettre) {
        this.idCandidat = idCandidat;
        this.idOffre = idOffre;
        this.cv = cv;
        this.lettre = lettre;
        this.date = new Date(System.currentTimeMillis()) ;
    }

    /* constructeur pour la récupération de la bdd */
    public Candidature(int id, int idCandidat, int idOffre, String cv, String lettre, Date date, EtatCandidature.EtatsCandidature etat) {
        this.id = id;
        this.idCandidat = idCandidat;
        this.idOffre = idOffre;
        this.cv = cv;
        this.lettre = lettre;
         this.date = date ;
        this.etat = etat;
    }
    
    /* getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public EtatCandidature.EtatsCandidature getEtat() {
        return etat;
    }

    public void setEtat(EtatCandidature.EtatsCandidature etat) {
        this.etat = etat;
    }

    
    /* methode toString */
    @Override
    public String toString() {
        return "Candidature{" + "id=" + id + ", idCandidat=" + idCandidat + ", idOffre=" + idOffre + ", cv=" + cv + ", lettre=" + lettre + ", date=" + date + ", etat=" + etat + '}';
    }
    
    
   
    
}
