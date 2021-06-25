/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import utils.MaConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.Statics;

/**
 *
 * @author Sahnoun Yusuf
 */
public class LoginService {

    private Connection cnx;

    public LoginService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public boolean validate(int id, String password) throws SQLException {

        try {
            User user = null;
            String sql = "SELECT * FROM user WHERE id = " + id + " and password = '" + password + "'";

            Statement ste = cnx.createStatement();

            ResultSet rs = ste.executeQuery(sql);

            if (rs.next()) {
                while (rs.next()) {

                    user = new User();

                    user.setId(rs.getInt("id"));
                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString("prenom"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getInt("phone"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));

                }
                Statics.setCurrentUser(user);
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}