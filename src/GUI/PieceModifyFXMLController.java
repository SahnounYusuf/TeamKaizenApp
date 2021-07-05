/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Toshiba
 */
public class PieceModifyFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TextField tfMark;
    @FXML
    private TextField tfModel;
    @FXML
    private TextField tfPriceHour;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfPhone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OpenAccountInfo(MouseEvent event) {
    }

    @FXML
    private void GoToNewsFeed(ActionEvent event) {
    }

    @FXML
    private void GoToVelo(ActionEvent event) {
    }

    @FXML
    private void GoToPiece(ActionEvent event) {
    }

    @FXML
    private void GoToEvents(ActionEvent event) {
    }

    @FXML
    private void GoToSettings(ActionEvent event) {
    }

    @FXML
    private void Signout(ActionEvent event) {
    }

    @FXML
    private void GoToEdit(ActionEvent event) {
    }

    @FXML
    private void GoToDelete(ActionEvent event) {
    }

    @FXML
    private void AddLouer(ActionEvent event) {
    }
    
}
