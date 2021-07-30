/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.User;
import entities.Piece;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.PieceService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class PieceModifyFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    
    User user = Statics.getCurrentUser();
    @FXML
    private TableView<Piece> pieceTable;
    ObservableList<Piece> piecelist = FXCollections.observableArrayList();
    PieceService ps = new PieceService();
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_type;
    @FXML
    private TableColumn<?, ?> col_prix;
    @FXML
    private TableColumn<?, ?> col_idp;
    @FXML
    private TableColumn<?, ?> col_idu;
    @FXML
    private TableColumn<?, ?> col_desc;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextArea tfDesc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        InitTablePiece();
    }    
    
    private void InitTablePiece() {
        try {
            piecelist = (ObservableList<Piece>) ps.retriveAllPiecesFroFX();

            col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
            col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            col_desc.setVisible(false);
            
            col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            col_idu.setCellValueFactory(new PropertyValueFactory<>("idu"));
            col_idu.setVisible(false);
            
            col_idp.setCellValueFactory(new PropertyValueFactory<>("idp"));
            col_idp.setVisible(false);
            
            pieceTable.setItems(piecelist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
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
            if (user.getRole().equals("user")) {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsUserFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            } else {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./SettingsFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            }

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
        
    }

    @FXML
    private void GoToDelete(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./PieceDeleteFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void UpdatePiece(ActionEvent event) {
        try {
            PieceService lg = new PieceService();
            Piece u = pieceTable.getSelectionModel().getSelectedItem();

            Piece piece = new Piece();
            piece.setIdp(u.getIdp());
            piece.setNom(tfNom.getText());
            piece.setType(tfType.getText());
            piece.setPrix(tfPrix.getText());
            piece.setDescription(tfDesc.getText());
            piece.setIdu(u.getIdu());
            
            lg.modifierPiece(u.getIdp(), piece);
            InitTablePiece();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void getPieceInfo(MouseEvent event) {
        Piece u = pieceTable.getSelectionModel().getSelectedItem();
        tfNom.setText(u.getNom());
        tfType.setText(u.getType());
        tfDesc.setText(u.getDescription());
        tfPrix.setText(u.getPrix());
    }
    
}
