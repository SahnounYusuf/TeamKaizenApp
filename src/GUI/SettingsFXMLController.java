/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class SettingsFXMLController implements Initializable {

    User user = Statics.getCurrentUser();

    @FXML
    private Label lbWelcome;
    @FXML
    private TableColumn<?, ?> id_col;
    @FXML
    private TableColumn<?, ?> nom_col;
    @FXML
    private TableColumn<?, ?> prenom_col;
    @FXML
    private TableColumn<?, ?> email_col;
    @FXML
    private TableColumn<?, ?> phone_col;
    @FXML
    private TableColumn<?, ?> role_col;
    @FXML
    private TableView<User> UserTable;

    UserServices us = new UserServices();

    ObservableList<User> userlist = FXCollections.observableArrayList();
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableUser();
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
    private void InitTableUser() {

        try {
            userlist = (ObservableList<User>) us.retriveAllUsersFroFX();
            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
            phone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
            role_col.setCellValueFactory(new PropertyValueFactory<>("role"));
            UserTable.setItems(userlist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void search(ActionEvent event) {
        String x = searchBar.getText();
        userlist = (ObservableList<User>) us.SearchUser(Integer.parseInt(x));
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        role_col.setCellValueFactory(new PropertyValueFactory<>("role"));
        UserTable.setItems(userlist);
    }

    @FXML
    private void Sort(ActionEvent event) {

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
    private void DeleteUser(ActionEvent event) {
        User u = UserTable.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            try {
                us.deleteUser(u.getId());
                InitTableUser();
            } catch (SQLException ex) {
                Logger.getLogger(SettingsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
