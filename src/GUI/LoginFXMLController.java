/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        System.out.println("hmm... \nSo you wanna create an account??");
    }

    @FXML
    private void ForgetPasswordClicked(ActionEvent event) {
        System.out.println("Dude how can you forget your fucking password!!!");
    }

    @FXML
    private void LoginClicked(ActionEvent event) {
        System.out.println("Login Clicked, I need some action\n Username: "+tfUsername.getText()+"\n Password: "+tfPassword.getText());
        MaConnection m1 = MaConnection.getInstance();
        Connection c1 = m1.getCnx();
        
        System.out.println(c1);
    }
    
}
