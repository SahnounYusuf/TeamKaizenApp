/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import entities.UserLog;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import services.LogService;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class LogSettingsFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<UserLog> LogTable;
    @FXML
    private TableColumn<?, ?> nom_col;
    @FXML
    private TableColumn<?, ?> prenom_col;
    @FXML
    private TableColumn<?, ?> email_col;
    @FXML
    private TableColumn<?, ?> role_col;
    @FXML
    private TextField searchBar;
    @FXML
    private TableColumn<?, ?> time_col;
    @FXML
    private TableColumn<?, ?> id_col;
    
    UserServices us = new UserServices();
    LogService ul = new LogService();

    ObservableList<UserLog> loglist = FXCollections.observableArrayList();
    
    User user = Statics.getCurrentUser();
    @FXML
    private Circle userAvatar;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbWelcome.setText(user.getPrenom() + " " + user.getNom());
        try {
            InputStream pic = us.retrivePictureById(user.getId());
            if (pic.available() > 0) {
                BufferedImage imBuff = ImageIO.read(pic);
                WritableImage image = SwingFXUtils.toFXImage(imBuff, null);
                userAvatar.setFill(new ImagePattern(image));
            }
            else{
                InputStream photo = new FileInputStream(new File("images/user.png"));
                BufferedImage imBuff = ImageIO.read(pic);
                WritableImage image = SwingFXUtils.toFXImage(imBuff, null);
                userAvatar.setFill(new ImagePattern(image));
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        }
        InitTableLog();
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
    private void InitTableLog() {
        try {
            loglist = (ObservableList<UserLog>) ul.retriveAllUserLogFroFX();
            id_col.setCellValueFactory(new PropertyValueFactory<>("idu"));
            id_col.setVisible(false);
            nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
            time_col.setCellValueFactory(new PropertyValueFactory<>("dateLogged"));
            role_col.setCellValueFactory(new PropertyValueFactory<>("role"));
            LogTable.setItems(loglist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @FXML
    private void DeleteLog(ActionEvent event) {
        Window owner = lbWelcome.getScene().getWindow();
        UserLog e = LogTable.getSelectionModel().getSelectedItem();
        if (!e.equals(null)) {
            try {
                ul.deleteLog(e.getIdu());
                showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Log deleted.");
                InitTableLog();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void Sort(ActionEvent event) {
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
    private void GoToLog(ActionEvent event) {
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
