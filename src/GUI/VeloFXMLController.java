/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utils.Statics;
import entities.Velo;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import services.ServicesVelo;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class VeloFXMLController implements Initializable {
    
    User user = Statics.getCurrentUser();
    
    ServicesVelo sv = new ServicesVelo();

    ObservableList<Velo> velolist = FXCollections.observableArrayList();

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<Velo> bicycleTable;
    @FXML
    private TableColumn<?, ?> id_col;
    @FXML
    private TableColumn<?, ?> mark_col;
    @FXML
    private TableColumn<?, ?> model_col;
    @FXML
    private TableColumn<?, ?> desc_col;
    @FXML
    private TableColumn<?, ?> price_col;
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
        InitTableBicycle();
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
    private void GoToEvents(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
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
    private void InitTableBicycle() {
        try {
            velolist = (ObservableList<Velo>) sv.retrieveAllVeloFroFX();
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            mark_col.setCellValueFactory(new PropertyValueFactory<>("mark"));
            model_col.setCellValueFactory(new PropertyValueFactory<>("model"));
            desc_col.setCellValueFactory(new PropertyValueFactory<>("description"));
            price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
            
            bicycleTable.setItems(velolist);

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
    private void GoToInfo(KeyEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AccountFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
