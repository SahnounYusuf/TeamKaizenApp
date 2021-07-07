/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginFXMLController.infoBox;
import entities.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class AccountFXMLController implements Initializable {
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private Label lbPictureName;
    @FXML
    private ImageView img;
    FileInputStream fin= null;

    User user = Statics.getCurrentUser();
    byte[] person_image = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfEmail.setText(user.getEmail());
        tfPhone.setText(Integer.toString(user.getPhone()));
        tfPrenom.setText(user.getPrenom());
        tfNom.setText(user.getNom());
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
//        if (tfPassword.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter a password");
//            return;
//        }
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
//        String password = tfPassword.getText();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPhone(phone);
        u.setEmail(email);
        u.setPassword(user.getPassword());
        UserServices lg = new UserServices();
        boolean flag = lg.modifyUser(user.getId(), u, Statics.getImagePath());
        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
            showAlert(Alert.AlertType.INFORMATION, owner, "Success",
                    "Your information has been modified!");
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

    @FXML
    private void GoToAcceuil(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            tfPhone.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEditPassword(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AccountPasswordFXML.fxml"));
            Parent parent = root.load();
            tfPhone.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void UploadImageActionPerformed(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            img.setImage(image);
            img.setFitWidth(100);
            img.setFitHeight(100);
            img.setSmooth(true);
            img.setCache(true);
            fin = new FileInputStream(file);
            
            System.out.println(file.getAbsolutePath());
            Statics.setImagePath(file.getAbsolutePath());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            person_image = bos.toByteArray();
            System.out.println(person_image);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
