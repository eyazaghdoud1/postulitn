/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.OffreInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Offre;
import models.Typeoffre;
import utilities.MaConnexion;

/**
 *
 * @author Aziz Ben Guirat
 */
public class UserService {

    Connection cnx = MaConnexion.getInstance().getCnx();

    public String[] fetchMailUsers() {
        List<String> emails = new ArrayList<>();
        try {

            String req = "SELECT email FROM utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                emails.add(rs.getString("email"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] stringArray = emails.toArray(new String[0]);
        return stringArray;
    }

}
