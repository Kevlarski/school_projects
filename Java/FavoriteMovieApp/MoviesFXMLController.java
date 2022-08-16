
package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kevin McLaughlin
 */
public class MoviesFXMLController implements Initializable {
   
    @FXML private Button addBtn;
    @FXML private TextField addInput;
    @FXML private Button saveBtn;
    @FXML private Button removeBtn;
    @FXML private Button loadBtn;
    
    private ObservableList<String> movies = FXCollections.observableArrayList();
    @FXML private ListView<String> list =new ListView(movies);
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       
    }    

    /**Looks for a file named "movies.txt", if it fails alerts the user
     * that it couldn't be found. If found, it will clear the present
     * list and replace it with a list stored in the file. 
     * 
     * @param event 
     */
    @FXML
    private void load(ActionEvent event) {
        try {
            Scanner reader = new Scanner(new File("movies.txt"));
            movies.clear();
            while(reader.hasNext()){
                movies.add(reader.nextLine());
            }//end while
            list.setItems(movies);
            
        } catch (FileNotFoundException ex) {
            Alert noFileError = new Alert(AlertType.ERROR, "Cannot locate save file");
            noFileError.show();
        }//end catch
    }//end load

    /**Takes the text in the input box, removes
     * extra white-space at the ends of the entry,
     * forces lower-case, and adds it to the list.
     * Then clears the box for a new entry.
     * 
     * @param event 
     */
    @FXML
    private void add(ActionEvent event) {
        movies.add(addInput.getText().stripIndent().toLowerCase());
        list.setItems(movies);
        addInput.clear();
    }//end add

    /**Takes all items in the list and uses FileWriter 
     * to create or overwrite the file "movies.txt"
     * If an error occurs, alerts the user with a pop-up.
     * 
     * @param event 
     */
    @FXML
    private void save(ActionEvent event) {
        try {
            FileWriter listSaver = new FileWriter("movies.txt");
            for (String s:movies){
                listSaver.write(s);
                listSaver.write("\n");
            }//end for
            listSaver.close();
        } catch (IOException ex) {
            Alert ioError = new Alert(AlertType.ERROR, "An Error has occured writing the Save file.");
            ioError.show();
        }//end catch
    }//end save
    
    /**Removes the selected items from the ListView window. If no selections are
     * present, alerts the user to make a selection.
     * 
     * @param event 
     */
    @FXML
    private void remove(ActionEvent event) {
        ObservableList selected = list.getSelectionModel().getSelectedItems();
        if(selected.isEmpty()){
            Alert noSelect = new Alert(AlertType.WARNING, "Please make a selection");
            noSelect.show();
        }//end if
        else{
            movies.removeAll(selected);
         }//end else
       list.setItems(movies);
    }//end remove
    
}
