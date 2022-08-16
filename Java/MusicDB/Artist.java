
import java.util.ArrayList;


public class Artist {
    private String name;
    private ArrayList<String> albums = new ArrayList();

    /**Constructor
     *
     * @param name String containing the Artist's name
     */
    public Artist(String name) {
        this.name = name;
    }
         
    /*Mutators*/
    public void setName(String name) {
        this.name = name;
    } 
        
    public void addAlbum(String album){
        albums.add(album);
    }
    
    /*Accessors*/
    public String getName() {
        return name;
    }
    
    public ArrayList getAlbumsList(){
        return this.albums;
    }
    
    /**Loops through album list returning stored names
     *
     * @return String holding album name
     */
    public String getAlbums() {
        for(String album:albums){
            return album;
        }
        return null;
    }

}
