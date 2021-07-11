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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class AccountPasswordFXMLController implements Initializable {

    @FXML
    private TextField tfOldPassword;
    @FXML
    private TextField tfNewPassword;
    @FXML
    private TextField tfRetypePassword;

    User user = Statics.getCurrentUser();
    UserServices us = new UserServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void GoToAcceuil(MouseEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            tfOldPassword.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToAccount(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AccountFXML.fxml"));
            Parent parent = root.load();
            tfOldPassword.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void ConfrimClicked(ActionEvent event) {

        Window owner = tfNewPassword.getScene().getWindow();

        try {
            if (tfOldPassword.getText().equals(us.retriveUserPasswordById(String.valueOf(user.getId())))) {

                if (tfNewPassword.getText().equals(tfRetypePassword.getText())) {
                    boolean flag = us.updatePassword(user.getId(), tfNewPassword.getText());
                    if (!flag) {
                        showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                                "An error occured while changing your password, please try again.");
                    } else {
                        infoBox("Your password have been changed!", "Operation made",
                                "Success");
                    }
                } else {
                    showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                            "the new password and retype password must be the same");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Old password is incorrect");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToAcceuil(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            tfOldPassword.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
