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
    private TableView<Velo> RentTable;
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
    
    ServicesVelo sv = new ServicesVelo();

    ObservableList<ServicesVelo> velolist = FXCollections.observableArrayList();

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
