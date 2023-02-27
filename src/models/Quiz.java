/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author HP I5
 */
public class Quiz {
    private int id;
    // private Secteur secteur;
    private String secteur;
    private String specialite;
    private List<QuizQuestion> questions;
    
    // constructeurs

    public Quiz() {
    }

    public Quiz(int id, String secteur, String specialite, List<QuizQuestion> questions) {
        this.id = id;
        this.secteur = secteur;
        this.specialite = specialite;
        //this.questions = questions;
    }

    public Quiz(String secteur, String specialite) {
        this.secteur = secteur;
        this.specialite = specialite;
        
    }
    public Quiz(int id, String secteur, String specialite) {
        this.id = id;
        this.secteur = secteur;
        this.specialite = specialite;
        
    }

    // getters and setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }
    
    // toString method

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", secteur=" + secteur + ", specialite=" + specialite + ", questions=" + questions + '}';
    }
    
    
}
