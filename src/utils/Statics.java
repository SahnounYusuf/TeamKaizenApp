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
 * @author Sahnoun Yusuf
 */
public class Statics {
 
    public static User currentUser;
    public static Event selectedEvent;
    public static User newUser;
    public static int verificationCode;
    public static String ImagePath;

    public static String getImagePath() {
        return ImagePath;
    }

    public static void setImagePath(String ImagePath) {
        Statics.ImagePath = ImagePath;
    }

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

    public static void setSelectedEvent(Event selectedEvent) {
        Statics.selectedEvent = selectedEvent;
    }
}
