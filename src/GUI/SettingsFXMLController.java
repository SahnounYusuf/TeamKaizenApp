/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.LoginFXMLController.infoBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import services.UserServices;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Sahnoun Yusuf
 */
public class SettingsFXMLController implements Initializable {

    User user = Statics.getCurrentUser();
    UserServices us = new UserServices();
    ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    private Label lbWelcome;
    @FXML
    private TextField searchBar;
    @FXML
    private ListView<User> userList;
    @FXML
    private Circle userAvatar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbWelcome.setText(user.getPrenom() + " " + user.getNom());
        try {
            InputStream pic = us.retrivePictureById(user.getId());
            if (pic.available() > 0) {
                BufferedImage imBuff = ImageIO.read(pic);
                WritableImage image = SwingFXUtils.toFXImage(imBuff, null);
                userAvatar.setFill(new ImagePattern(image));
            }
            else{
                InputStream photo = new FileInputStream(new File("images/user.png"));
                BufferedImage imBuff = ImageIO.read(pic);
                WritableImage image = SwingFXUtils.toFXImage(imBuff, null);
                userAvatar.setFill(new ImagePattern(image));
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        }
        InitTableUser();
    }

    @FXML
    private void SearchUpdate(KeyEvent event) {
        FilteredList<User> filteredData = new FilteredList<>(users);
        //Set the filter Predicate whenever the filter changes.
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every client with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (client.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches first name
                } else if (client.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches last name
                }
                return false; //Does not match
            });
        });

        //Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);

        //put the sorted list into the listview
        userList.setItems(sortedData);
    }

    private class CustomListCell extends ListCell<User> {

        private HBox content;
        private Text firstName;
        private Text lastName;
        private Text email;
        private Text phone;
        private Text role;
        private Text space;

        public CustomListCell() {
            super();
            firstName = new Text();
            lastName = new Text();
            email = new Text();
            phone = new Text();
            role = new Text();
            space = new Text(" ");

            HBox roleInfo = new HBox(new FontAwesomeIconView(FontAwesomeIcon.COG, "0.5cm"), role);
            roleInfo.setSpacing(3);
            HBox userInfo = new HBox(new FontAwesomeIconView(FontAwesomeIcon.USER, "0.5cm"), firstName, lastName);
            userInfo.setSpacing(3);
            HBox emailInfo = new HBox(new FontAwesomeIconView(FontAwesomeIcon.MAIL_FORWARD, "0.5cm"), email);
            emailInfo.setSpacing(3);
            HBox phoneInfo = new HBox(new FontAwesomeIconView(FontAwesomeIcon.PHONE, "0.5cm"), phone);
            phoneInfo.setSpacing(3);

            VBox vBox = new VBox(userInfo, roleInfo, emailInfo, phoneInfo, space);
            vBox.setSpacing(3);
            content = new HBox(vBox);
            content.setSpacing(20);
        }

        @Override
        protected void updateItem(User item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                firstName.setText(item.getNom());
                lastName.setText(item.getPrenom());
                email.setText(item.getEmail());
                phone.setText(String.valueOf(item.getPhone()));
                role.setText(item.getRole());
                setGraphic(content);
            } else {
                setGraphic(null);
            }
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

    private void InitTableUser() {
        try {
            users = (ObservableList<User>) us.retriveAllUsersFroFX();
            userList.setItems(users);
            userList.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
                @Override
                public ListCell<User> call(ListView<User> listView) {
                    return new CustomListCell();
                }
            });

            // listevents.setItems(eventlist);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void search(ActionEvent event) {
        FilteredList<User> filteredData = new FilteredList<>(users);
        //Set the filter Predicate whenever the filter changes.
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every client with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (client.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches first name
                } else if (client.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; //filter matches last name
                }
                return false; //Does not match
            });
        });

        //Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);

        //put the sorted list into the listview
        userList.setItems(sortedData);
    }

    @FXML
    private void Sort(ActionEvent event) {

    }

    @FXML
    private void DeleteUser(ActionEvent event) {
        User u = userList.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            try {
                us.deleteUser(u.getId(), u);
                InitTableUser();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void MakeAdmin(ActionEvent event) {
        User u = userList.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            boolean flag = us.makeAdmin(u.getId(), u);
            InitTableUser();
            if (!flag) {
                infoBox("Operation can't be made!", null, "Failed");
            }
        }
    }

    @FXML
    private void MakeUser(ActionEvent event) {

        User u = userList.getSelectionModel().getSelectedItem();
        if (!u.equals(null)) {
            boolean flag = us.makeUser(u.getId(), u);
            InitTableUser();
            if (!flag) {
                infoBox("Operation can't be made!", null, "Failed");
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
    private void GoToLog(ActionEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("./LogSettingsFXML.fxml"));
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
            FXMLLoader root = new FXMLLoader(getClass().getResource("./AddEventFXML.fxml"));
            Parent parent = root.load();
            lbWelcome.getScene().setRoot(parent);
        } catch (IOException ex) {
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
}
