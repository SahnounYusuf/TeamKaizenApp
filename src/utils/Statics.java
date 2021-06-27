/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Event;
import entities.User;

/**
 *
 * @author fakhreddine
 */
public class Statics {
 
    public static User currentUser;
    public static Event selectedEvent;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Statics.currentUser = currentUser;
    }

    public static Event getSelectedEvent() {
        return selectedEvent;
    }

    public static void setSelectedEvent(Event selectedEvent) {
        Statics.selectedEvent = selectedEvent;
    }
}
