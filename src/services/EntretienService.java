/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.EntretienInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Candidature;
import models.Entretien;
import utilities.EtatCandidature;
import utilities.MaConnexion;
import utilities.TypeEntretien;

/**
 *
 * @author HP I5
 */
public class EntretienService implements EntretienInterface {
    
    Connection cnx = MaConnexion.getInstance().getCnx();
    CandidatureService cs = new CandidatureService();

    @Override
    public void addEntretien(Entretien e) {
        /* tester si l'entretien existe déjà en se basant sur l'idCandidature et type de l'entretien */
        boolean existe = false; 
        String r = "select * from entretiens where idCandidature = ? and type = ?";
        PreparedStatement p;
        try {
            p = cnx.prepareStatement(r);
            p.setInt(1, e.getCandidature().getId());
            p.setString(2, e.getType());
            ResultSet res = p.executeQuery();
            if (res.next()) { existe = true;}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       /* ajout */ 
        if (existe==false) {
        String req = "INSERT INTO `entretiens`(`type`, `date`, `heure`, `lieu`, `idCandidature`, `idGuide`) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, e.getType());
            ps.setDate(2, e.getDate());
            ps.setString(3, e.getHeure());
            ps.setString(4, e.getLieu());
            ps.setInt(5, e.getCandidatureId());
            if (e.getType().equals(TypeEntretien.TypeE.Téléphone.toString())) {
              cs.getCandidatureById(e.getCandidatureId()).setEtat(EtatCandidature.EtatsCandidature.EntretienTel);
            } else {
                cs.getCandidatureById(e.getCandidatureId()).setEtat(EtatCandidature.EtatsCandidature.EntretienPres);
            }
            ps.setInt(6, e.getGuideId());
            ps.executeUpdate();
            System.out.println("Entretien ajouté avec succès.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        }
        else {
          System.out.println("Cet entretien est déjà enregistré.");
        }
        }

    @Override
    public List<Entretien> fetchEntretiens() {
        List<Entretien> entretiens = new ArrayList<>() ;
        String req = "SELECT * FROM entretiens";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                
                entretiens.add(e);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entretiens;
    }

    @Override
    public Entretien getEntretienById(int idEntretien) {
       String req = "select * from entretiens where id = ?";
       Entretien e = null ; 
       try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idEntretien);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6)));
                e.setGuideId(rs.getInt(7));
                System.out.println("Entretien trouvé: " + e);
            } else {
                System.out.println("Pas d'entretien avec l'id {" + idEntretien+  "}.");
             }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return e;
    }

    @Override
    public void deleteEntretien(int idEntretien) { 
        List entretiens = this.fetchEntretiens();
        boolean existe=false;
        for (int i=0; i<entretiens.size(); i++) {
         if (idEntretien == ((Entretien) entretiens.get(i)).getId())
           {
             existe = true;
             break;
            }
         }
        if (existe) {
         String req = "DELETE FROM `entretiens` WHERE id = ?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idEntretien);
            ps.executeUpdate();
            System.out.println("Entretien surpprimé avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas d'entretien avec l'id {" + idEntretien + "}.");
        }
    }

    @Override
    public void updateEntretien(int idEntretien, Entretien e) {
        List<Entretien> entretiens = this.fetchEntretiens();
        boolean existe=false;
        for (int i=0; i<entretiens.size(); i++) {
         if (idEntretien == ( entretiens.get(i)).getId())
           {
             existe = true;
             break;
            }
         }
        if (existe == true) {
         String req = "UPDATE `entretiens` SET `date`=?,`heure`=?,`lieu`=?,`idCandidature`=?,`idGuide`=? WHERE id = ?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, e.getDate());
            ps.setString(2,e.getHeure());
            ps.setString(3, e.getLieu());
            ps.setInt(4, e.getCandidatureId());
            ps.setInt(5, e.getGuideId());
            ps.setInt(6, idEntretien);
            ps.executeUpdate();
            System.out.println("Entretien modifié avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
        } else {
           System.out.println("Pas d'entretien avec l'id {" + idEntretien + "}.");
        }
    }

    @Override
    public List<Entretien> filterByDate(Date date) {
         List<Entretien> entFiltres = new ArrayList<>() ;
         String req = "select * from entretiens where date=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                entFiltres.add(e);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;

    }

    /* filter by candidat */
    @Override
    public List<Entretien> filterByCandidat(int idCandidat) {
        /* liste des candidatures relatives au candidat */
        List<Candidature> cand = cs.filterByCandidat(idCandidat); 
        System.out.println("Candidat id: { " + idCandidat + "}." );
        /* liste des id des candidatures relatifs au candidat */
        List<Integer> candId = new ArrayList<>();
        for (int i=0; i<cand.size() ; i++ ) {
         candId.add(cand.get(i).getId());
       }
       /* liste des entretiens relatifs au candidat */
        List<Entretien> entFiltres = new ArrayList<>() ;
        String req = "select * from entretiens where idCandidature = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            for (int i=0; i<candId.size(); i++) {
            ps.setInt(1, i);
            /* creation de la liste des entretiens par candidature */
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                entFiltres.add(e);
            }     
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;    

    }

    /* filter by offre */ 
    @Override
    public List<Entretien> filterByOffre(int idOffre) {
        /* liste des candidatures relatives à l'offre */
        List<Candidature> cand = cs.filterByOffre(idOffre); 
        System.out.println("Offre id: { " + idOffre + "}." );
        /* liste des id des candidatures relatifs à l'offre */
        List<Integer> candId = new ArrayList<>();
        for (int i=0; i<cand.size() ; i++ ) {
         candId.add(cand.get(i).getId());
       }
       /* liste des entretiens relatifs à l'offre */
        List<Entretien> entFiltres = new ArrayList<>() ;
        String req = "select * from entretiens where idCandidature = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            for (int i=0; i<candId.size(); i++) {
            ps.setInt(1, i);
            /* creation de la liste des entretiens par candidature */
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                entFiltres.add(e);
            }     
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;    
    }

    /* filter by candidature */ 
    @Override
    public List<Entretien> filterByCandidature(int idCandidature) {
        List<Entretien> entFiltres = new ArrayList<>() ;
        String req = "select * from entretiens where idCandidature = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCandidature);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                entFiltres.add(e);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;    
    }

    @Override
    public List<Entretien> filterByType(String type) {
        List<Entretien> entFiltres = new ArrayList<>() ;
        String req = "select * from entretiens where type = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entretien e = new Entretien();
                e.setId(rs.getInt(1));
                e.setType(rs.getString(2));
                e.setDate(rs.getDate(3));
                e.setHeure(rs.getString(4));
                e.setLieu(rs.getString(5));
                e.setCandidature(cs.getCandidatureById(rs.getInt(6))); 
                e.setGuideId(rs.getInt(7));
                entFiltres.add(e);
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return entFiltres;    
    }

    @Override
    public void accepter(int idCandidature, boolean res) {
        Candidature c = cs.getCandidatureById(idCandidature);
        c.setId(idCandidature);
        if (res==true) {
         
         c.setEtat(EtatCandidature.EtatsCandidature.Acceptée);
         cs.updateCandidature(idCandidature, c);
        
        }
        else {
         c.setEtat(EtatCandidature.EtatsCandidature.Refusée);  
         cs.updateCandidature(idCandidature, c);
        }
        
    }
}

