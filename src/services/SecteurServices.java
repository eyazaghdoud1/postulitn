/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ProjetInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.ProjetFreelance;
import Models.Secteur;
import interfaces.SecteurInterface;
import utilities.MaConnexion;

/**
 *
 * @author Users
 */
public class SecteurServices implements SecteurInterface{
    
  //var  
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    
//ajout d'un secteur 
  
    @Override
    public void addSecteur(Secteur s) {
        try {
            
            String req = "INSERT INTO `secteurs` (`idSecteur`,`description`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, s.getIdSecteur());
            ps.setString(2, s.getDescription());
            ps.executeUpdate();
            System.out.println("Secteur ajouté avec succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }
    
    //selection de tous les secteur

    @Override
    public List<Secteur> fetchSecteur() {
        List<Secteur> secteurs = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM secteurs";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Secteur p = new Secteur();
                p.setIdSecteur(rs.getInt(1));
                p.setDescription(rs.getString(2));
                secteurs.add(p);
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return secteurs;
    }
    
    

   
    @Override
    public Secteur getById(int idSecteur) {
        
     Secteur s = new Secteur();

         try {
             String req = "SELECT * FROM secteurs where idSecteur = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,idSecteur);
             ResultSet rs = ps.executeQuery();
             rs.next();
              s.setIdSecteur(rs.getInt(1));
              s.setDescription(rs.getString(2));
             
         } catch (SQLException ex) {
             Logger.getLogger(ProjetServices.class.getName()).log(Level.SEVERE, null, ex);
         }
         return s;
    }

  

      
      //UPDATE
  @Override
    public void UpdateSecteur(int id, Secteur s){
         try {
             String req ="UPDATE secteurs SET `description`= ? WHERE idSecteur = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, s.getDescription());
             ps.setInt(2, id);
             ps.executeUpdate();
             System.out.println("secteur modifié avec succes"); 
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
    }
    
    //SUPPRIMER un secteur
    
    @Override
      public void deleteSecteurById(Secteur s) {
         try {
             String req ="DELETE FROM `secteurs` WHERE idSecteur = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, s.getIdSecteur());
             ps.executeUpdate();
             System.out.println("Secteur supprimé avec succes"); 
         } catch (SQLException ex) {
           ex.printStackTrace(); 
         }

      }
     
      //filtrer par description 
    @Override
      public List<Secteur> filterByDescription(String Des) {
        List<Secteur> SecteurFiltres = new ArrayList<>() ;
        String req = "select * from secteurs where description=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, Des);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             Secteur s = new Secteur();
            s.setIdSecteur(rs.getInt(1));
            s.setDescription(rs.getString(2));
                SecteurFiltres.add(s);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return SecteurFiltres;
    }

   public Secteur getsecteurbydescription(String description) {
      
      Secteur s = new Secteur(); 

         try {
             String req = "SELECT * FROM secteurs where description = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,description);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             
              s.setIdSecteur(rs.getInt(1));
              s.setDescription(rs.getString(2));}
             
         } catch (SQLException ex) {
              ex.printStackTrace();
            
         
    }
         return s;
    }
    
}
