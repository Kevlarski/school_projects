
package proj4;

/**
 *
 * @author Kevin McLaughlin
 */
public class Patient {
    private String name;
    private int code;
    
    

   /*Constructors*/
    public Patient(String name, int code) {
        this.name = name;
        this.code = code;
        
    }//end ctor

    
    /*Accessors*/
    public String getName() {
        return name;
    }//end getName

    public int getCode() {
        return code;
    }//end getCode
    
    
    /*Mutators*/
    public void setName(String name) {
        this.name = name;
    }//end setName
    
    public void setCode(int code) {
        this.code = code;
    }//end setCode
    
}//end
