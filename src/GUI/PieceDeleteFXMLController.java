/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Piece;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.PieceService;
import services.RentService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class PieceDeleteFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableColumn<?, ?> col_name;
    @FXML
    private TableColumn<?, ?> col_type;
    @FXML
    private TableColumn<?, ?> col_desc;
    @FXML
    private TableColumn<?, ?> col_Price;
    @FXML
    private TableView<Piece> PieceTable;
    
    ObservableList<Piece> piecelist = FXCollections.observableArrayList();
    User user = Statics.getCurrentUser();
    PieceService ps = new PieceService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTablePiece();
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
    private void GoToEdit(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./PieceModifyFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDelete(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./PieceDeleteFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void DeletePiece(ActionEvent event) {
        Piece u = PieceTable.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            try {
                ps.supprimerPiece(u.getIdp());
                InitTablePiece();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void InitTablePiece() {
        try {
            piecelist = (ObservableList<Piece>) ps.retriveAllPiecesFroFX();

            col_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_Price.setCellValueFactory(new PropertyValueFactory<>("prix"));

            PieceTable.setItems(piecelist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
