
public class Album {
    private String name;
    private int artistID;

    /*Constructor*/
    public Album(String name, int artistID) {
        this.name = name;
        this.artistID = artistID;
    }

    /*Accessors*/
    public String getName() {
        return name;
    }
    
    public int getArtistID() {
        return artistID;
    }

    /*Mutators*/
    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }//end setArtistID
    
    public void setName(String name) {
        this.name = name;
    }//end setName
}//end
