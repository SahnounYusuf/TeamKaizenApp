/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Event;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import services.EvtService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class EditEventFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    private TableColumn<?, ?> id_col;
    private TableColumn<?, ?> nom_col;
    private TableColumn<?, ?> date_col;
    private TableColumn<?, ?> place_col;
    private TableColumn<?, ?> participants_col;
    private TableView<Event> eventTable;

    EvtService es = new EvtService();

    ObservableList<Event> eventlist = FXCollections.observableArrayList();

    Event event = new Event();

    User user = Statics.getCurrentUser();
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<Event> listevents;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
//            InitTableEvent();

        try {
            eventlist = (ObservableList<Event>) es.retriveAllEventsFroFX();
            listevents.setItems(eventlist);
            listevents.setCellFactory(new Callback<ListView<Event>, ListCell<Event>>() {
                @Override
                public ListCell<Event> call(ListView<Event> listView) {
                    return new CustomListCell();
                }
            });

            // listevents.setItems(eventlist);
        } catch (SQLException ex) {
            Logger.getLogger(EditEventFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void SignOut(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private class CustomListCell extends ListCell<Event> {

        private HBox content;
        private Text name_event;
        private Text date;
        private Text place;
        private Text participants;

        public CustomListCell() {
            super();
            name_event = new Text();
            date = new Text();
            place = new Text();
            participants = new Text();
            HBox dateBox = new HBox(new Label("[Img here] "), date);
            VBox vBox = new VBox(name_event, dateBox, place, participants);
            content = new HBox(new Label("[Graphic]"), vBox);
            content.setSpacing(10);
        }

        @Override
        protected void updateItem(Event item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                name_event.setText(item.getEvent_name());
                date.setText(item.getDate());
                place.setText(item.getPlace());
                participants.setText(item.getParticipants());
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }

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
    private void search(ActionEvent event) {
    }

    @FXML
    private void Sort(ActionEvent event) {
    }

    

    @FXML
    private void GoToDetailsEvent(ActionEvent event) {
        Event e = listevents.getSelectionModel().getSelectedItem();
        //System.out.println(e);

        if (!e.equals(null)) {
            Statics.setSelectedEvent(e);
            //System.out.println(e);
            try {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./DetailsEventFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
