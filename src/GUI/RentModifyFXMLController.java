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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import services.RentService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class RentModifyFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<?> RentTable;
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
    private void InitTableRent() {
    }


    @FXML
    private void GoToAddRent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDeleteRent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentDeleteFXML.fxml"));
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
    
}
