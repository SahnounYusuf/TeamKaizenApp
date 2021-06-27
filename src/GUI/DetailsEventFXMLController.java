/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import services.EvtService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class DetailsEventFXMLController implements Initializable {

    @FXML
    private TextField tfEvent_name;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfPlace;

    Event e = Statics.getSelectedEvent();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfEvent_name.setText(e.getEvent_name());
        tfDate.setText(e.getDate());
        tfPlace.setText(e.getPlace());
    }

    @FXML
    private void ConfrimClicked(ActionEvent event) {
        System.out.println(e.getId() + " " + e.getEvent_name());
        Event e1 = new Event();
        e1.setDate(tfDate.getText());
        e1.setEvent_name(tfEvent_name.getText());
        e1.setPlace(tfPlace.getText());
        e1.setParticipants(e.getParticipants());
        Window owner = tfDate.getScene().getWindow();
        try {
            EvtService es = new EvtService();
            es.modifierEvent(e.getId(), e1);
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Event Modified.");
        } catch (SQLException ex) {
            System.out.println(e);
        }
    }

    @FXML
    private void BackClicked(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EditEventFXML.fxml"));
            Parent parent = root.load();
            tfDate.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
