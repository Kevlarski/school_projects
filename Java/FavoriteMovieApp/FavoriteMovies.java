
package proj3;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Kevin McLaughlin
 */
public class FavoriteMovies extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MoviesFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Favorite Movies");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("An Error has occured.");
        }
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
} 

