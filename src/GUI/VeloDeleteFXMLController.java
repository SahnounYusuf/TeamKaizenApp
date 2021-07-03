/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.DescriptionVelo;
import entities.Rent;
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
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ServiceDescription;
import services.ServicesVelo;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class VeloDeleteFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<DescriptionVelo> RentTable;
    @FXML
    private TableColumn<?, ?> col_idv;
    @FXML
    private TableColumn<?, ?> col_idu;
    @FXML
    private TableColumn<?, ?> col_mark;
    @FXML
    private TableColumn<?, ?> col_model;
    @FXML
    private TableColumn<?, ?> col_desc;
    @FXML
    private TableColumn<?, ?> col_price;
    
    User user = Statics.getCurrentUser();
    
    ServiceDescription sv = new ServiceDescription();

    ObservableList<DescriptionVelo> velolist = FXCollections.observableArrayList();

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
    private void InitTableRent() {
        try {
            velolist = (ObservableList<DescriptionVelo>) sv.retriveAllVeloFroFX();

            col_idv.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_idu.setCellValueFactory(new PropertyValueFactory<>("idu"));
            col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
            col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
            col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

            RentTable.setItems(velolist);

        } catch (SQLException ex) {
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
    private void DeleteVelo(ActionEvent event) {
        
        DescriptionVelo u = RentTable.getSelectionModel().getSelectedItem();
        ServiceDescription rs = new ServiceDescription();
        ServicesVelo sv = new ServicesVelo();
        if (!u.equals(null)) {
            try {
                rs.supprimerDescriptionVelo(u.getId());
                sv.supprimerVelo(u.getId());
                InitTableRent();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
}
