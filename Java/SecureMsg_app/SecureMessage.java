
package proj1;

/**
 *
 * @author Kevin McLaughlin
 */
public class SecureMessage {
    
    //fields to store message data
    private String message;
    private String sourceName;
    private String destName;
    private String key;
    
    //ctor
    public SecureMessage(String destName, String sourceName, String message,
            String key){
        this.message = message;
        this.sourceName = sourceName;
        this.destName = destName;
        this.key = key;  
    }//end ctor
    
    //authenticator for messages
    public String getMessage(String potentialKey){
        if(potentialKey.equals(key)){
            return message;
        }
        else{
            return "Your key doesn't match the stored key, try again.";
        }   
    }//end getMessage
    
    public String getSourceName(){
        return sourceName;
    }//end getSourceName
    
    public String getDestName(){
        return destName;
    }//end getDestName
}//end
