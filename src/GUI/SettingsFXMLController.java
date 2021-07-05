/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginFXMLController.infoBox;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
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

    @FXML
    private void MakeAdmin(ActionEvent event) {
        User u = UserTable.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            boolean flag = us.makeAdmin(u.getId(), u);
            InitTableUser();
            if (!flag) {
                infoBox("Operation can't be made!", null, "Failed");
            }
        }
    }

    @FXML
    private void MakeUser(ActionEvent event) {

        User u = UserTable.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            boolean flag = us.makeUser(u.getId(), u);
            InitTableUser();
            if (!flag) {
                infoBox("Operation can't be made!", null, "Failed");
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
    private void GoToLog(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LogSettingsFXML.fxml"));
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
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AddEventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
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
    private void SignOut(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
