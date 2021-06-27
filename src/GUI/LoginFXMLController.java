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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.LoginService;
import javafx.stage.Window;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class LoginFXMLController implements Initializable {
    
    private static User currentUser;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField tfPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SignUpClicked(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RegisterFXML.fxml"));

            Parent parent = root.load();

            RegisterFXMLController apc = root.getController();

            tfUsername.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void ForgetPasswordClicked(ActionEvent event) {
        System.out.println("Dude how can you forget your password!!!");
    }

    @FXML
    private void LoginClicked(ActionEvent event) {
        try {
            Window owner = tfUsername.getScene().getWindow();

            System.out.println(tfUsername.getText());
            System.out.println(tfPassword.getText());

            if (tfUsername.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter your email id");
                return;
            }
            if (tfPassword.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter a password");
                return;
            }

            int id = Integer.parseInt(tfUsername.getText());
            String password = tfPassword.getText();

            LoginService lg = new LoginService();
            boolean flag = lg.validate(id, password);

            if (!flag) {
                infoBox("Please enter correct Email and Password", null, "Failed");
            } else {
                UserServices us = new UserServices();
                Statics.setCurrentUser(us.retriveUserById(id));
                System.out.println(Statics.getCurrentUser());
                
                FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
                
                Parent parent = root.load();

                tfPassword.getScene().setRoot(parent);
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
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