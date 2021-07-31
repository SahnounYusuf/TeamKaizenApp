/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import entities.Velo;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.ServicesVelo;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class VeloFXMLController implements Initializable {

    User user = Statics.getCurrentUser();

    ServicesVelo sv = new ServicesVelo();

    @FXML
    private Label lbWelcome;
    @FXML
    private TextField tfModel;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfSize;
    @FXML
    private TextArea tfDesc;
    @FXML
    private TextField tfBrand;
    @FXML
    private TextField tfQte;
    @FXML
    private TextField tfColor;
    @FXML
    private TextField tfWheight;
    @FXML
    private TextField tfSpeed;
    @FXML
    private TextField tfWheelSize;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfBreak;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
    }

    @FXML
    private void GoToInfo(MouseEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AccountFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void GoToNewsFeed(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToRent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./RentFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToVelo(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToPiece(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./PieceFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEvent(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./EventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToSettings(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void SignOut(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToEdit(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloModifyFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDelete(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloDeleteFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void webQ(KeyEvent e) {

        tfQte.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfQte.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @FXML
    public void webW(KeyEvent e) {

        tfWheight.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfWheight.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @FXML
    public void webSpeed(KeyEvent e) {

        tfSpeed.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfSpeed.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @FXML
    public void webWheel(KeyEvent e) {

        tfWheelSize.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfWheelSize.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @FXML
    public void webPrice(KeyEvent e) {

        tfPrice.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfPrice.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }

    @FXML
    private void AddVelo(ActionEvent event) {

        if ((tfBreak.getText().length() == 0) || (tfBrand.getText().length() == 0)
                || (tfColor.getText().length() == 0) || (tfDesc.getText().length() == 0)
                || (tfSpeed.getText().length() == 0) || (tfModel.getText().length() == 0)
                || (tfPrice.getText().length() == 0) || (tfQte.getText().length() == 0)
                || (tfSize.getText().length() == 0) || (tfType.getText().length() == 0)
                || (tfWheight.getText().length() == 0) || (tfWheelSize.getText().length() == 0)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Attention !");
            alert.setTitle("Erreur de saisie !");
            alert.setContentText("Les champs ne doivent pas etre vide !");
            alert.show();
        } else {

            try {
                Velo v = new Velo();

                v.setBrakingType(tfBreak.getText());
                v.setBrand(tfBrand.getText());
                v.setColor(tfColor.getText());
                v.setDescription(tfDesc.getText());
                v.setIdu(user.getId());
                v.setModel(tfModel.getText());
                v.setNumberOfSpeed(Integer.valueOf(tfSpeed.getText()));
                v.setPrice(Float.valueOf(tfPrice.getText()));
                v.setQuantity(Integer.valueOf(tfQte.getText()));
                v.setSize(tfSize.getText());
                v.setType(tfType.getText());
                v.setWeight(Float.valueOf(tfWheight.getText()));
                v.setWheelSize(Float.valueOf(tfWheelSize.getText()));
                Window owner = tfType.getScene().getWindow();
                sv.ajouterVelo(v);

                showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Post Added.");
                tfBreak.setText(" ");
                tfBrand.setText(" ");
                tfModel.setText(" ");
                tfDesc.setText(" ");
                tfColor.setText(" ");
                tfSpeed.setText(" ");
                tfPrice.setText(" ");
                tfQte.setText(" ");
                tfSize.setText(" ");
                tfType.setText(" ");
                tfWheight.setText(" ");
                tfWheelSize.setText(" ");

            } catch (SQLException ex) {
                System.out.println(ex);
            }

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
    private void ClearFields(ActionEvent event) {
        tfBreak.setText(" ");
        tfBrand.setText(" ");
        tfModel.setText(" ");
        tfDesc.setText(" ");
        tfColor.setText(" ");
        tfSpeed.setText(" ");
        tfPrice.setText(" ");
        tfQte.setText(" ");
        tfSize.setText(" ");
        tfType.setText(" ");
        tfWheight.setText(" ");
        tfWheelSize.setText(" ");
    }

}
