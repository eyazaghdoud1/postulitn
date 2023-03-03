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
import Models.Commentaire;
import utilities.MyConnexion;

/**
 *
 * @author Users
 */
public class ProjetServices implements ProjetInterface {
    
     Connection cnx = MyConnexion.getInstance().getCnx();
     
 
     
     //INSERT
   
    @Override
    public void addProjet(ProjetFreelance p) {
         try {
             String req = "INSERT INTO `projets` (`theme`, `description`, `duree`, `dateDebut`, `dateFin`, `idSecteur`,`idResponsable`,`Nom`) VALUES (?,?,?,?,?,?,?,?)";
             PreparedStatement ps = cnx.prepareStatement(req); 
             ps.setString(1, p.getTheme());
             ps.setString(2, p.getDescription());
             ps.setInt(3, p.getDuree());
             ps.setDate(4, p.getDateDebut());
             ps.setDate(5, p.getDateFin());
             ps.setInt(6, p.getS().getIdSecteur());
             ps.setInt(7, p.getIdResponsable());
             ps.setString(8, p.getNom());
             ps.executeUpdate();
             System.out.println("Projet ajouté avec succes");
         } catch (SQLException ex) {
          ex.printStackTrace();   
         }
    
    }

    
    //SELECT
    @Override
    public List<ProjetFreelance> fetchProjet() {
             List<ProjetFreelance> projets = new ArrayList<>();
             
        try {
             String req = "SELECT * FROM projets"; 
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()) {
                 ProjetFreelance p = new ProjetFreelance();
                 p.setIdProjet(rs.getInt(1));
                 p.setTheme(rs.getString(2));
                 p.setDescription(rs.getString(3));
                 p.setDuree(rs.getInt(4));
                 p.setDateDebut(rs.getDate(5));
                 p.setDateFin(rs.getDate(6));
  
                
                 String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 ResultSet rs1 = ps1.executeQuery(); 
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                s.setDescription(rs1.getString(2));  
                 p.setS(s);
                 p.setIdResponsable(rs.getInt(8));
                 p.setNom(rs.getString(9));
          
                 projets.add(p); 
             }
         } catch (SQLException ex) {
              ex.printStackTrace();
         }
       return projets; 
    }

      //UPDATE
 
     @Override
    public void UpdateProjet(int id, ProjetFreelance p) {
         try {
             String req ="UPDATE projets SET `theme`=?,`description`=?, `duree`=?, `DateDebut`=?, `DateFin`=?, `idsecteur`= ?, `idResponsable`= ? WHERE idProjet = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, p.getTheme());
             ps.setString(2, p.getDescription());
             ps.setInt(3, p.getDuree());
             ps.setDate(4, p.getDateDebut());
             ps.setDate(5, p.getDateFin());
             ps.setInt(6, p.getS().getIdSecteur());
             ps.setInt(7, id);
             ps.setInt(8, p.getIdResponsable());
             ps.setString(9, p.getNom());
             ps.executeUpdate();
             System.out.println("Projet modiifié avec succes"); 
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
    }

    
  
     //GETBYID 
 @Override
      public ProjetFreelance getById(int idProjet) {
         
          ProjetFreelance p = new ProjetFreelance();
          try {
             String req = "SELECT * FROM projets where idProjet = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, idProjet);
             ResultSet rs = ps.executeQuery();
            
             if (rs.next()) {
            
             p.setIdProjet(rs.getInt(1));   
             p.setTheme(rs.getString(2));
             p.setDescription(rs.getString(3));
             p.setDuree(rs.getInt(4));
             p.setDateDebut(rs.getDate(5));
             p.setDateFin(rs.getDate(6));
            
             String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 
                 ResultSet rs1 = ps1.executeQuery();
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                 s.setDescription(rs1.getString(2));
                 p.setS(s);
                 p.setIdResponsable(rs.getInt(8));
                 p.setNom(rs.getString(9));
          }
             else System.err.println("vide");
         } catch (SQLException ex) {
             Logger.getLogger(ProjetServices.class.getName()).log(Level.SEVERE, null, ex);
         } 
                 
     
         return p;
     }
      
      //DELETE
     @Override
     public void deleteProjetById(ProjetFreelance p) {
         try {
             String req ="DELETE FROM `projets` WHERE idProjet = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, p.getIdProjet());
             ps.executeUpdate();
             System.out.println("Projet supprimé avec succes"); 
         } catch (SQLException ex) {
           ex.printStackTrace(); 
         }

         
    
}
     
     //Filtrer par secteur 

    @Override
    public List<ProjetFreelance> filterBySecteur(int idS) {
         List<ProjetFreelance> ProjFiltres = new ArrayList<>() ;
             
        try {
             String req = "SELECT * FROM projets WHERE IdSecteur= ?"; 
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, idS);
             ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
                 ProjetFreelance p = new ProjetFreelance();
                 p.setIdProjet(rs.getInt(1));
                 p.setTheme(rs.getString(2));
                 p.setDescription(rs.getString(3));
                 p.setDuree(rs.getInt(4));
                 p.setDateDebut(rs.getDate(5));
                 p.setDateFin(rs.getDate(6));
                String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 ResultSet rs1 = ps1.executeQuery(); 
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                s.setDescription(rs1.getString(2));  
                 p.setS(s);
                p.setIdResponsable(rs.getInt(8));
                p.setNom(rs.getString(9));
                 ProjFiltres.add(p); 
        }
         } catch (SQLException ex) {
              ex.printStackTrace();
         }
       return ProjFiltres; 
    }
    
    //Filtrer par theme 
    
    public List<ProjetFreelance> filterByTheme(String theme) {
        List<ProjetFreelance> ProjetTFiltres = new ArrayList<>() ;
        String req = "select * from Projets where theme=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, theme);
            ResultSet rs = ps.executeQuery();
           while (rs.next()) {
                 ProjetFreelance p = new ProjetFreelance();
                 p.setIdProjet(rs.getInt(1));
                 p.setTheme(rs.getString(2));
                 p.setDescription(rs.getString(3));
                 p.setDuree(rs.getInt(4));
                 p.setDateDebut(rs.getDate(5));
                 p.setDateFin(rs.getDate(6));
                    String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 ResultSet rs1 = ps1.executeQuery(); 
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                 s.setDescription(rs1.getString(2));  
                 p.setS(s);
                 p.setIdResponsable(rs.getInt(8));
                 p.setNom(rs.getString(9));
                 ProjetTFiltres.add(p);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return  ProjetTFiltres;
    }
 
    //filtrer par duree 
    
     @Override
     public List<ProjetFreelance> filterByDuree(int Duree) {
        List<ProjetFreelance> ProjetDFiltres = new ArrayList<>() ;
        String req = "select * from Projets where duree=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, Duree);
            ResultSet rs = ps.executeQuery();
           while (rs.next()) {
                 ProjetFreelance p = new ProjetFreelance();
                 p.setIdProjet(rs.getInt(1));
                 p.setTheme(rs.getString(2));
                 p.setDescription(rs.getString(3));
                 p.setDuree(rs.getInt(4));
                 p.setDateDebut(rs.getDate(5));
                 p.setDateFin(rs.getDate(6));
                 String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 ResultSet rs1 = ps1.executeQuery(); 
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                s.setDescription(rs1.getString(2));  
                 p.setS(s);
                  p.setIdResponsable(rs.getInt(8));
                  p.setNom(rs.getString(9));
                  ProjetDFiltres.add(p);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return  ProjetDFiltres;
    }
     
     
 
     public List<ProjetFreelance> filterByIdResponsable(int IdResponsable) {
        List<ProjetFreelance> ProjetRFiltres = new ArrayList<>() ;
        String req = "select * from Projets where idResponsable=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, IdResponsable);
            ResultSet rs = ps.executeQuery();
           while (rs.next()) {
                 ProjetFreelance p = new ProjetFreelance();
                 p.setIdProjet(rs.getInt(1));
                 p.setTheme(rs.getString(2));
                 p.setDescription(rs.getString(3));
                 p.setDuree(rs.getInt(4));
                 p.setDateDebut(rs.getDate(5));
                 p.setDateFin(rs.getDate(6));
                                String r = "SELECT * FROM secteurs where idSecteur = ?";
                 PreparedStatement ps1 = cnx.prepareStatement(r);
                 ps1.setInt(1, rs.getInt(7));
                 ResultSet rs1 = ps1.executeQuery(); 
                 rs1.next();
                 Secteur s = new Secteur();
                 s.setIdSecteur(rs1.getInt(1));
                 s.setDescription(rs1.getString(2));  
                 p.setS(s);
                 p.setIdResponsable(rs.getInt(8));
                 p.setNom(rs.getString(9));
                 ProjetRFiltres.add(p);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return  ProjetRFiltres;
    }
    
    

}