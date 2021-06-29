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

    public void modifierEvent(int id,Event u) throws SQLException {
        try {
            PreparedStatement pst = cnx.prepareStatement("UPDATE event SET event_name=?, Date=?, place=? WHERE id= " + id);

            pst.setString(1, u.getEvent_name());
            pst.setString(2, u.getDate());
            pst.setString(3, u.getPlace());
            
            pst.executeUpdate();
            System.out.println("User modified!");
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

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
   
   public ObservableList<Event> retriveAllEventsFroFX() throws SQLException {
        ObservableList events = FXCollections.observableArrayList();

        String sql = "SELECT * FROM event";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Event u = new Event();

            u.setId(rs.getInt("id"));
            u.setEvent_name(rs.getString(2));
            u.setDate(rs.getString("date"));
            u.setPlace(rs.getString("place"));
            u.setParticipants(rs.getString("participants"));

            events.add(u);

        }

        return events;
    }

    public Event retriveUserById(int id) throws SQLException {
        Event u = null;

        String sql = "SELECT * FROM event WHERE id = " + id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            u = new Event();

            u.setId(rs.getInt("id"));
            u.setEvent_name(rs.getString(2));
            u.setDate(rs.getString("date"));
            u.setPlace(rs.getString("place"));
            u.setParticipants(rs.getString("participants"));

        }
        System.out.println("event with ID: " + id);
        return u;
    }
    
    public ObservableList<Event> SearchEvent(int id) {

        ObservableList list = FXCollections.observableArrayList();
        try {
            String requete = "Select * from event where id like '%" + id + "%' ;";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int idU = rs.getInt("id");
                String event_name = rs.getString("event_name");
                String date = rs.getString("date");
                String place = rs.getString("place");
                String participant = rs.getString("participant");

                Event c = new Event(idU, event_name, date, place, participant);
                list.add(c);
                System.out.println("Event on Search");
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
}
