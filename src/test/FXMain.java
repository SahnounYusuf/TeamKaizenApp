/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sahnoun Yusuf
 */
public class FXMain extends Application {
    
    public void start(Stage primaryStage) throws IOException {
        
         FXMLLoader loader= new FXMLLoader(getClass().getResource("../GUI/LoginFXML.fxml"));
         Parent root= loader.load();
         Scene scene = new Scene(root);
         primaryStage.setTitle("KaizenApp");
         primaryStage.setScene(scene);
         primaryStage.setResizable(false);
         primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}