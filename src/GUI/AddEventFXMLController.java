/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Event;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.EvtService;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToInfo(MouseEvent event) {
    }

    @FXML
    private void GoToNewsFeed(ActionEvent event) {
    }

    @FXML
    private void GoToSettings(ActionEvent event) {
    }

    @FXML
    private void Signout(ActionEvent event) {
    }

    @FXML
    private void AddEvent(ActionEvent event) {
        try {
            EvtService es = new EvtService();
            
            Event evt = new Event();
            
            evt.setEvent_name(tfEventName.getText());
            evt.setDate(tfEventDate.getText());
            evt.setPlace(tfEventPlace.getText());
            
            es.addEvent(evt);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDeleteEvent(ActionEvent event) {
    }
    
}
