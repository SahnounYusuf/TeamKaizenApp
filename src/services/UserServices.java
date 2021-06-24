/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import entities.User;

/**
 *
 * @author Sahnoun Yusuf
 */
public class UserServices {

    private Connection cnx;

    public UserServices() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void addUser(User u) throws SQLException {

        String req = "INSERT INTO user (id, nom, prenom, email, phone, password, role) VALUES "
                + "('" + u.getId() + "', '" + u.getNom() + "', '" + u.getPrenom() + "', '" + u.getEmail()
                + "', '" + u.getPhone() + "', '" + u.getPassword() + "', '" + u.getRole() + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);
        System.out.println("User added!");

    }

    public void modifyUser(User u) throws SQLException {

        String requete = "UPDATE user SET nom=?, prenom=?, email=?, phone=?, password=?, role=? WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement(requete);
        pst.setInt(1, u.getId());
        pst.setString(2, u.getNom());
        pst.setString(3, u.getPrenom());
        pst.setString(4, u.getEmail());
        pst.setInt(5, u.getPhone());
        pst.setString(6, u.getPassword());
        pst.setString(7, u.getRole());
        pst.executeUpdate();
        System.out.println("User modified!");

    }

    public boolean deleteUser(int id) throws SQLException {

        String sql = "DELETE FROM user WHERE id = " + id;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            System.out.println("User Deleted!");
            return true;
        }

        return false;
    }

    public List<User> retriveAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            User u = new User();

            u.setId(rs.getInt("id"));
            u.setNom(rs.getString(2));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setPhone(rs.getInt("phone"));
            u.setPassword(rs.getString("password"));
            u.setRole(rs.getString("role"));

            users.add(u);

        }

        return users;
    }

    public User retriveUserById(int id) throws SQLException {
        User user = null;

        String sql = "SELECT * FROM user WHERE id = " + id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

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
        System.out.println("User with ID: " + id);
        return user;
    }

}
