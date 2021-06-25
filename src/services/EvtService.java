/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
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
import entities.Event;

/**
 *
 * @author Yassine
 */
public class EvtService {
        private Connection cnx;

    public EvtService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    public void addEvent(Event p) throws SQLException {
        
        String req = "INSERT INTO event (event_name, date, place, participants) VALUES "
                + "('"+p.getEvent_name()+"', '"+p.getDate()+"', '"+p.getPlace()+"', '"+p.getParticipants()+"');";
        
        Statement ste = cnx.createStatement();
        
        ste.executeUpdate(req);

    }

    public void modifierEvent(User u) throws SQLException {

    }

    public boolean supprimerEvent(int id) throws SQLException{
        
        String sql = "DELETE FROM event WHERE id = " +id;
        
        Statement ste = cnx.createStatement();
                
        if (ste.executeUpdate(sql) == 1) {
            return true;
        }
        
        return false ;
    }

   public List<Event> afficherEvent() throws SQLException{
        List<Event> event = new ArrayList<>();
        
        String sql = "SELECT * FROM event";
        
        Statement ste = cnx.createStatement();
        
        ResultSet rs = ste.executeQuery(sql);
        
        while (rs.next()) {            
            
            Event p = new Event();
            
            p.setId(rs.getInt("id"));
            p.setEvent_name(rs.getString(2));
            p.setDate(rs.getString("Date"));
            p.setPlace(rs.getString("Place"));
            p.setParticipants(rs.getString("Participants"));
            
            event.add(p);
            
        }
        
        return event;
    }
   
   public Event afficherEventById(int id) throws SQLException{
        Event event = null;
        
        String sql = "SELECT * FROM event WHERE id = "+id;
        
        Statement ste = cnx.createStatement();
        
        ResultSet rs = ste.executeQuery(sql);
        
        while (rs.next()) {            
            
            Event p = new Event();
            
             p.setId(rs.getInt("id"));
            p.setEvent_name(rs.getString(2));
            p.setDate(rs.getString("Date"));
            p.setPlace(rs.getString("Place"));
            p.setParticipants(rs.getString("Participants"));
            
            
        }
        
        return event;
    }
}
