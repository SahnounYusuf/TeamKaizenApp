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
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.RentService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class RentFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    private TableColumn<?, ?> idv_col;
    private TableColumn<?, ?> idu_col;
    private TableColumn<?, ?> marque_col;
    private TableColumn<?, ?> model_col;
    private TableColumn<?, ?> prix_per_hour_col;
    private TableColumn<?, ?> date_disponibility;
    private TableView<Rent> RentTable;
    private TableColumn<?, ?> col_phone;

    User user = Statics.getCurrentUser();
//    RentService rs = new RentService();
//    ObservableList<Rent> rentlist = FXCollections.observableArrayList();
    @FXML
    private TextField tfMark;
    @FXML
    private TextField tfModel;
    @FXML
    private TextField tfPriceHour;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
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
    private void GoToEdit(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentModifyFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDelete(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentDeleteFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void AddLouer(ActionEvent event) {
        Window owner = tfDate.getScene().getWindow();
        try {
            RentService rs = new RentService();
            Rent p = new Rent();
            p.setMarque(tfMark.getText());
            p.setModel(tfModel.getText());
            p.setPrix_per_hour(Float.parseFloat(tfPriceHour.getText()));
            p.setDate_disponibility(tfDate.getText());
            p.setPhone(Integer.parseInt(tfPhone.getText()));
            rs.ajouterRent(p);
            showAlert(Alert.AlertType.INFORMATION, owner, "Success!",
                    "Offer added.");
        } catch (SQLException ex) {
            System.out.println(ex);
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
