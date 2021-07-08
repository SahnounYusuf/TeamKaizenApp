/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
import entities.UserLog;
import java.sql.Connection;
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
 * @author Sahnoun Yusuf
 */
public class LogService {

    private Connection cnx;

    public LogService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public boolean addUserLog(User u) {
        try {
            String req = "INSERT INTO log (idu, time) VALUES "
                    + "(" + u.getId()+ ", CURRENT_TIMESTAMP());";

            Statement ste = cnx.createStatement();
            ste.executeUpdate(req);
            System.out.println("UserLog added!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean deleteLog(int id) throws SQLException {

        String sql = "DELETE FROM log WHERE idl = " + id;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            System.out.println("UserLog Deleted!");
            return true;
        }
        return false;
    }

    public List<UserLog> retriveAllLogs() throws SQLException {
        List<UserLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM log";
        Statement ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();

            u.setId(rs.getInt("idl"));
            u.setIdu(rs.getInt("idu"));
            u.setDateLogged(rs.getString("time"));

            logs.add(u);
        }
        return logs;
    }

    public ObservableList<UserLog> retriveAllUserLogFroFX() throws SQLException {
        ObservableList logs = FXCollections.observableArrayList();

        String sql = "SELECT log.idl as log_id, nom, prenom, email, role, log.time as time_logged from log, user WHERE log.idu = user.id";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();
            
            u.setIdu(rs.getInt("log_id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            u.setDateLogged(rs.getString("time_logged"));

            logs.add(u);
        }
        return logs;
    }
    
    public ObservableList<UserLog> retriveAllUsersSortedFirstName() throws SQLException {
        ObservableList logs = FXCollections.observableArrayList();

        String sql = "SELECT log.idl as log_id, nom, prenom, email, role, log.time as time_logged from log, user WHERE log.idu = user.id ORDER BY user.prenom;";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();
            
            u.setIdu(rs.getInt("log_id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            u.setDateLogged(rs.getString("time_logged"));

            logs.add(u);
        }
        return logs;
    }
    
    public ObservableList<UserLog> retriveAllUsersSortedLastName() throws SQLException {
        ObservableList logs = FXCollections.observableArrayList();

        String sql = "SELECT log.idl as log_id, nom, prenom, email, role, log.time as time_logged from log, user WHERE log.idu = user.id ORDER BY user.nom;";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();
            
            u.setIdu(rs.getInt("log_id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            u.setDateLogged(rs.getString("time_logged"));

            logs.add(u);
        }
        return logs;
    }
    public ObservableList<UserLog> retriveAllUsersSortedRole() throws SQLException {
        ObservableList logs = FXCollections.observableArrayList();

        String sql = "SELECT log.idl as log_id, nom, prenom, email, role, log.time as time_logged from log, user WHERE log.idu = user.id ORDER BY user.role;";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();
            
            u.setIdu(rs.getInt("log_id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            u.setDateLogged(rs.getString("time_logged"));

            logs.add(u);
        }
        return logs;
    }
    public ObservableList<UserLog> retriveAllUsersSortedDate() throws SQLException {
        ObservableList logs = FXCollections.observableArrayList();

        String sql = "SELECT log.idl as log_id, nom, prenom, email, role, log.time as time_logged from log, user WHERE log.idu = user.id ORDER BY log.time DESC;";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {
            UserLog u = new UserLog();
            
            u.setIdu(rs.getInt("log_id"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setRole(rs.getString("role"));
            u.setDateLogged(rs.getString("time_logged"));

            logs.add(u);
        }
        return logs;
    }

}
