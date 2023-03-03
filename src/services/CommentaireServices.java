/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Commentaire;
import interfaces.CommentaireInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import utilities.MyConnexion;

/**
 *
 * @author Users
 */
public class CommentaireServices implements CommentaireInterface {
    
  //var  
    Connection cnx = MyConnexion.getInstance().getCnx();
    
    
//ajout d'un commentaire
  
    @Override
    public void addCommentaire(Commentaire  c) {
        try {
            
            String req = "INSERT INTO `commentaires` (`idCommentaire`,`contenu`,`idUser`,`idProjet`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, c.getIdCommentaire());
            ps.setString(2, c.getContenu());
            ps.setInt(3, c.getIdUser());
            ps.setInt(4, c.getIdProjet());
            ps.executeUpdate();
            System.out.println("Commentaire ajouté avec succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }
    
    //selection de tous les commentaire


    @Override
    public List<Commentaire> fetchCommentaire() {
        List<Commentaire> commentaires = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM commentaires";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Commentaire c = new Commentaire();
                c.setIdCommentaire(rs.getInt(1));
                c.setContenu(rs.getString(2));
                c.setIdUser(rs.getInt(3)); 
                c.setIdProjet(rs.getInt(4));
                commentaires.add(c);
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return commentaires;
    }
    
    

   
  
    @Override
    public Commentaire getById(int idCommentaire) {
         Commentaire c = new Commentaire();
        try {  
            String req = "SELECT * FROM commentaires where idCommentaire = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idCommentaire);
            ResultSet rs = ps.executeQuery();
            rs.next();
            c.setIdCommentaire(rs.getInt(1));
            c.setContenu(rs.getString(2));
            c.setIdUser(rs.getInt(3)); 
            c.setIdProjet(rs.getInt(4));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CommentaireServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

  

      
      //UPDATE
    @Override
    public void UpdateCommentaire(int id, Commentaire c){
         try {
             String req ="UPDATE commentaires SET `Contenu`= ? WHERE idCommentaire = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, c.getContenu());
             ps.setInt(2, id);
             ps.setInt(3, c.getIdUser()); 
             ps.setInt(4, c.getIdProjet()); 
             ps.executeUpdate();
             System.out.println("contenu modifié avec succes"); 
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
    }
    
    //SUPPRIMER un Commentaire
    
      public void deleteCommentaireById(Commentaire c) {
         try {
             String req ="DELETE FROM `commentaires` WHERE idCommentaire = ?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, c.getIdCommentaire()); 
             ps.executeUpdate();
             System.out.println("Commentaire supprimé avec succes"); 
         } catch (SQLException ex) {
           ex.printStackTrace(); 
         }

      }
     
      //filtrer par description 
 
    @Override
      public List<Commentaire> filterByContenu(String Contenu) {
        List<Commentaire> CommentaireFiltres = new ArrayList<>() ;
        String req = "select * from cmmentaire where Contenu=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, Contenu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             Commentaire c = new Commentaire();
            c.setIdCommentaire(rs.getInt(1));
            c.setContenu(rs.getString(2));
            c.setIdUser(rs.getInt(3)); 
             c.setIdProjet(rs.getInt(4)); 
                CommentaireFiltres.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return CommentaireFiltres;
    }
      
 

 
    @Override
   public Commentaire getcommentairebyidUser(int idUser) {
      
      Commentaire c = new Commentaire(); 

         try {
             String req = "SELECT * FROM commentaires where idUser = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,idUser);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){        
              c.setIdCommentaire(rs.getInt(1));
              c.setContenu(rs.getString(2));
             c.setIdUser(rs.getInt(3));
             c.setIdProjet(rs.getInt(4));}
             
         } catch (SQLException ex) {
              ex.printStackTrace();
            
         
    }
         return c;
    }
 public List<Commentaire> filterByidUser(int idUser) {
        List<Commentaire> CommentaireFiltres = new ArrayList<>() ;
        String req = "select * from cmmentaire where idUser=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             Commentaire c = new Commentaire();
            c.setIdCommentaire(rs.getInt(1));
            c.setContenu(rs.getString(2));
             c.setIdUser(rs.getInt(3));
             c.setIdProjet(rs.getInt(4));
                CommentaireFiltres.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return CommentaireFiltres;
    }


 public List<Commentaire> filterByidProjet(int idProjet) {
        List<Commentaire> CommentaireFiltres = new ArrayList<>() ;
        String req = "select * from cmmentaire where idProjet=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idProjet);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             Commentaire c = new Commentaire();
            c.setIdCommentaire(rs.getInt(1));
            c.setContenu(rs.getString(2));
             c.setIdUser(rs.getInt(3));
             c.setIdProjet(rs.getInt(4));
                CommentaireFiltres.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return CommentaireFiltres;
    }
 
    
}


