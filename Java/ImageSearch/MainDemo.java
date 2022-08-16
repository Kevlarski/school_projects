//Kevin McLaughlin
//CIS 2353
//Summer 2022
//Prof. John P. Baugh

package prog3;

import java.util.Scanner;

/**
 *
 * @author Kevin McLaughlin
 */
public class MainDemo {
   
    public static void main(String[] args) {
        
        //Creating objects
        Storage test = new Storage();
        test.Storage(); //Init Storage
        String choice;
        Scanner keyboard = new Scanner(System.in);
        
        //User interface
        while(0==0){
            System.out.println("What would you like to search for? (Quit exits)");
            choice= keyboard.nextLine().toLowerCase();
            if(choice.equalsIgnoreCase("quit")){
                break;
            }//end if
            System.out.println();
            test.multiCheck(choice);
            System.out.println();
        }//end while
        keyboard.close();
    }//end main
    
}//end
