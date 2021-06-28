/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.DescriptionVelo;
import entities.UserLog;
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
public class ServiceDescription {

    private Connection cnx;

    public ServiceDescription() {
        cnx = MaConnection.getInstance().getCnx();

    }

    public void ajouterDescription(int idv, DescriptionVelo p) throws SQLException {

        String req = "INSERT INTO descriptionVelo (description, idv) VALUES "
                + "('" + p.getDescription() + "' , '" + idv + "');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);

    }

    public void modifierDescription(int idesc, DescriptionVelo p) throws SQLException {

        PreparedStatement pst = cnx.prepareStatement("UPDATE descriptionVelo SET description=? WHERE idesc= " + idesc);

        pst.setString(1, p.getDescription());
        pst.executeUpdate();
        System.out.println("Description modified!");

    }

    public boolean supprimerDescriptionVelo(int idesc) throws SQLException {

        String sql = "DELETE FROM descriptionVelo WHERE idv = " + idesc;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            return true;
        }

        return false;
    }

    public List<DescriptionVelo> afficherDescriptionVelo() throws SQLException {
        List<DescriptionVelo> descriptionVelos = new ArrayList<>();

        String sql = "SELECT id, idu , mark, model, price, descv.description as des  "
                + "FROM velo, descriptionvelo as descv WHERE velo.id = descv.idv";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            DescriptionVelo p = new DescriptionVelo();

            p.setId(rs.getInt("id"));
            p.setMark(rs.getString("mark"));
            p.setModel(rs.getString("model"));
            p.setPrice(rs.getFloat("price"));
            p.setDescription(rs.getString("des"));

            descriptionVelos.add(p);

        }

        return descriptionVelos;
    }
    
    public ObservableList<DescriptionVelo> retriveAllVeloFroFX() throws SQLException {
        ObservableList velos = FXCollections.observableArrayList();

        String sql = "SELECT id, idu , mark, model, price, descv.description as des  "
                + "FROM velo, descriptionvelo as descv WHERE velo.id = descv.idv";
        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            DescriptionVelo p = new DescriptionVelo();

            p.setId(rs.getInt("id"));
            p.setIdu(rs.getInt("idu"));
            p.setMark(rs.getString("mark"));
            p.setModel(rs.getString("model"));
            p.setPrice(rs.getFloat("price"));
            p.setDescription(rs.getString("des"));

            velos.add(p);
        }
        return velos;
    }

}
