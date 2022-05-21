/*
Kevin McLaughlin
CIS 1500 Mehta
Ice Cream Order App
 */
package icecream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;


/**
 * FXML Controller class
 *
 * @author kevin
 */
public class SceneController implements Initializable {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private final double scoop = 2.25;
    private final double taxPer = .06;
    private final double toppings = .50;
    DecimalFormat df = new DecimalFormat("##.##");
     
    @FXML
    private TitledPane tpFlavors;
    @FXML
    private RadioButton rbChoc;
    @FXML
    private ToggleGroup rbFlavors;
    @FXML
    private RadioButton rbVan;
    @FXML
    private RadioButton rbStraw;
    @FXML
    private TitledPane tpToppings;
    @FXML
    private CheckBox cbNuts;
    @FXML
    private CheckBox cbCherries;
    @FXML
    private TitledPane tpOrder;
    @FXML
    private Button btnCalCost;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnRestore;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    //Method to calculate choices and display the cost
    public void calCost(){
        //Variables to calculate
        double ordTax =0;
        double total = 0;
        double order = 0; 
        
        //Both toppings selected  
        if (cbNuts.isSelected() && cbCherries.isSelected()){
          order = scoop+(toppings*2);
          ordTax = order*taxPer;
          total = order+ordTax;
        }
      
        //Either topping, but only one
        else if((cbNuts.isSelected()&& !cbCherries.isSelected())
                ||(!cbNuts.isSelected()&&cbCherries.isSelected())){
          order = scoop+toppings;
          ordTax = order*taxPer;
          total = order+ordTax;
        }
      
        //No toppings selected
        else{
          order = scoop;
          ordTax = order*taxPer;
          total = order+ordTax;
        }//end if-else

        //Alert box displaying order details
        alert.setHeight(222.0);
        alert.setTitle("Your Order");
        alert.setHeaderText("Total: $"+ df.format(total));
        alert.setContentText("Order: $"+df.format(order)+"\nTax: $"
                +df.format(ordTax)+"\nTotal: $"+df.format(total));
        alert.showAndWait();
        
    }//end calCost
    
    //Method to save current choices
    public void save(){

        //Using BufferedWiter to create .txt file based on selections    
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("ice_cream.txt"))) {
            if(rbChoc.isSelected()){
                bw.write("Chocolate");
            }
            else if(rbVan.isSelected()){
                bw.write("Vanilla");
            }
            else{
                bw.write("Strawberry");
            }
            bw.newLine();
              
            if (cbNuts.isSelected() && cbCherries.isSelected()){
                bw.write("With_Nuts\n");
                bw.write("With_Cherries");
            }
            else if (cbNuts.isSelected()&& !cbCherries.isSelected()){
                bw.write("With_Nuts\n");
                bw.write("Without_Cherries");
            }
            else if(!cbNuts.isSelected()&& cbCherries.isSelected()){
                bw.write("Without_Nuts\n");
                bw.write("With_Cherries");
            }      
            else{
                bw.write("Without_Nuts");
                bw.write("Without_Cherries");
            }
        }   
        catch (IOException e) {
        }//end try-catch
            
        
            
    }//end save
    //Method to restore saved choices with switch statements
    public void restore() throws IOException{
        
        //Using BufferedReader to read .txt file to an ArrayList
        try(BufferedReader br = new BufferedReader(new FileReader("ice_cream.txt"))){
            ArrayList<String> svdOrd = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
            svdOrd.add(line);
            }
            
            //Using switch statement to read the ArrayList containing Save info
            switch (svdOrd.get(0)){
                case "Chocolate":
                    rbChoc.setSelected(true);
                    break;
                case "Vanilla":
                    rbVan.setSelected(true);
                    break;
                case "Strawberry":
                    rbStraw.setSelected(true);
                    break;
            }//end flavor switch
            switch (svdOrd.get(1)){
                case "With_Nuts":
                    cbNuts.setSelected(true);
                    break;
                case "Without_Nuts":
                    cbNuts.setSelected(false);
                    break;
            }//end nuts switch
            switch (svdOrd.get(2)){
                case "With_Cherries":
                    cbCherries.setSelected(true);
                    break;
                case "Without_Cherries":
                    cbCherries.setSelected(false);
                    break;
            }//end cherries switch
        } 
        //File Not Found Error Alert
        catch (FileNotFoundException ex) {
            alert.setWidth(250.0);
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error Restoring File");
            alert.setHeaderText("Error Encountered:");
            alert.setContentText("java.io.FileNotFoundException:\n"+ex.getLocalizedMessage());
            alert.showAndWait();
        }//end catch
    }//ent restore
    public static void main(String[] args){
        
    }//end main
}
    

