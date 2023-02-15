/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Candidature;

/**
 *
 * @author HP I5
 */
public interface CandidatureInterface {
    public void addCandidature(Candidature c);
    public List<Candidature> fetchCandidatures();
    public Candidature getCandidatureById(int idCandidature);
    public void deleteCandidature(int idCandidature);
    public void updateCandidature(int idCandidature, Candidature c);
    /* filtres */ 
    public List<Candidature> filterByCandidat(int idCandidat);
    public List<Candidature> filterByOffre(int idOffre);

    
}