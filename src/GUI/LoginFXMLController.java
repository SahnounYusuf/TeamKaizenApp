/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsername;

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
        System.out.println("Dude how can you forget your fucking password!!!");
    }

    @FXML
    private void LoginClicked(ActionEvent event) {
        try {

            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));

            Parent parent = root.load();

            AcceuilFXMLController apc = root.getController();

            tfPassword.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
