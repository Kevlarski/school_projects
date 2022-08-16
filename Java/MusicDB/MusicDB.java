import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

 
public class MusicDB {
    /*Create ArrayList objects to store DB info */
    private ArrayList<Artist>artistList = new ArrayList();
    private ArrayList<String>albumAL = new ArrayList();
    
    /**Establishes connection to SQL db
     *
     * @return connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException{
        String dbUrl="jdbc:sqlite:music_artists.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }//end getConnection
     
    /**Queries connection for list of all contained artists.
     * Creates Artist object with info from DB and adds to
     * Artist ArrayList.
     * Contains error message for SQLExceptions.
     *
     */
    public void artistSort(){
        Connection connection;
        try{
            connection=getConnection();
            Statement statement=connection.createStatement();
            
            String artistInfo="SELECT * FROM Artists";
            ResultSet resultSet = statement.executeQuery(artistInfo);
            
            while(resultSet.next()){
                Artist artist = new Artist(resultSet.getString("name"));
                artistList.add(artist);
            }//end while
            resultSet.close();
            statement.close();
            connection.close();
        }//end try
        catch(SQLException ex){
            System.out.println("Error accessing Database: " +ex.getMessage());
        }//end catch
    }//end init
    
    /**Queries connection for Album name and associated ArtistID.
     * Creates Album object with DB info, adds to Album ArrayList and to
     * the associated Artist's album list, using switch to identify proper
     * Artist. Contains error message for SQLExceptions.
     *
     */
    public void albumSort(){
        Connection connection;
        try{
            connection=getConnection();
            Statement statement=connection.createStatement();
            String albumInfo="SELECT name, artistID FROM Albums "
                    + "ORDER BY name ASC";
            
            ResultSet resultSet=statement.executeQuery(albumInfo);
            while(resultSet.next()){
                Album album = new Album(resultSet.getString("name"),
                        resultSet.getInt("ArtistID"));
                albumAL.add(album.getName());
                
                switch(album.getArtistID()){
                    case(1):
                        artistList.get(0).addAlbum(album.getName());
                        break;
                    case(2):
                        artistList.get(1).addAlbum(album.getName());
                        break;
                    case(3):
                        artistList.get(2).addAlbum(album.getName());
                        break;
                }//end switch
            }//end while
            
            resultSet.close();
            statement.close();
            connection.close();
        }//end try
        catch(SQLException ex){
            System.out.println("Error accessing Database: " +ex.getMessage());
        }//end catch
    }//end albumSort
    
    /**Prints the names of objects present in Artist and then Album lists.
     * Finally, prints each name in Artist list, followed by the Artist's
     * contained Album list printed.
     *
     */
    public void getInfo(){
        System.out.println("Artist and Album Listing");
        System.out.println("\nArtists\n-------");
        for(Artist artist:artistList){
            System.out.println(artist.getName());
        }//end for
        
        System.out.println("\nAlbums\n------");
        for(String album:albumAL){
            System.out.println(album);
        }//end for
        
        System.out.println("\nAlbums by Artist\n----------------");
        int i=0;
        while(i<artistList.size()){
            System.out.println(artistList.get(i).getName());
            
            for(var album:artistList.get(i).getAlbumsList()){
                System.out.println("\t"+album);
            }//end for
            i++;
        }//end while
    }//end getInfo
}//end