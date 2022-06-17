
package proj1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin McLaughlin
 */
public class SecuritySystem{

     //creating and initializing user inbox arraylists  
     //prepopulated with null at index 0 for ease of menu access
    ArrayList<SecureMessage> inboxMax = new ArrayList(){
    {add(null);}
    };
    ArrayList<SecureMessage> inboxKsenia = new ArrayList(){
    {add(null);}
    };
    ArrayList<SecureMessage> inboxSally = new ArrayList(){
    {add(null);}
    };
    ArrayList<SecureMessage> inboxAli = new ArrayList(){
    {add(null);}
    };
    ArrayList<SecureMessage> inboxTyrone = new ArrayList(){
    {add(null);}
    };
    //creating an arraylist and populating with user inboxes
    ArrayList<ArrayList<SecureMessage>> inboxHolder = new ArrayList(){
        {
        add(null);
        add(inboxMax);
        add(inboxKsenia);
        add(inboxSally);
        add(inboxAli);
        add(inboxTyrone);
        }//end add to inboxHolder
    };//end init inboxHolder
    
    //creating an arraylist of user names
    ArrayList<String> userList = new ArrayList(){
            {
            add(null);
            add("Max");
            add("Ksenia");
            add("Sally");
            add("Ali");
            add("Tyrone");
            }//end add to userList
        };//end init userList
        
    //declaring variables for use in methods
    public static Scanner keyboardSecSys;
    SecureMessage messageInst;
    String receiver;
    String sender;
    String messageTxt;
    int destName;
    int sendName;
    String messageContent;
    String passkey;
    int msgIndexNum; 
    String lineBreak = "\n";
    String msgIndexChoice;
    int userNum;
    
    /**Takes input using scanner and creates SecureMessage object using input,
    * calls msgSort() to sort the created messageInst
    */
    public void messageIn(){
        keyboardSecSys = new Scanner(System.in);
        destName = keyboardSecSys.nextInt();
        sendName = keyboardSecSys.nextInt();
        messageContent = keyboardSecSys.useDelimiter(" : ").next();
        keyboardSecSys.reset();
        passkey = keyboardSecSys.nextLine().replace(" : ", "");
        this.receiver = userList.get(destName);
        this.sender = userList.get(sendName);
        this.messageTxt = messageContent.substring(1);
        messageInst = new SecureMessage(this.receiver, this.sender, messageContent.substring(1), passkey);
        msgSort(destName);
    }//end msgIn
    
    /**Uses inboxReader to print the 'inbox' of the userNumber, 
    *takes user input to look at a message, calls keyValidator()
    *@param userNum an int(1-5) referring to a user, which inbox the user is looking at
    *@return string lineBreak(\n)
    */
    public String getMessageSecure(int userNum){
        this.userNum=userNum;
        keyboardSecSys = new Scanner(System.in);
        String choice = "y";
        
        while(choice.equals("y")){
            System.out.println("\nWhich would you like to read? (0 goes back to main menu.)\n");
            inboxReader(userNum);
            msgIndexChoice = keyboardSecSys.next();
            msgIndexNum=Integer.parseInt(msgIndexChoice);
                if(msgIndexChoice.equals("0")){
                    choice = "n";
                } //end else
                else{
                    keyValidator();
                }//end if     
        }//end while
        return lineBreak;
    }//end getMessage
    
   /**Uses switch statement to take arg destName and add the current messageInst object to a user inbox
   *@param destName a number(1-5) referring to a user
   */
    public void msgSort(int destName){
        switch(destName){
            case 1:
                inboxMax.add(messageInst);
                break;
            case 2:
                inboxKsenia.add(messageInst);
                break;
            case 3:
                inboxSally.add(messageInst);
                break;
            case 4:
                inboxAli.add(messageInst);
                break;
            case 5:
                inboxTyrone.add(messageInst);
                break;
            default:
                break;
        }//end switch
    }//end msgSort()
    
    /**Prompts user to enter a key to view a message,
    * calls getMessage() to validate the key
    */
    public void keyValidator(){
        System.out.println("\nPlease enter the key to read this message.");
        String code = keyboardSecSys.next();
        System.out.println("\n\""+inboxHolder.get(userNum).get(msgIndexNum).getMessage(code)+"\"\n");
    }//end keyValidator()
    
    /**Uses for-loop to identify index and print sourceName from stored message objects
    * in the form 'n - sourceName', where n is the index of the message in the user inbox arraylist
    *@param userNum an int corresponding to a userInbox
    */
    public void inboxReader(int userNum){
        int i;
        for(i=1;i<inboxHolder.get(this.userNum).size(); i++){
           System.out.println(i+" - From: "+ inboxHolder.get(this.userNum).get(i).getSourceName());
        } //end while 
    }//end inboxReader() 
    
}//end