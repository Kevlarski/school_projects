/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package seasonapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class SeasonApp extends Application {
    
    /**
     *
     * @param Stage
     */
    @Override
    public void start(Stage Stage) {
        RadioButton summer = new RadioButton("Summer");
        RadioButton winter = new RadioButton("Winter");
        Button btn = new Button("Which Season is it?");
        btn.setOnAction(            
           event -> {
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Season");
               alert.setHeaderText("The Season is:");
               if (summer.isSelected()){
                   alert.setContentText("Summer!");
                           }
               else if (winter.isSelected()){
                   alert.setContentText("Winter!");
               }
               alert.showAndWait();
             
        });          
    }
        
        HBox root = new HBox();
        root.getChildren
        //root.getChildren().addAll(summer, winter, btn);
        TitledPane pane = new TitledPane();
        pane.setText("SeasonApp");
        pane.setContent(root);
        Scene scene = new Scene(root, 300, 250);
        
        //Stage.setTitle("Season");
        Stage.setScene(scene);
        Stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
