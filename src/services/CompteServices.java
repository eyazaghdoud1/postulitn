/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.CompteInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Compte;
import models.GuideEntretien;
import org.joda.time.DateTime;
import org.joda.time.Years;
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
        
        
        
//         try {
//        String req = "INSERT INTO `comptes`(`photo`, `cv`, `diplome`, `dateDiplome`, `entreprise`, `experience`) VALUES (?,?,?,?,?,?)";
//        PreparedStatement ps = cnx.prepareStatement(req);
//        ps.setString(1, c.getPhoto());
//        ps.setString(2, c.getCv());
//        ps.setString(3, c.getDiplome());
//        ps.setDate(4, c.getDateDiplome());
//        ps.setString(5, c.getEntreprise());
//        ps.setString(6, c.getExperience());
//        ps.executeUpdate();
//        
//        // Check if the diplome is expired
//        DateTime dateDiplome = new DateTime(c.getDateDiplome());
//        DateTime currentDate = new DateTime();
//        Years years = Years.yearsBetween(dateDiplome, currentDate);
//        if (years.getYears() >= 5) {
//            System.out.println("Compte ajouté avec succès! Diplôme expiré :(");
//        } else {
//            System.out.println("Compte ajouté avec succès!");
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
        
        
        
             try {
            
            String req = "INSERT INTO `comptes`(`photo`,`diplome`, `dateDiplome`, `entreprise`, `experience`,`domaine`,`poste`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getPhoto());
            ps.setString(3, c.getDiplome());
            ps.setDate(4, c.getDateDiplome());
            ps.setString(5, c.getEntreprise());
            ps.setString(6, c.getExperience());
            ps.setString(7, c.getDomaine());
            ps.setString(8, c.getPoste());
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
                c.setDiplome(rs.getString(3));
                c.setDateDiplome(rs.getDate(4));
                c.setEntreprise(rs.getString(5));
                c.setExperience(rs.getString(6));
                c.setDomaine(rs.getString(7));
                c.setPoste(rs.getString(8));
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
           
             c.setDiplome(rs.getString(3));
             c.setDateDiplome(rs.getDate(4));
             c.setEntreprise(rs.getString(5));
             c.setExperience(rs.getString(6));
             c.setDomaine(rs.getString(7));
             c.setPoste(rs.getString(8));
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
     String req = "UPDATE `comptes` SET `photo`=?,`diplome`=?,`dateDiplome`=?,`entreprise`=?,`experience`=?,`domaine`=?,`poste`=? WHERE idcompte=?";
         try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getPhoto());
          
            ps.setString(3, c.getDiplome());
            ps.setDate(4, c.getDateDiplome());
             ps.setString(5, c.getEntreprise());
        ps.setString(6, c.getExperience());
        ps.setString(7, c.getDomaine());
        ps.setString(8, c.getPoste());
        ps.setInt(9, idCompte);
        ps.executeUpdate();
        System.out.println("Compte modifié avec succès.");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
//            ps.setString(5, c.getEntreprise());
//            ps.setString(7, c.getExperience());
//            ps.setString(7, c.getDomaine());
//            ps.setString(8, c.getPoste());
//            ps.setInt(9, idCompte);
//            ps.executeUpdate();
//            System.out.println("Compte modifié avec succès.");
//            
//         } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//         }
    }
    
    
    
    
    
   public String readCV(String filePath) throws IOException {
    File file = new File(filePath);
    BufferedReader reader = new BufferedReader(new FileReader(file));

    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        sb.append(line);
    }

    reader.close();

    return sb.toString();
}


   
    
    
}
