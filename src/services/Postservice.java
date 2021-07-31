/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import services.UserServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import entities.post;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.Statics;

/**
 *
 * @author Sahnoun Yusuf
 */
public class Postservice {

    private Connection cnx;

    public Postservice() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void addPost(post p) throws SQLException {
        String req = "INSERT INTO post (idp, idu, description, idl, postedby) VALUES "
                + "('" + p.getIdp() + "', '" + p.getIdu() + "', '" + p.getDescription() + "', '" + p.getidl() +"', '" + p.getPostedby()
                + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);
        System.out.println("post is added!");

    }

    public boolean modifypost(int idp, post p) {

        try {
            PreparedStatement pst = cnx.prepareStatement("UPDATE post SET  description=? WHERE idu= " + Statics.getCurrentUser() + "AND idp= " + idp);

            pst.setString(1, p.getDescription());
            pst.executeUpdate();
            System.out.println("Post is modified!");
            return true;
        } catch (SQLException ex) {
        }
        return false;
    }

    public boolean deletepost(int id) throws SQLException {

        String sql = "DELETE FROM post WHERE idp = " + id + "AND idu=" + Statics.getCurrentUser();

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            System.out.println("Post is Deleted!");
            return true;
        }

        return false;
    }

    public List<post> retriveallpost() throws SQLException {
        List<post> post = new ArrayList<>();

        String sql = "SELECT * FROM post";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            post p = new post();

            p.setIdp(rs.getInt("idp"));
            p.setIdu(rs.getInt("idu"));
            p.setDescription(rs.getString("description"));
            p.setidl(rs.getInt("likes"));
            p.setComment(rs.getString("comment"));

            post.add(p);

        }

        return post;
    }

    public post retrivepostById(int idp) throws SQLException {
        post post = null;

        String sql = "SELECT * FROM post WHERE idp = " + idp;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            post = new post();

            post.setIdp(rs.getInt("idp"));
            post.setIdu(rs.getInt("idu"));
            post.setDescription(rs.getString("description"));
            post.setidl(rs.getInt("likes"));
            post.setComment(rs.getString("comment"));

        }
        System.out.println("POST with ID: " + idp);
        return post;
    }

    public List<User> retriveallikes() throws SQLException {
        List<User> user = new ArrayList<>();

        String sql = "SELECT idl,idp,nom,prenom FROM likes,user,post WHERE likes.idl=post.idl AND likes.idu = user.id AND likes.idp=post.idp";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);
        int count = 0;
        while (rs.next()) {

            User p = new User();
            count = count + 1;
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
        }
        return user;
    }
    
    public ObservableList<post> retriveAllPostsFroFX() throws SQLException {
        ObservableList posts = FXCollections.observableArrayList();

        String sql = "SELECT * FROM post";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            post u = new post();

            u.setIdp(rs.getInt("idp"));
            u.setIdu(rs.getInt("idu"));
            u.setDescription(rs.getString("description"));
            u.setidl(rs.getInt("idl"));
            u.setComment(rs.getString("comments"));
            u.setPostedby(rs.getString("postedby"));

            posts.add(u);
        }
        return posts;
    }

}
