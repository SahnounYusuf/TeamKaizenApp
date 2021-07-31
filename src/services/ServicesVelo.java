/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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

        String req = "INSERT INTO velo (id, idu, brand, model, type, size, wheelsize, brakingtype, numberofspeed, quantity, color, price, weight, description) VALUES "
                + "('"+ p.getId()+ "', '" + p.getIdu()+ "', '"+ p.getBrand() + "', '" + p.getModel() + "', '" + p.getType() + "', '" + p.getSize() + "', '" + p.getWheelSize() + "', '" + p.getBrakingType() + "', '" + p.getNumberOfSpeed() + "', '" + p.getQuantity() + "', '" + p.getColor() + "', '" + p.getPrice() + "', '" + p.getWeight() + "', '" + p.getDescription() +"');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);

    }
    public void ajouterVelo2(Velo p) throws SQLException {

        String req = "INSERT INTO velo ( brand, model, type, size, wheelsize, brakingtype, numberofspeed, quantity, color, price, weight, description)  VALUES "
                + "( '"+ p.getBrand() + "', '" + p.getModel() + "', '" + p.getType() + "', '" + p.getSize() + "', '" + p.getWheelSize() + "', '" + p.getBrakingType() + "', '" + p.getNumberOfSpeed() + "', '" + p.getQuantity() + "', '" + p.getColor() + "', '" + p.getPrice() + "', '" + p.getWeight() + "', '" + p.getDescription() +"');";

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
        public void modifierVelo(int id, Velo p) throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("UPDATE velo SET  brand=?, model=?, type=?, size=?, wheelsize=?, brakingtype=?, numberofspeed=?, quantity=?, color=?, price=?, weight=?, description=? WHERE id= " + id);

        pst.setString(1, p.getBrand());
        pst.setString(2, p.getModel());
        pst.setString(3, p.getType());
        pst.setFloat(4, p.getPrice());
        pst.setFloat(5, p.getWheelSize());
        pst.setString(6, p.getBrakingType());
        pst.setInt(7, p.getNumberOfSpeed());
        pst.setFloat(8, p.getQuantity());
        pst.setString(9, p.getColor());
        pst.setFloat(10, p.getPrice());
        pst.setFloat(11, p.getWeight());
        pst.setString(12, p.getDescription());
        

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
        p.setBrand(rs.getString(2));
        p.setModel(rs.getString("model"));
        p.setType(rs.getString("type"));
        p.setSize(rs.getString("size"));
        p.setWheelSize(rs.getFloat("wheelsize"));
        p.setBrakingType(rs.getString("brakingtype"));
        p.setNumberOfSpeed(rs.getInt("numberofspeed"));
        p.setQuantity(rs.getInt("quantity"));
        p.setColor(rs.getString("color"));
        p.setPrice(rs.getFloat("price"));
        p.setWeight(rs.getFloat("weight"));
        p.setDescription(rs.getString("description"));
        
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
        velo.setBrand(rs.getString(2));
        velo.setModel(rs.getString("model"));
        velo.setType(rs.getString("type"));
        velo.setSize(rs.getString("size"));
        velo.setWheelSize(rs.getFloat("wheelsize"));
        velo.setBrakingType(rs.getString("brakingtype"));
        velo.setNumberOfSpeed(rs.getInt("numberofspeed"));
        velo.setQuantity(rs.getInt("quantity"));
        velo.setColor(rs.getString("color"));
        velo.setPrice(rs.getFloat("price"));
        velo.setWeight(rs.getFloat("weight"));
        velo.setDescription(rs.getString("description"));
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
        v.setIdu(rs.getInt("idu"));
        v.setBrand(rs.getString("brand"));
        v.setModel(rs.getString("model"));
        v.setType(rs.getString("type"));
        v.setSize(rs.getString("size"));
        v.setWheelSize(rs.getFloat("wheelsize"));
        v.setBrakingType(rs.getString("brakingtype"));
        v.setNumberOfSpeed(rs.getInt("numberofspeed"));
        v.setQuantity(rs.getInt("quantity"));
        v.setColor(rs.getString("color"));
        v.setPrice(rs.getFloat("price"));
        v.setWeight(rs.getFloat("weight"));
        v.setDescription(rs.getString("description"));

            velos.add(v);

        }
        return velos;
    }
}
