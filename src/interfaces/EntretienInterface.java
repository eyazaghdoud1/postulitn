/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import models.Entretien;
import models.Candidature;

/**
 *
 * @author HP I5
 */
public interface EntretienInterface {
    public void addEntretien(Entretien e);
    public List<Entretien> fetchEntretiens();
    public Entretien getEntretienById(int idEntretien);
    public void deleteEntretien(int idEntretien);
    public void updateEntretien(int idEntretien, Entretien e);
    /* filtres */ 
    public List<Entretien> filterByDate(Date date);
    public List<Entretien> filterByCandidat(int idCandidat);
    public List<Entretien> filterByOffre(int idOffre);
    public List<Entretien> filterByCandidature (int idCandidature);
    public List<Entretien> filterByType (String type);

    /* resultat entretien */ 
    public void accepter(int idCandidature, boolean res);
    
}