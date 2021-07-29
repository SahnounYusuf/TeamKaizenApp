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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class VeloModifyFXMLController implements Initializable {

    User user = Statics.getCurrentUser();

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void GoToNewsFeed(ActionEvent event) {
    }

    @FXML
    private void GoToVelo(ActionEvent event) {
    }

    @FXML
    private void GoToPiece(ActionEvent event) {
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
    private void InitTableRent() {
    }

    @FXML
    private void GoToAddRent(ActionEvent event) {
    }

    @FXML
    private void GoToDeleteRent(ActionEvent event) {
    }

    @FXML
    private void GoToInfo(MouseEvent event) {
    }

    @FXML
    private void GoToRent(ActionEvent event) {
    }

    @FXML
    private void GoToEvent(ActionEvent event) {
    }

    @FXML
    private void SignOut(ActionEvent event) {
    }

}
