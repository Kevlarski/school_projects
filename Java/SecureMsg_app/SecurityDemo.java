
package proj1;

import java.util.Scanner;

/**
 *
 * @author Kevin McLaughlin
 */
public class SecurityDemo {
    //creating objects for use within main
    public static Scanner keyboardDemo= new Scanner(System.in);
    public static SecuritySystem secSysObj = new SecuritySystem();
    public static String choiceDemo="y";
    public static int inboxUser;
    
    /**Main method contains code for user interaction;
     * printing menu text and using Scanner to collect user input,
    * calling SecuritySystem objects and methods to interact with the user
    * @param args
    */
    public static void main(String[] args) {
       
        //while to enable continuous use
        while(choiceDemo.equalsIgnoreCase("y")){
            System.out.println("What would you like to do?\n\n"
                    + "0 - Exit Program \n1 - Send Message \n"
                    + "2 - View Inbox \n3 - View Users \n");  

            String topMenu = keyboardDemo.next();
            
            switch (topMenu) {
                case "1":
                    System.out.println("\nSend a message using the form "
                            + "\'To From Message : Key\'"
                            + "\n\n1-Max\n2-Ksenia\n3-Sally\n4-Ali\n5-Tyrone\n");
                    secSysObj.messageIn();
                    System.out.println("\nSent message from "+ secSysObj.sender+
                            " to "+secSysObj.receiver+": \""+secSysObj.messageTxt+"\"\n");
                    mainMenuReturn();
                    break;
                case "2":
                    System.out.println("\nWhich Inbox would you like to view?\n1-Max"
                            + "\n2-Ksenia\n3-Sally\n4-Ali\n5-Tyrone\n");
                    inboxUser = keyboardDemo.nextInt();
                    System.out.println("\nHello, "+secSysObj.userList.get(inboxUser)+"!");
                    System.out.println("You have " +((secSysObj.inboxHolder.get(inboxUser).size())-1)
                        + " message(s) waiting for you.");
                    System.out.println(secSysObj.getMessageSecure(inboxUser));
                    break;
                case "3":
                    System.out.println("\nThe current Users are:\n1-Max\n2-Ksenia\n"
                            + "3-Sally\n4-Ali\n5-Tyrone\n");
                    //mainMenuReturn();
                    break;
                default:
                    choiceDemo="n";
                    break;
            }//end switch
        }//end while
        System.out.println("\nThank you for using the Secure Messenger!\n");
        
    }//end main
    
    /**Asks if the user would like to do something else, 
    * changes field 'choiceDemo' to user input
    */
    public static void mainMenuReturn(){
        System.out.println("Would you like to do something else? (y/n)");
                    choiceDemo=keyboardDemo.next();
                    System.out.println("\n");
    }//end mainMenuReturn
}//end
