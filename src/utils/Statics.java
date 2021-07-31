/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Event;
import entities.User;
import entities.Velo;

/**
 *
 * @author Sahnoun Yusuf
 */
public class Statics {
 
    public static User currentUser;
    public static Event selectedEvent;
    public static User newUser;
    public static int verificationCode;
    public static Velo selectedVelo;


    public static User getNewUser() {
        return newUser;
    }

    public static void setNewUser(User newUser) {
        Statics.newUser = newUser;
    }

    public static int getVerificationCode() {
        return verificationCode;
    }

    public static void setVerificationCode(int verificationCode) {
        Statics.verificationCode = verificationCode;
    }
    

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Statics.currentUser = currentUser;
    }

    public static Event getSelectedEvent() {
        return selectedEvent;
    }
    public static Velo getSelectedVelo() {
        return selectedVelo;
    }

    public static void setSelectedEvent(Event selectedEvent) {
        Statics.selectedEvent = selectedEvent;
    }
    public static void setSelectedVelo(Velo selectedVelo) {
        Statics.selectedVelo = selectedVelo;
    }
}
