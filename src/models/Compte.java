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
    private String experience, photo,diplome,entreprise,domaine,poste ;
    private Date dateDiplome;
    private int idUser;
    
    //const
    public Compte() {
    }
    public Compte(String experience, String photo, String cv, String diplome, Date dateDiplome, String entreprise, int idUser) {
        this.experience = experience;
        this.photo = photo;
        this.diplome = diplome;
        this.dateDiplome = dateDiplome;
        this.entreprise = entreprise;
        this.idUser= idUser;
    }

    public Compte(int idCompte, String experience, String photo, String cv, String diplome, String entreprise, Date dateDiplome, int idUser) {
        this.idCompte = idCompte;
        this.experience = experience;
        this.photo = photo;
        this.diplome = diplome;
        this.entreprise = entreprise;
        this.dateDiplome = dateDiplome;
        this.idUser = idUser;
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

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    //display

    @Override
    public String toString() {
        return "Compte{" + "idCompte=" + idCompte + ", experience=" + experience + ", photo=" + photo + ", diplome=" + diplome + ", entreprise=" + entreprise + ", domaine=" + domaine + ", poste=" + poste + ", dateDiplome=" + dateDiplome + ", idUser=" + idUser + '}';
    }

    

   
        
    
    
}
    
    

