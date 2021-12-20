package dal;

import be.Song;
import javafx.collections.FXCollections;

import java.sql.*;
import java.util.List;

public class daoMusic {
    private final static daoConnecter dc = new daoConnecter();

    public List<Song>getAllSongs() {
        List<Song> ListOfSong = FXCollections.observableArrayList();
        try (Connection co= dc.getConnection()){
            String sqlStatment = "SELECT * FROM ?"; //We don't have a table inside the server.
            Statement st = co.createStatement();
            if (st.execute(sqlStatment)){
                ResultSet rs = st.getResultSet();
                while (rs.next()){
                    int id = rs.getInt("id"); //name for column inside the table.
                    String artist = rs.getString("artist");
                    String title = rs.getString("title");
                    String category = rs.getString("category");
                    String filePath = rs.getString("filePath");
                    Song song = new Song(id, artist, artist, title, category, filePath);
                    ListOfSong.add(song);
                }
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return ListOfSong;
    }
    public Song addSong(int id, String artist, String title, String category, String filePath, int time){
        try (Connection co = dc.getConnection()){
            String sqlStatment = "UPDATE (?) set id = ?, set artist = ?, set title = ?, set category = ?, set filePath = ?, set time = ?;"; // We don't have a table inside the server. that's why we have question mark inside the method
            PreparedStatement ps = co.prepareStatement(sqlStatment);
            ps.setInt(1,id);
            ps.setString(2,artist);
            ps.setString(3,title);
            ps.setString(4,category);
            ps.setString(5,filePath);
            ps.setInt(6,time);
            return new Song(id, artist, title, category, filePath, time);
        }
        catch (SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    public void removeSong(Song thisSong){
        try (Connection co = dc.getConnection()){
            String sqlStatment = "DELETE FROM (?) WHERE id = ?";
            PreparedStatement ps = co.prepareStatement(sqlStatment);
            ps.setInt(1, thisSong.getId());
            ps.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }
}


