/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Rent;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.RentService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class RentDeleteFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<Rent> RentTable;
    @FXML
    private TableColumn<?, ?> idv_col;
    @FXML
    private TableColumn<?, ?> idu_col;
    @FXML
    private TableColumn<?, ?> marque_col;
    @FXML
    private TableColumn<?, ?> model_col;
    @FXML
    private TableColumn<?, ?> prix_per_hour_col;
    @FXML
    private TableColumn<?, ?> date_disponibility;
    @FXML
    private TableColumn<?, ?> col_phone;

    User user = Statics.getCurrentUser();
    RentService rs = new RentService();
    ObservableList<Rent> rentlist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableRent();
    }

    @FXML
    private void OpenAccountInfo(MouseEvent event) {
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
    }

    @FXML
    private void InitTableRent() {
        try {
            rentlist = (ObservableList<Rent>) rs.retrieveAllRentFroFX();

            idv_col.setCellValueFactory(new PropertyValueFactory<>("idv"));
            idu_col.setCellValueFactory(new PropertyValueFactory<>("idu"));
            marque_col.setCellValueFactory(new PropertyValueFactory<>("marque"));
            model_col.setCellValueFactory(new PropertyValueFactory<>("model"));
            prix_per_hour_col.setCellValueFactory(new PropertyValueFactory<>("prix_per_hour"));
            date_disponibility.setCellValueFactory(new PropertyValueFactory<>("date_disponibility"));
            col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

            RentTable.setItems(rentlist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void DeleteRent(ActionEvent event) {
        Rent u = RentTable.getSelectionModel().getSelectedItem();
        RentService rs = new RentService();
        if (!u.equals(null)) {
            try {
                rs.supprimerRent(u.getIdv());
                InitTableRent();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    @FXML
    private void GoToPost(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEdit(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentModifyFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
