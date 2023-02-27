/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
import models.VisiteGuide;

/**
 *
 * @author dell
 */
public class Compte {
    
    
 //att
    private int idCompte;
    private String experience, photo,cv ,diplome,entreprise ;
    private Date dateDiplome;
    
    //const
    public Compte() {
    }
    public Compte(String experience, String photo, String cv, String diplome, Date dateDiplome, String entreprise) {
        this.experience = experience;
        this.photo = photo;
        this.cv = cv;
        this.diplome = diplome;
        this.dateDiplome = dateDiplome;
        this.entreprise = entreprise;
    }

    public Compte(int idCompte, String experience, String photo, String cv, String diplome, String entreprise, Date dateDiplome) {
        this.idCompte = idCompte;
        this.experience = experience;
        this.photo = photo;
        this.cv = cv;
        this.diplome = diplome;
        this.entreprise = entreprise;
        this.dateDiplome = dateDiplome;
    }
    
    public int getIdCompte() {
        return idCompte;
    }

    //getters and setters
    public void setIdCompte(int idCompte) {    
        this.idCompte = idCompte;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }
    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
    this.entreprise = entreprise;
    }
    
    //display

    @Override
    public String toString() {
        return "Compte{" + "experience=" + experience + ", photo=" + photo + ", cv=" + cv + ", diplome=" + diplome + ", entreprise=" + entreprise + ", dateDiplome=" + dateDiplome + '}';
    }

    
        
    
    
}
    
    

