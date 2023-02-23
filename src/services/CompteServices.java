/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.CompteInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Compte;
import models.GuideEntretien;
import utilities.MyConnection;

/**
 *
 * @author dell
 */
public class CompteServices implements CompteInterface {
    //var
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addCompte(Compte c) {
             try {
            
            String req = "INSERT INTO `comptes`(`photo`, `cv`, `diplome`, `dateDiplome`, `entreprise`, `experience`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getPhoto());
            ps.setString(2, c.getCv());
            ps.setString(3, c.getDiplome());
            ps.setDate(4, c.getDateDiplome());
            ps.setString(5, c.getEntreprise());
            ps.setString(6, c.getExperience());
            ps.executeUpdate();
            System.out.println("Compte Ajouté avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Compte> fetchComptes() {
        List<Compte> comptes = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM comptes";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Compte c = new Compte();
                c.setIdCompte(rs.getInt(1));
                c.setPhoto(rs.getString(2));
                c.setCv(rs.getString(3));
                c.setDiplome(rs.getString(4));
                c.setDateDiplome(rs.getDate(5));
                c.setEntreprise(rs.getString(6));
                c.setExperience(rs.getString(7));
                comptes.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return comptes;
    }


    @Override
    public void deleteCompte(Compte c) {
        try {
            String req = "DELETE FROM comptes WHERE idcompte = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, c.getIdCompte());
            st.executeUpdate();
            System.out.println("Compte supprimé avec succes!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Compte GetByIdCompte(int id) {
      Compte c = new Compte();

         try {
             String req = "SELECT * FROM comptes where idcompte = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
             if (rs.next()){
             c.setIdCompte(rs.getInt(1));
             c.setPhoto(rs.getString(2));
             c.setCv(rs.getString(3));
             c.setDiplome(rs.getString(4));
             c.setDateDiplome(rs.getDate(5));
             c.setEntreprise(rs.getString(6));
             c.setExperience(rs.getString(7));
             }
            
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return c;
}
    
//    @Override
//    public void updateCompte(Compte c) {
//        try {
//            String req ="UPDATE `compte` SET `compte`= ? WHERE idcompte = ?";
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setInt(2, c.getIdCompte());
//            ps.executeUpdate();
//            System.out.println("Compte updated successfully!");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }    }

    @Override
    public void updateCompte(int idCompte, Compte c) {
     String req = "UPDATE `comptes` SET `photo`=?,`cv`=?,`diplome`=?,`dateDiplome`=?,`entreprise`=?,`experience`=? WHERE idcompte=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getPhoto());
            ps.setString(2, c.getCv());
            ps.setString(3, c.getDiplome());
            ps.setDate(4, c.getDateDiplome());
            ps.setString(5, c.getEntreprise());
            ps.setString(6, c.getExperience());
            ps.setInt(7, idCompte);
            ps.executeUpdate();
            System.out.println("Compte modifié avec succès.");
            
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }
    
    
    
}
