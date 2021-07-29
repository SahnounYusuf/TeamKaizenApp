/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entities.Event;
import entities.User;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.EvtService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class DeleteEventFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableColumn<?, ?> id_col;
    @FXML
    private TableColumn<?, ?> nom_col;
    @FXML
    private TableColumn<?, ?> date_col;
    @FXML
    private TableColumn<?, ?> place_col;
    @FXML
    private TableColumn<?, ?> participants_col;
    @FXML
    private TableView<Event> eventTable;

    EvtService es = new EvtService();

    ObservableList<Event> eventlist = FXCollections.observableArrayList();

    Event event = new Event();

    User user = Statics.getCurrentUser();
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableEvent();
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
    private void Signout(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void InitTableEvent() {
        try {
            eventlist = (ObservableList<Event>) es.retriveAllEventsFroFX();
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom_col.setCellValueFactory(new PropertyValueFactory<>("event_name"));
            date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
            place_col.setCellValueFactory(new PropertyValueFactory<>("place"));
            participants_col.setCellValueFactory(new PropertyValueFactory<>("participants"));

            eventTable.setItems(eventlist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void Sort(ActionEvent event) {
    }

    @FXML
    private void GoToAddEvent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AddEventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void DelEvent(ActionEvent event) {
        Window owner = lbWelcome.getScene().getWindow();
        Event e = eventTable.getSelectionModel().getSelectedItem();
        if (!e.equals(null)) {
            try {
                es.supprimerEvent(e.getId());
                showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Event deleted.");
                InitTableEvent();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
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
}
