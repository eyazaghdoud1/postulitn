/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.CandidatureInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Candidature;
import utilities.EtatCandidature;
import utilities.MaConnexion;

/**
 *
 * @author HP I5
 */
public class CandidatureService implements CandidatureInterface {

    /* var */
    Connection cnx = MaConnexion.getInstance().getCnx();

    /* create candiature */
    
    @Override
    public void addCandidature(Candidature c) {
        List candidatures = this.fetchCandidatures();
        boolean existe=false;
        for (int i=0; i<candidatures.size(); i++) {
         if (c.getIdCandidat() == ((Candidature) candidatures.get(i)).getIdCandidat()
                && c.getIdOffre() == ((Candidature) candidatures.get(i)).getIdOffre())
         {
             existe = true;
             break;
         }
         }
        if (!existe) {
        String req = "INSERT INTO `candidatures`(`idCandidat`, `idOffre`, `cv`, `lettre`, `date`, `etat`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            //ps.setInt(1, c.getCandidat().getId());
            ps.setInt(1, c.getIdCandidat());
            //ps.setInt(1, c.getOffre().getId());
            ps.setInt(2, c.getIdOffre());
            ps.setString(3, c.getCv());
            ps.setString(4, c.getLettre());
            ps.setDate(5, c.getDate());
            ps.setString(6, EtatCandidature.EtatsCandidature.Enregistrée.toString());
            ps.executeUpdate();
            System.out.println("Candidature ajoutée avec succès.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        }
        else {
                System.out.println("Candidature existe déjà.");}
        
    }

    /* read candidatures */
    @Override
    public List<Candidature> fetchCandidatures() {
         List<Candidature> candidatures = new ArrayList<>() ;
         String req = "SELECT * FROM candidatures";
         try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                
                EtatCandidature.EtatsCandidature etat = EtatCandidature.EtatsCandidature.valueOf(rs.getString(7));
                Candidature c = new Candidature(rs.getInt(1),rs.getInt(2), rs.getInt(3), 
                 rs.getString(4), rs.getString(5), rs.getDate(6), etat);
                 
                candidatures.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return candidatures;
    
    }
    
    /* get by id */ 
    @Override
     public Candidature getCandidatureById(int idCandidature) {
       String req = "select * from candidatures where id = ?";
       Candidature cand = null ; 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCandidature);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                EtatCandidature.EtatsCandidature etat = EtatCandidature.EtatsCandidature.valueOf(rs.getString(7));
                cand = new Candidature(rs.getInt(1),rs.getInt(2), rs.getInt(3), 
                                                rs.getString(4), rs.getString(5), rs.getDate(6), etat);
              
            } else {
                System.out.println("Pas de candidature avec l'id {" + idCandidature + "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return cand;
   }


    /* update candidature */
    @Override
    public void updateCandidature(int idCandidature, Candidature c) {
        List<Candidature> candidatures = this.fetchCandidatures();
        boolean existe=false;
        for (int i=0; i<candidatures.size(); i++) {
         if (idCandidature == ((Candidature) candidatures.get(i)).getId())
           {
             existe = true;
             break;
            }
         }
        if (existe) {
         String req = "UPDATE `candidatures` SET `cv`=? ,`lettre`=?, `etat`=? WHERE id = ? ";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getCv());
            ps.setString(2, c.getLettre());
            ps.setString(3, c.getEtat().toString());
            ps.setInt(4, idCandidature);
            ps.executeUpdate();
            System.out.println("Candidature modifiée avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas de candidature avec l'id {" + idCandidature + "}.");
        }
    }
    
    /* delete candidature */
    @Override
    public void deleteCandidature(int idCandidature) {
     List candidatures = this.fetchCandidatures();
     boolean existe=false;
        for (int i=0; i<candidatures.size(); i++) {
         if (idCandidature == ((Candidature) candidatures.get(i)).getId())
           {
             existe = true;
             break;
            }
         }
        if (existe) {
         String req = "DELETE FROM `candidatures` WHERE id = ?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCandidature);
            ps.executeUpdate();
            System.out.println("Candidature surpprimée avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas de candidature avec l'id {" + idCandidature + "}.");
        }
     
    }

    @Override
    public List<Candidature> filterByCandidat(int idCandidat) {
         List<Candidature> candFiltrees = new ArrayList<>() ;
         String req = "select * from candidatures where idCandidat=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCandidat);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                EtatCandidature.EtatsCandidature etat = EtatCandidature.EtatsCandidature.valueOf(rs.getString(7));
                Candidature c = new Candidature(rs.getInt(1),rs.getInt(2), rs.getInt(3), 
                 rs.getString(4), rs.getString(5), rs.getDate(6), etat);
                candFiltrees.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return candFiltrees;
    }

    @Override
    public List<Candidature> filterByOffre(int idOffre) {
        List<Candidature> candFiltrees = new ArrayList<>() ;
        String req = "select * from candidatures where idOffre=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idOffre);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                EtatCandidature.EtatsCandidature etat = EtatCandidature.EtatsCandidature.valueOf(rs.getString(7));
                Candidature c = new Candidature(rs.getInt(1),rs.getInt(2), rs.getInt(3), 
                 rs.getString(4), rs.getString(5), rs.getDate(6), etat);
                candFiltrees.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return candFiltrees;
    }
    
    /* filtrer par état de candidature */ 
    @Override
     public List<Candidature> filterByEtat(EtatCandidature.EtatsCandidature etat) {
        List<Candidature> candFiltrees = new ArrayList<>() ;
        String req = "select * from candidatures where etat=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, etat.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                EtatCandidature.EtatsCandidature etatC = EtatCandidature.EtatsCandidature.valueOf(rs.getString(7));
                Candidature c = new Candidature(rs.getInt(1),rs.getInt(2), rs.getInt(3), 
                 rs.getString(4), rs.getString(5), rs.getDate(6), etatC);
                candFiltrees.add(c);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return candFiltrees;
    }
    /****************************************************************************************************************/ 
        public List<Candidature> filterListeByEtat(List<Candidature> l, EtatCandidature.EtatsCandidature etat) {
        List<Candidature> candFiltrees = new ArrayList<>() ;
        for (Candidature c: l){
         if(c.getEtat().compareTo(etat) == 0 ) {
          candFiltrees.add(c);
          }
        }
        return candFiltrees;
    }

    /* valider candidature */ 
    @Override
    public void valider(int idCandidature, boolean validee) {
        Candidature c = getCandidatureById(idCandidature);
        c.setId(idCandidature);
        if (validee==true) {
         
         c.setEtat(EtatCandidature.EtatsCandidature.Validée);
         this.updateCandidature(idCandidature, c);
            System.out.println("candidature validée");
        
        }
        else {
         c.setEtat(EtatCandidature.EtatsCandidature.NonValidée);  
        this.updateCandidature(idCandidature, c);
        System.out.println("candidature non validée");
        }
    }
   
  
}
