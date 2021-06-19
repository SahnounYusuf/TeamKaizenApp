/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUpClicked(ActionEvent event) {
    }

    @FXML
    private void ForgetPasswordClicked(ActionEvent event) {
    }

    @FXML
    private void LoginClicked(ActionEvent event) {
    }
    
}
