/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class VisiteGuide {
    private int idVisiteGuide;
    private Date date_consultation;
    private Compte compte;
    private GuideEntretien guideentretien;

    public VisiteGuide() {
    }

    public VisiteGuide(int idVisiteGuide, Date date_consultation, Compte compte, GuideEntretien guideentretien) {
        this.idVisiteGuide = idVisiteGuide;
        this.date_consultation = date_consultation;
        this.compte = compte;
        this.guideentretien = guideentretien;
    }

    public VisiteGuide(Date date_consultation, Compte compte, GuideEntretien guideentretien) {
        this.date_consultation = date_consultation;
        this.compte = compte;
        this.guideentretien = guideentretien;
    }

    public int getIdVisiteGuide() {
        return idVisiteGuide;
    }

    public void setIdVisiteGuide(int idVisiteGuide) {
        this.idVisiteGuide = idVisiteGuide;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public GuideEntretien getGuideentretien() {
        return guideentretien;
    }

    public void setGuideentretien(GuideEntretien guideentretien) {
        this.guideentretien = guideentretien;
    }

    @Override
    public String toString() {
        return "VisiteGuide{" + "idVisiteGuide=" + idVisiteGuide + ", date_consultation=" + date_consultation + ", compte=" + compte + ", guideentretien=" + guideentretien + '}';
    }
    
    

}