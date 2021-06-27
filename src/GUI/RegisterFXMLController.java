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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SignInClicked(ActionEvent event) {

        try {

            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));

            Parent parent = root.load();

            tfEmail.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void RegisterClicked(ActionEvent event) {

        UserServices us = new UserServices();

        Window owner = tfNom.getScene().getWindow();

        if (tfNom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your First Name");
            return;
        }
        if (tfPassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }
        if (tfPrenom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a Prenom");
            return;
        }
        if (tfPhone.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a Phone");
            return;
        }
        if (tfEmail.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a Email");
            return;
        }

        User u1;
        u1 = new User(Integer.parseInt(tfId.getText()), tfNom.getText(), tfPrenom.getText(), tfEmail.getText(), Integer.parseInt(tfPhone.getText()), tfPassword.getText());

        boolean flag = us.addUser(u1);
        if (!flag) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Oops! there's a problem with your informations.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, owner, "Success!",
                    "Welcome to the family :D");
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
