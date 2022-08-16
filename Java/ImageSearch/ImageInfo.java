//Kevin McLaughlin
//CIS 2353
//Summer 2022
//Prof. John P. Baugh

package prog3;

import java.util.ArrayList;

/**
 *
 * @author Kevin McLaughlin
 */
public class ImageInfo {
    private String name;
    private ArrayList<String> attributes;

    /**Parameterless Ctor. 
     * Sets fields name and attributes to null
     *
     */
    public ImageInfo(){
        this.name=null;
        this.attributes=null;
    }

    /////Mutators/////

    public void setName(String name) {
        this.name = name;
    }

    public void setAttributes(ArrayList attributes) {
        this.attributes = attributes;
    }
    
    /////Accessors/////
    
    public String getName() {
        return name;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }
    
    
    
}
