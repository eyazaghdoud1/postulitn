/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.util.List;
import models.GuideEntretien;
import models.Compte;

/**
 *
 * @author dell
 */
public interface GuideEntretienInterface {
    
    //add
    public void addGuideEntretien(GuideEntretien ge);    
    //list : select
    public List<GuideEntretien> fetchGuideEntretien();
    
    //modif
    public void updateGuideEntretien(int idGuide, GuideEntretien ge);
    
    //delete
    public void deleteGuideEntretien(GuideEntretien ge);
    //getbyid
    public GuideEntretien GetByIdGuideEntretiens(int id);
    //filtrer par domaine
    public List<GuideEntretien> filterBydomaine(String domaine);
    //filtrer par specia
    public List<GuideEntretien> filterByspecialite(String specialite);
}
