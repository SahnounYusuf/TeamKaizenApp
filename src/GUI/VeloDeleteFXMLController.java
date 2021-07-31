/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import entities.Velo;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.ServicesVelo;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class VeloDeleteFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<Velo> VeloTable;
    @FXML
    private TableColumn<?, ?> id_col;
    @FXML
    private TableColumn<?, ?> brand_col;
    @FXML
    private TableColumn<?, ?> model_col;
    @FXML
    private TableColumn<?, ?> type_col;
    @FXML
    private TableColumn<?, ?> quantity_col;
    @FXML
    private TableColumn<?, ?> price_col;
    ServicesVelo es = new ServicesVelo();

    ObservableList<Velo> velolist = FXCollections.observableArrayList();

    Velo velo = new Velo();

    User user = Statics.getCurrentUser();
    @FXML
    private TableColumn<?, ?> size_col;
    @FXML
    private TableColumn<?, ?> wheelsize_col;
    @FXML
    private TableColumn<?, ?> Brakingtype_col;
    @FXML
    private TableColumn<?, ?> numberofspeed_col;
    @FXML
    private TableColumn<?, ?> color_col;
    @FXML
    private TableColumn<?, ?> weight_col;
    @FXML
    private TableColumn<?, ?> description_col;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableVelo();
        // TODO
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

    @FXML
    private void GoToPost(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEdit(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloModifyFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void DelVelo(ActionEvent event) {
        Window owner = lbWelcome.getScene().getWindow();
        Velo e = (Velo) VeloTable.getSelectionModel().getSelectedItem();
        if (!e.equals(null)) {
            try {
                es.supprimerVelo(e.getId());
                showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Velo deleted.");
                InitTableVelo();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void InitTableVelo() {
        try {
            velolist = (ObservableList<Velo>) es.retrieveAllVeloFroFX();
            id_col.setCellValueFactory(new PropertyValueFactory<>("idu"));
            brand_col.setCellValueFactory(new PropertyValueFactory<>("Brand"));
            model_col.setCellValueFactory(new PropertyValueFactory<>("Model"));
            type_col.setCellValueFactory(new PropertyValueFactory<>("Type"));
            size_col.setCellValueFactory(new PropertyValueFactory<>("Size"));
            wheelsize_col.setCellValueFactory(new PropertyValueFactory<>("WheelSize"));
            Brakingtype_col.setCellValueFactory(new PropertyValueFactory<>("BrakingType"));
            numberofspeed_col.setCellValueFactory(new PropertyValueFactory<>("NumberOfSpeed"));
            quantity_col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            color_col.setCellValueFactory(new PropertyValueFactory<>("Color"));
            weight_col.setCellValueFactory(new PropertyValueFactory<>("Weight"));
            price_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
            description_col.setCellValueFactory(new PropertyValueFactory<>("Description"));

            VeloTable.setItems(velolist);

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

}
