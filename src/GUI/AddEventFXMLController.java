/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import entities.Event;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import services.EvtService;

import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class AddEventFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TextField tfEventName;
    @FXML
    private TextField tfEventPlace;
    @FXML
    private TextField tfEventDate;
    @FXML
    private DatePicker dpEventDate;
    User user = Statics.getCurrentUser();
    @FXML
    private HBox hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());

        System.out.println("the user is: " + user);

//        JFXTimePicker blueDatePicker = new JFXTimePicker();
//        blueDatePicker.setOverLay(true);
//        myPane.getChildren().add(blueDatePicker);
//        stackpane.getChildren().add(myPane);
//        StackPane.setMargin(myPane, new Insets(100));
//        stackpane.setStyle("-fx-background-color:WHITE");

        JFXTimePicker timePickerFX = new JFXTimePicker();

        timePickerFX.setEditable(false);
        timePickerFX.setPromptText("Earth Time");
        timePickerFX.setId("earth-time");
        hbox = new HBox(5, timePickerFX);

    }

    @FXML
    private void GoToInfo(MouseEvent event) {

        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AccountFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void GoToNewsFeed(ActionEvent event) {

        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void GoToDeleteEvent(ActionEvent event) {

        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEditEvent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EditEventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void GoToRent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToVelo(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToPiece(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./PieceFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEvent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void SignOut(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToSettings(ActionEvent event) {

        try {
            if (user.getRole().equals("user")) {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsUserFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            } else {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void AddEvent(ActionEvent event) {
        try {
            EvtService es = new EvtService();

            Event evt = new Event();

            evt.setEvent_name(tfEventName.getText());

            evt.setDate(tfEventDate.getText());

            evt.setDate(dpEventDate.getValue().toString());

            evt.setPlace(tfEventPlace.getText());

            es.addEvent(evt);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
