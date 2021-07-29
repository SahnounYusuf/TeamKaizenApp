/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.stage.Window;
import services.MailService;
import services.SmsService;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class ForgetPasswordFXMLController implements Initializable {

    @FXML
    private TextField tfEmailPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            tfEmailPhone.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void SendPassword(ActionEvent event) {
        Window owner = tfEmailPhone.getScene().getWindow();
        try {
            if (tfEmailPhone.getText().length() == 8) {
                SmsService ss = new SmsService();
                ss.SendPassword(tfEmailPhone.getText());
                showAlert(Alert.AlertType.INFORMATION, owner, "Success", "An SMS has been send to your phone number.");
            } else {
                MailService es = new MailService();
                es.SendPassword(tfEmailPhone.getText());
                showAlert(Alert.AlertType.INFORMATION, owner, "Success", "An Email has been send to you.");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToLogin(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            tfEmailPhone.getScene().setRoot(parent);
        } catch (IOException ex) {
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
