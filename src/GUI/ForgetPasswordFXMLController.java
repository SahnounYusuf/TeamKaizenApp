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
import javafx.scene.control.TextField;
import services.MailService;
import services.SmsService;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class ForgetPasswordFXMLController implements Initializable {

    @FXML
    private TextField tfSms;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BackToLogin(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            tfSms.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void SendSMS(ActionEvent event) {
        try {
            if (tfSms.getText().length() == 8) {
                SmsService ss = new SmsService(tfSms.getText());
            }
            else
            {
                MailService es = new MailService(tfSms.getText());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
