/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Velo;
import services.ServicesVelo;
import entities.User;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import utils.Statics;


/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class VeloModifyFXMLController implements Initializable {

    @FXML
    private Label lbWelcome;
    @FXML
    private TableView<Velo> VeloTable;
    
    @FXML
    private TableColumn<?, ?> id_col;
    @FXML
    private TableColumn<?, ?> brand_col;
    @FXML
    private TableColumn<?, ?> model_col;
    @FXML
    private TableColumn<?, ?> type_col;
    @FXML
    private TableColumn<?, ?> quantity_col;
    @FXML
    private TableColumn<?, ?> price_col;
    @FXML
    private TableColumn<?, ?> size_col;
    @FXML
    private TableColumn<?, ?> wheelsize_col;
    @FXML
    private TableColumn<?, ?> Brakingtype_col;
    @FXML
    private TableColumn<?, ?> numberofspeed_col;
    @FXML
    private TableColumn<?, ?> color_col;
    @FXML
    private TableColumn<?, ?> weight_col;
    @FXML
    private TableColumn<?, ?> description_col;
    
    
    ServicesVelo es = new ServicesVelo();

    ObservableList<Velo> velolist = FXCollections.observableArrayList();

    Velo velo = new Velo();

    User user = Statics.getCurrentUser();
        
   // private ListView<Velo> listvelos;
   



    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // TODO
        lbWelcome.setText("User: " + user.getPrenom() + " " + user.getNom());
        System.out.println("the user is: " + user);
        InitTableVelo();
            // listevelos.setItems(velolist);
       /*} catch (SQLException ex) {
            Logger.getLogger(VeloModifyFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO*/
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
    private void InitTableVelo() {
        try {
            velolist = (ObservableList<Velo>) es.retrieveAllVeloFroFX();
                id_col.setCellValueFactory(new PropertyValueFactory<>("idu"));
            brand_col.setCellValueFactory(new PropertyValueFactory<>("Brand"));
            model_col.setCellValueFactory(new PropertyValueFactory<>("Model"));
            type_col.setCellValueFactory(new PropertyValueFactory<>("Type"));
            size_col.setCellValueFactory(new PropertyValueFactory<>("Size"));
            wheelsize_col.setCellValueFactory(new PropertyValueFactory<>("WheelSize"));
            Brakingtype_col.setCellValueFactory(new PropertyValueFactory<>("BrakingType"));
            numberofspeed_col.setCellValueFactory(new PropertyValueFactory<>("NumberOfSpeed"));
            quantity_col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            color_col.setCellValueFactory(new PropertyValueFactory<>("Color"));
            weight_col.setCellValueFactory(new PropertyValueFactory<>("Weight"));
            price_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
            description_col.setCellValueFactory(new PropertyValueFactory<>("Description"));

            VeloTable.setItems(velolist);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private class CustomListCell extends ListCell<Velo> {

    private HBox content;
    private Text brand;
    private Text model;
    private Text type;
    private Text size;
    private Text wheelSize;
    private Text brakingType;
    private Text numberOfSpeed;
    private Text quantity;
    private Text color;
    private Text weight;
    private Text price;
    private Text description;


        public CustomListCell() {
            super();
            brand = new Text();
            model = new Text();
            type = new Text();
            size = new Text();
            wheelSize = new Text();
            brakingType = new Text();
            numberOfSpeed = new Text();
            quantity = new Text();
            color = new Text();
            weight = new Text();
            price = new Text();
            description = new Text();

            //HBox dateBox = new HBox(new Label("[Img here] "), date);
            VBox vBox = new VBox(brand, model, type, size,wheelSize,brakingType,numberOfSpeed,quantity,color,weight,price,description);
            content = new HBox(new Label("[Graphic]"), vBox);
            content.setSpacing(10);
        }
    }

    @FXML
    private void GoToDetailsVelo(ActionEvent event) {
         Velo e = VeloTable.getSelectionModel().getSelectedItem();
        System.out.println(e);

        if (!e.equals(null)) {
            Statics.setSelectedVelo(e);
            //System.out.println(e);
            try {
                FXMLLoader root = new FXMLLoader(getClass().getResource("./DetailsVeloFXML.fxml"));
                Parent parent = root.load();
                lbWelcome.getScene().setRoot(parent);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void GoToAddPost(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void GoToDeleteVelo(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./VeloDeleteFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
