/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author dell
 */
import models.VisiteGuide;
import java.util.List;

public interface VisiteGuideInterface {
    public void addVisiteGuide(VisiteGuide v);
    public List<VisiteGuide> fetchVisites();
    public List<VisiteGuide> filterByCompte(int idCompte);
    
}
