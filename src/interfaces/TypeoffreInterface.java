/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import javafx.collections.ObservableList;
import models.Typeoffre;
import models.Offre;

/**
 *
 * @author Aziz Ben Guirat
 */
public interface TypeoffreInterface {
     public void addType(Typeoffre t);
    public void addType2(Typeoffre t);
    
    //list : select
    public List<Typeoffre> fetchOffres();
    
    public void updatetypeoffre(Typeoffre t,int idType);
    public void deletetypeoffre(int idType);
    public ObservableList<Typeoffre> getTypeDesc();
    public Typeoffre getelementbyid(int idType);

    public Typeoffre getelementbydescription(String description);
    
}
