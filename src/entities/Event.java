/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Yassine
 */
public class Event {
    private int id;
    
    private String event_name;
    private String date;
    private String place;
    private String participants;

    public Event(int id, String event_name, String date, String place, String participants) {
        this.id = id;
        this.event_name = event_name;
        this.date = date;
        this.place = place;
        this.participants = participants;
    }

    public Event(String event_name, String date, String place, String participants) {
        this.event_name = event_name;
        this.date = date;
        this.place = place;
        this.participants = participants;
    }

    public Event() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "event{" + "id=" + id + ", event_name=" + event_name + ", date=" + date + ", place=" + place + ", participants=" + participants + '}';
    }
}
