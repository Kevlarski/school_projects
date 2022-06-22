package icecream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * @author kevin
 */
public class IceCream extends Application {
    
    @Override
    public void start(Stage Stage) throws Exception {
        
        Parent parent = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene = new Scene(parent);
        Stage.setTitle("Kevin McLaughlin - Ice Cream");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
