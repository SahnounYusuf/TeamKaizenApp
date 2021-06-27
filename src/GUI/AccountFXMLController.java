/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginFXMLController.infoBox;
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
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class AccountFXMLController implements Initializable {
    
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    
    User user = Statics.getCurrentUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ConfrimClicked(ActionEvent event) {
        Window owner = tfNom.getScene().getWindow();
        User u = new User();
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
        int phone = Integer.parseInt(tfPhone.getText());
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String email = tfEmail.getText();
        String password = tfPassword.getText();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPhone(phone);
        u.setEmail(email);
        u.setPassword(password);
        UserServices lg = new UserServices();
        boolean flag = lg.modifyUser(user.getId(), u);
        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
            showAlert(Alert.AlertType.INFORMATION, owner, "Success",
                    "Your information has been modified!");
        }
    }

    @FXML
    private void BackClicked(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            tfPhone.getScene().setRoot(parent);
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
