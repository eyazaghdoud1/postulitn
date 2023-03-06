/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ezine
 */
public class FreelancersP {
    private int id; 
    private int idProjet;
    private Utilisateur utilisateur; 

    
    //constructors
    public FreelancersP() {
    }

    public FreelancersP(int id, int idProjet, Utilisateur utilisateur) {
        this.id = id;
        this.idProjet = idProjet;
        this.utilisateur = utilisateur;
    }

    public FreelancersP(int idProjet, Utilisateur utilisateur) {
        this.idProjet = idProjet;
        this.utilisateur = utilisateur;
    }

    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    //show 

    @Override
    public String toString() {
        return "FreelancersP{" + "id=" + id + ", idProjet=" + idProjet + ", utilisateur=" + utilisateur + '}';
    }
    
   
    
    
}
