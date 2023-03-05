/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.VisiteGuideInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.GuideEntretien;
import utilities.MyConnection;
import models.VisiteGuide;
import models.Compte;

/**
 *
 * @author dell
 */
public class VisiteGuideService implements VisiteGuideInterface {
     Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addVisiteGuide(VisiteGuide v) {
       try {
            
            String req = "INSERT INTO `visitesguides`(`date`, `idCompte`, `idGuide`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, v.getDate_consultation());
            ps.setInt(2, v.getCompte().getIdCompte());
            ps.setInt(3, v.getGuideentretien().getIdguide());
            ps.executeUpdate();
            System.out.println("Visite Guide Entretien Ajouté avec succes!");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }

    @Override
    public List<VisiteGuide> fetchVisites() {
        List<VisiteGuide> visites = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM visitesguides";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                VisiteGuide v = new VisiteGuide();
                v.setIdVisiteGuide(rs.getInt(1));
                v.setDate_consultation(rs.getDate(2));
                String r1 = "SELECT * FROM comptes where idcompte = ? ";
                PreparedStatement p1 = cnx.prepareStatement(r1);
                p1.setInt(1, rs.getInt(3));
                ResultSet rs1 = p1.executeQuery();
                rs1.next();
                Compte c= new Compte();
                c.setIdCompte(rs1.getInt(1));
                c.setPhoto(rs1.getString(2));
               
                c.setDiplome(rs1.getString(3));
                c.setDateDiplome(rs1.getDate(4));
                c.setEntreprise(rs1.getString(5));
                c.setExperience(rs1.getString(6));
                v.setCompte(c);
                
                String r2 = "SELECT * FROM `guidesentretiens` WHERE idGuide = ? ";
                PreparedStatement p2 = cnx.prepareStatement(r2);
                p2.setInt(1, rs.getInt(4));
                ResultSet rs2 = p2.executeQuery();
                rs2.next();
                GuideEntretien ge= new GuideEntretien();
                ge.setIdguide(rs1.getInt(1));
                ge.setDomaine(rs1.getString(2));
                ge.setSpecialite(rs1.getString(3));
                ge.setSupport(rs1.getString(4));
                
                v.setGuideentretien(ge);
                
                visites.add(v);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return visites;
    }

    @Override
    public List<VisiteGuide> filterByCompte(int idCompte) {
       
          List<VisiteGuide> visiteFiltres = new ArrayList<>() ;
        String req = "select * from visitesguides where idCompte=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idCompte);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             VisiteGuide v = new VisiteGuide();
            v.setIdVisiteGuide(rs.getInt(1));
            v.setDate_consultation(rs.getDate(2));
              
                String r1 = "SELECT * FROM comptes where idcompte = ? ";
                PreparedStatement p1 = cnx.prepareStatement(r1);
                p1.setInt(1, rs.getInt(3));
                ResultSet rs1 = p1.executeQuery();
                rs1.next();
                Compte c= new Compte();
                c.setIdCompte(rs1.getInt(1));
                c.setPhoto(rs1.getString(2));
               
                c.setDiplome(rs1.getString(3));
                c.setDateDiplome(rs1.getDate(4));
                c.setEntreprise(rs1.getString(5));
                c.setExperience(rs1.getString(6));
                v.setCompte(c);
                
                String r2 = "SELECT * FROM `guidesentretiens` WHERE idGuide = ? ";
                PreparedStatement p2 = cnx.prepareStatement(r2);
                p2.setInt(1, rs.getInt(4));
                ResultSet rs2 = p2.executeQuery();
                rs2.next();
                GuideEntretien ge= new GuideEntretien();
                ge.setIdguide(rs1.getInt(1));
                ge.setDomaine(rs1.getString(2));
                ge.setSpecialite(rs1.getString(3));
                ge.setSupport(rs1.getString(4));
                
                v.setGuideentretien(ge);
                
                visiteFiltres.add(v);
               
                
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return visiteFiltres;

        
    }
}
