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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sahnoun Yusuf
 */
public class UserServices {

    private Connection cnx;

    public UserServices() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public boolean addUser(User u) {
        try {
            u.setRole("user");
            String req = "INSERT INTO user (id, nom, prenom, email, phone, password, role) VALUES "
                    + "('" + u.getId() + "', '" + u.getNom() + "', '" + u.getPrenom() + "', '" + u.getEmail()
                    + "', '" + u.getPhone() + "', '" + u.getPassword() + "', '" + u.getRole() + "');";

            Statement ste = cnx.createStatement();
            ste.executeUpdate(req);
            System.out.println("User added!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean modifyUser(int id, User u) {

        try {
            PreparedStatement pst = cnx.prepareStatement("UPDATE user SET nom=?, prenom=?, email=?, phone=?, password=? WHERE id= " + id);

            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setInt(4, u.getPhone());
            pst.setString(5, u.getPassword());
            pst.executeUpdate();
            System.out.println("User modified!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
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

    public ObservableList<User> retriveAllUsersFroFX() throws SQLException {
        ObservableList users = FXCollections.observableArrayList();

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

    public ObservableList<User> SearchUser(int id) {

        ObservableList list = FXCollections.observableArrayList();
        try {
            String requete = "Select * from user where id like '%" + id + "%' ;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int idU = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                String role = rs.getString("role");

                User c = new User(idU, nom, prenom, email, phone, role);
                list.add(c);
                System.out.println("Users on Search");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public boolean makeAdmin(int id, User u) {

        if (u.getRole().equals("SuperAdmin")) {
            return false;
        }

        try {
            PreparedStatement pst = cnx.prepareStatement("UPDATE user SET role=? WHERE id= " + id);
            u.setRole("admin");
            pst.setString(1, u.getRole());
            pst.executeUpdate();
            System.out.println("Admin created!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean makeUser(int id, User u) {

        if (u.getRole().equals("SuperAdmin")) {
            return false;
        }
        try {
            PreparedStatement pst = cnx.prepareStatement("UPDATE user SET role=? WHERE id= " + id);
            u.setRole("user");
            pst.setString(1, u.getRole());
            pst.executeUpdate();
            System.out.println("User modified!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public String retriveUserPasswordByEmail(String email) throws SQLException {
        String password = "";

        String sql = "SELECT password FROM user WHERE email = '" + email + "'";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            password = rs.getString("password");
        }
        return password;
    }
}
