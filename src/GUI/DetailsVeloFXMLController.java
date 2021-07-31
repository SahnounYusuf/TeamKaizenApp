/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import entities.Velo;
import java.io.IOException;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import services.ServicesVelo;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class DetailsVeloFXMLController implements Initializable {
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


    Velo e = Statics.getSelectedVelo();
     User user = Statics.getCurrentUser();//

    ServicesVelo sv = new ServicesVelo();//

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
        tfBrand.setText(e.getBrand());
        tfType.setText(e.getType());
        tfModel.setText(e.getModel());
        tfSize.setText(e.getSize());
        tfWheelSize.setText(Float.toString(e.getWheelSize()));
        tfBreak.setText(e.getBrakingType());
        tfSpeed.setText(Integer.toString(e.getNumberOfSpeed()));
        tfQte.setText(Integer.toString(e.getQuantity()));
        tfColor.setText(e.getColor());
        tfWheight.setText(Float.toString(e.getWeight()));
        tfPrice.setText(Float.toString(e.getPrice()));
        tfDesc.setText(e.getDescription());    
    }    
     @FXML
    private void ConfrimClicked(ActionEvent event) {
     System.out.println(e.getId() + " " + e.getBrand());
        Velo e1 = new Velo();
        
        e1.setBrand(tfBrand.getText());
        e1.setModel(tfModel.getText());
        e1.setSize(tfSize.getText());
        e1.setWheelSize(e.getWheelSize());
        e1.setBrakingType(tfBreak.getText());
        e1.setNumberOfSpeed(e.getNumberOfSpeed());
        e1.setQuantity(e.getQuantity());
        e1.setColor(tfColor.getText());
        e1.setWeight(e.getWeight());
        e1.setPrice(e.getPrice());
        e1.setDescription(tfDesc.getText());


        
        Window owner = tfType.getScene().getWindow();
        try {
            ServicesVelo es = new ServicesVelo();
            es.modifierVelo(e.getId(), e1);
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                        "Velo Modified.");
        } catch (SQLException ex) {
            System.out.println(e);
        }
  

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
           // Window owner = tfType.getScene().getWindow();
            sv.ajouterVelo(v);
sv.supprimerVelo(e.getId());
            showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                    "Post Modified.");
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
    
    @FXML
    private void BackClicked(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloModifyFXML.fxml"));
            Parent parent = root.load();
            tfType.getScene().setRoot(parent);
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
