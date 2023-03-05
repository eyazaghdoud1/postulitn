/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dell
 */
public class GuideEntretien {
//    
//      //att
//     private int idguide;
//     private String domaine;
//     private String specialite;
//     private String support;
//     private double note;//nouveauuuu
//   
//
//        
//    public GuideEntretien() {
//    }
//
//    public GuideEntretien(int idguide, String domaine, String specialite, String support) {
//        this.idguide = idguide;
//        this.domaine = domaine;
//        this.specialite = specialite;
//        this.support = support;
//        
//    }

private int idguide;
private String domaine;
private String specialite;
private String support;
private double note;
private int nombreNotes;

public GuideEntretien() {
    this.nombreNotes = 0;
}

public GuideEntretien(int idguide, String domaine, String specialite, String support, int nombreNote,double note) {
    this.idguide = idguide;
    this.domaine = domaine;
    this.specialite = specialite;
    this.support = support;
    this.note= note;
    this.nombreNotes = nombreNote;
}


    
    //getters and setters
    public int getIdguide() {
        return idguide;
    }

    public void setIdguide(int idguide) {
        this.idguide = idguide;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
     }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }
    
    
    //nouveauuu
    public double getNote() {
    return note;
}

public void setNote(double note) {
    this.note = note;
}

    public int getNombreNotes() {
        return nombreNotes;
    }

    public void setNombreNotes(int nombreNotes) {
        this.nombreNotes = nombreNotes;
    }
    
     //display

    @Override
    public String toString() {
        return "GuideEntretien{" + "idguide=" + idguide + ", domaine=" + domaine + ", specialite=" + specialite + ", support=" + support + "note=" + note + '}';
    }

    
    
//    public void addNote(double note) {
//   double totalNote = this.note * this.nombreNotes + note;
//   this.nombreNotes++;
//   this.note = totalNote / this.nombreNotes;
//}

    
    
    
}

    

