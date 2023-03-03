/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Offre;
import java.sql.Date;

/**
 *
 * @author Aziz Ben Guirat
 */
public interface OffreInterface {
//     public void addOffre(Offre o);

    public void addOffre(Offre o);

    //list : select
    public List<Offre> fetchOffres();

    public void updateOffre(Offre o, int idOffre);

    public void updateOffrebydes(Offre o, String Description);

    public int typeByOffre(int idType);

    public void deleteOffre(int idOffre);

    public void deletebydes(String description);

    public Offre getelementbyid(int idOffre);

    public List<Offre> filterByEntreprise(String entreprise);

    public List<Offre> filterByDate(Date date);

    public Offre getelementbyDescription(String Description);

    public List<Offre> suggestedOffres(int idType, int idOffre);

}
