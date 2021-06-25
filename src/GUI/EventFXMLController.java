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
import javafx.scene.control.SortEvent;
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
import javafx.scene.control.cell.PropertyValueFactory;
import services.EvtService;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Yassine 
 */
public class EventFXMLController implements Initializable {

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
    private TextField searchBar;
    @FXML
    private TableView<Event> eventTable;
    
    EvtService es = new EvtService();

    ObservableList<Event> eventlist = FXCollections.observableArrayList();
    
    Event event = new Event();
    
    User user = Statics.getCurrentUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbWelcome.setText("Welcome " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableEvent();
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
    private void search(ActionEvent event) {
//        String x = searchBar.getText();
//        userlist = (ObservableList<User>) us.SearchUser(Integer.parseInt(x));
//        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
//        phone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
//        role_col.setCellValueFactory(new PropertyValueFactory<>("role"));
//        UserTable.setItems(userlist);
    }

    @FXML
    private void Sort(ActionEvent event) {
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
    private void GoToSettings(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void AddEvent(ActionEvent event) {
    }
    
}
