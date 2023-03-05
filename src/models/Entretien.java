/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author HP I5
 */
public class Entretien implements Comparable<Entretien> {

    private int id;
    private Candidature candidature; 
    /* type: par tel ou en presentiel */
    private String type; 
    private Date date;
    private String heure; 
    private String lieu;
    private int guideId;
    
    /* constructeur vide */
    public Entretien() {
    }

    /* constructeur pour l'ajout en bdd */
    public Entretien(Candidature candidature, String type, Date date, String heure, String lieu, int guideId) {
        this.candidature = candidature;
        this.type = type;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.guideId = guideId;
    }
    /* test */
    public Entretien(Candidature candidature, String type, String heure, String lieu, int guideId) {
        this.candidature = candidature;
        this.type = type;
        this.heure = heure;
        this.lieu = lieu;
        this.guideId = guideId;
    }

    /* constructeur pour la lecture à partir de la bdd */
    public Entretien(int id, Candidature candidature, String type, Date date, String heure, String lieu, int guideId) {
        this.id = id;
        this.candidature = candidature;
        this.type = type;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.guideId = guideId;
    }

    /* getters and setters */ 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidature getCandidature() {
        return candidature;
    }
    public int getCandidatureId() {
        return candidature.getId();
    }

    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId (int guideId) {
        this.guideId = guideId;
    }

    @Override
    public String toString() {
        return "Entretien{" + "id=" + id + ", candidature=" + candidature + ", type=" + type + ", date=" + date + ", heure=" + heure + ", lieu=" + lieu + ", idGuide=" + guideId + '}';
    }

    @Override
    public int compareTo(Entretien o) {
        return o.getDate().compareTo(this.getDate());
    }

    

    
}

