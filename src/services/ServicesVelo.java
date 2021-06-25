/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Event;
import entities.Velo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection;

/**
 *
 * @author Mohamed
 */
public class ServicesVelo {

    private Connection cnx;

    public ServicesVelo() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void ajouterVelo(Velo p) throws SQLException {

        String req = "INSERT INTO velo (mark, model,description, price) VALUES "
                + "('" + p.getMark() + "', '" + p.getModel() + "', '" + p.getDescription() + "', '" + p.getPrice() + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);

    }

//    public void ajouterVelo1(Velo p) throws SQLException{
//        
//        String sql = "INSERT INTO velo (mark, model,description, price) VALUES (?,?,?,?);";
//        
//        PreparedStatement pre = cnx.prepareStatement(sql);
//        
//        pre.setString(1, p.getMark());
//        pre.setString(2, p.getModel());
//        pre.setString(3, p.getDescription());
//        pre.setFloat(4, p.getPrice());
//
//        
//        pre.executeUpdate();
//        System.out.println("INSERTION OK!!");
//    }
    public void modifierVelo(int id,Velo p) throws SQLException {
        String requete = "UPDATE velo SET  mark=?, model=?, description=?, price=? WHERE id=?";
        PreparedStatement pst = cnx.prepareStatement("UPDATE velo SET  mark=?, model=?, description=?, price=? WHERE id= "+id);
       
        pst.setString(1, p.getMark());
        pst.setString(2, p.getModel());
        pst.setString(3, p.getDescription());
        pst.setFloat(4, p.getPrice());
        pst.executeUpdate();
        System.out.println("Velo modified!");

    }

    public boolean supprimerVelo(int id) throws SQLException {

        String sql = "DELETE FROM velo WHERE id = " + id;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            return true;
        }

        return false;
    }

    public List<Velo> afficherVelo() throws SQLException {
        List<Velo> velos = new ArrayList<>();

        String sql = "SELECT * FROM velo";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Velo p = new Velo();

            p.setId(rs.getInt("id"));
            p.setMark(rs.getString(2));
            p.setModel(rs.getString("model"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getFloat("price"));

            velos.add(p);

        }

        return velos;
    }
    


    public Velo afficherVeloById(int id) throws SQLException {
        Velo velo = null;

        String sql = "SELECT * FROM velo WHERE id = " + id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            velo = new Velo();

            velo.setId(rs.getInt("id"));
            velo.setMark(rs.getString(2));
            velo.setModel(rs.getString("model"));
            velo.setDescription(rs.getString("description"));
            velo.setPrice(rs.getFloat("price"));

        }

        return velo;
    }
    
    public ObservableList<Velo> retrieveAllVeloFroFX() throws SQLException {
        ObservableList velos = FXCollections.observableArrayList();

        String sql = "SELECT * FROM velo";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Velo v = new Velo();

            v.setId(rs.getInt("id"));
            v.setMark(rs.getString(2));
            v.setModel(rs.getString("model"));
            v.setDescription(rs.getString("description"));
            v.setPrice(rs.getFloat("price"));

            velos.add(v);

        }

        return velos;
    }
}
