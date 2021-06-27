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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        try {

            UserServices us = new UserServices();

            User u1;
            u1 = new User(Integer.parseInt(tfId.getText()), tfNom.getText(), tfPrenom.getText(), tfEmail.getText(), Integer.parseInt(tfPhone.getText()), tfPassword.getText());
            
            us.addUser(u1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
