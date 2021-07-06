/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class RegisterVerificationFXMLController implements Initializable {

    @FXML
    private TextField tfCode;

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

            tfCode.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void ConfirmSignUp(ActionEvent event) {

        UserServices us = new UserServices();

        Window owner = tfCode.getScene().getWindow();

        if (Integer.valueOf(tfCode.getText()) == Statics.getVerificationCode()) {

            boolean flag = us.addUser(Statics.getNewUser());
            if (!flag) {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Oops! there's a problem with your informations.");
                tfCode.setText(" ");
            } else {
                showAlert(Alert.AlertType.INFORMATION, owner, "Success!",
                        "Welcome to the family :D");
                tfCode.setText(" ");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Wrong code.");
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
