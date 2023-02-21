/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.UtilisateurInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Role;
import models.Utilisateur;
import utilities.Maconnexion;

/**
 *
 * @author ezine
 */
public class UtilisateurService implements UtilisateurInterface {

    //var
    Connection cnx = Maconnexion.getInstance().getCnx();
    
    @Override
    public void addUser(Utilisateur u) {
        List <Utilisateur> users = this.fetchUsers();
        boolean existe= true;
        for (int i=0; i<users.size(); i++){
            if (u.getEmail().equalsIgnoreCase(users.get(i).getEmail())){
                existe=false;    
            }
        }
        if (existe==true){
          
       try {
            String req = "INSERT INTO `utilisateur` (`nom`, `prenom`, `email`, `tel`, `adresse`, `mdp`, `dateNaissance`, `idRole`,`salt`) VALUES (?,?,?,?,?,?,?,?,?)";
            String salt = Passwordutils.getSalt(20);
            String mySecurePassword = Passwordutils.generateSecurePassword(u.getMdp(), salt);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getTel());
            ps.setString(5, u.getAdresse());
            ps.setString(6, mySecurePassword);
            ps.setDate(7, u.getDateNaissance());
            ps.setInt(8, u.getRole().getIdRole());
            ps.setString(9, salt);
            ps.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } }
        else {
            System.out.println("L'utilisateur existe déjà !");
        }
    }
    

    @Override
    public List<Utilisateur> fetchUsers() {
       List<Utilisateur> users = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Utilisateur u = new Utilisateur();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setTel(rs.getString(5));
                u.setAdresse(rs.getString(6));
                u.setMdp(rs.getString(7));
                u.setDateNaissance(rs.getDate(8));
                String rq = "SELECT * FROM role where idRole = ? ";
                PreparedStatement ps = cnx.prepareStatement(rq);
                ps.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps.executeQuery();
                rs1.next();
                Role r = new Role();
                r.setIdRole(rs1.getInt(1));
                r.setDescription(rs1.getString(2));                
                u.setRole(r);
                
                users.add(u);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return users;
    }

    @Override
    public void updateUser(Utilisateur u, int id) {
    String req = "UPDATE utilisateur SET `nom`=?, `prenom`=?, `email`=?, `tel`=?, `adresse`=?, `mdp`=?, `dateNaissance`=?, `idRole`=? WHERE id=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, u.getNom());
        ps.setString(2, u.getPrenom());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getTel());
        ps.setString(5, u.getAdresse());
        ps.setString(6, u.getMdp());
        ps.setDate(7, u.getDateNaissance());  
        ps.setInt(8, u.getRole().getIdRole());
        ps.setInt(9, id);
        ps.executeUpdate();
        System.out.println("Utilisateur modifié avec succès !");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    

    @Override
    public void deleteUser(Utilisateur u) {
        try {
            String req = "DELETE FROM utilisateur WHERE id= ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, u.getId());
            st.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public Utilisateur GetByIdUser (int id) {
      
       Utilisateur u = new Utilisateur();
       

         try {
             String req = "SELECT * FROM utilisateur where id = ? ";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setTel(rs.getString(5));
                u.setAdresse(rs.getString(6));
                u.setMdp(rs.getString(7));
                u.setDateNaissance(rs.getDate(8));
                String rq = "SELECT * FROM role where idRole = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(rq);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                Role r = new Role();
                r.setIdRole(rs1.getInt(1));
                r.setDescription(rs1.getString(2));
                u.setRole(r);
                }
         } catch (SQLException ex) {
              ex.printStackTrace();
             
         }
         return u;
    }
    
    @Override
    public List<Utilisateur> filtrerByRole (int idR){
        List<Utilisateur> users = new ArrayList<>();
        Utilisateur u = new Utilisateur();
       String req = "SELECT * FROM utilisateur WHERE idRole = ? ";
        try {   
            
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setTel(rs.getString(5));
                u.setAdresse(rs.getString(6));
                u.setMdp(rs.getString(7));
                u.setDateNaissance(rs.getDate(8));
                String rq = "SELECT * FROM role WHERE idRole = ? ";
                PreparedStatement ps1 = cnx.prepareStatement(rq);
                ps1.setInt(1, rs.getInt(9));
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
               Role r= new Role();
               r.setIdRole(rs1.getInt(1));
               r.setDescription(rs1.getString(2)); 
               u.setRole(r);
               users.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
}

     




     